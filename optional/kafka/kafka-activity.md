# Kafka Hands-On: Multi-Broker Cluster + Spring Producer/Consumer

In this activity you will stand up a 3-broker Kafka cluster with Docker and wire a Spring Kafka application to produce and consume messages against it.

Each **Checkpoint** is meant to represent a touchpoint for you to confirm your setup/completion of previous steps before moving forward.

## Objectives

By the end of this activity, you should be able to:

- Explain what a Kafka broker is and why a cluster typically runs more than one
- Stand up a multi-broker Kafka cluster locally using Docker
- Distinguish between a broker's internal and external listener ports
- Configure a Spring Boot application as both a Kafka producer and a Kafka consumer
- Verify that a message published by the producer is received by the consumer, including which broker handled it

## Step 1: Install and verify Docker

1. Install Docker Desktop (Windows/macOS) or Docker Engine + Docker Compose plugin (Linux) for your OS.
2. Start Docker and confirm it's running (system tray icon, or a status command).
3. Open a terminal and confirm the Docker CLI and Compose plugin both respond to a version check.
4. Run a simple test container (e.g. the standard "hello-world" image) to confirm Docker can pull and run images from Docker Hub.

**Checkpoint:** Docker is installed and can successfully pull and run a container before moving on.

## Step 2: Stand up three Kafka brokers on different ports

This exercise uses **KRaft mode** — each broker also acts as its own controller, which keeps the compose file simpler for local training.

Create a project folder for the cluster and save this as `docker-compose.yml`:

```yaml
services:
  kafka-1:
    image: apache/kafka:3.7.0
    container_name: kafka-1
    ports:
      - "9092:9092"
    environment:
      KAFKA_NODE_ID: 1
      KAFKA_PROCESS_ROLES: broker,controller
      KAFKA_LISTENERS: PLAINTEXT://:19092,CONTROLLER://:19093,EXTERNAL://:9092
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka-1:19092,EXTERNAL://localhost:9092
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,CONTROLLER:PLAINTEXT,EXTERNAL:PLAINTEXT
      KAFKA_CONTROLLER_LISTENER_NAMES: CONTROLLER
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_CONTROLLER_QUORUM_VOTERS: 1@kafka-1:19093,2@kafka-2:19093,3@kafka-3:19093
      CLUSTER_ID: "MkU3OEVBNTcwNTJENDM2Qk"

  kafka-2:
    image: apache/kafka:3.7.0
    container_name: kafka-2
    ports:
      - "9093:9092"
    environment:
      KAFKA_NODE_ID: 2
      KAFKA_PROCESS_ROLES: broker,controller
      KAFKA_LISTENERS: PLAINTEXT://:19092,CONTROLLER://:19093,EXTERNAL://:9092
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka-2:19092,EXTERNAL://localhost:9093
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,CONTROLLER:PLAINTEXT,EXTERNAL:PLAINTEXT
      KAFKA_CONTROLLER_LISTENER_NAMES: CONTROLLER
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_CONTROLLER_QUORUM_VOTERS: 1@kafka-1:19093,2@kafka-2:19093,3@kafka-3:19093
      CLUSTER_ID: "MkU3OEVBNTcwNTJENDM2Qk"

  kafka-3:
    image: apache/kafka:3.7.0
    container_name: kafka-3
    ports:
      - "9094:9092"
    environment:
      KAFKA_NODE_ID: 3
      KAFKA_PROCESS_ROLES: broker,controller
      KAFKA_LISTENERS: PLAINTEXT://:19092,CONTROLLER://:19093,EXTERNAL://:9092
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka-3:19092,EXTERNAL://localhost:9094
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,CONTROLLER:PLAINTEXT,EXTERNAL:PLAINTEXT
      KAFKA_CONTROLLER_LISTENER_NAMES: CONTROLLER
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_CONTROLLER_QUORUM_VOTERS: 1@kafka-1:19093,2@kafka-2:19093,3@kafka-3:19093
      CLUSTER_ID: "MkU3OEVBNTcwNTJENDM2Qk"
```

NOTE: The `CLUSTER_ID` is not technically required, but it is included for KRaft mode's quorum to agree on the same cluster ID. The `CLUSTER_ID` can be any fixed base64-ish string, all three brokers just need to share the same one. Bring the cluster up and watch the logs briefly:

```bash
docker compose up -d
docker compose logs -f
```

**Checkpoint:** All three broker containers show as running (`docker compose ps`), and none are restarting or exiting.

## Step 3: Verify the cluster

1. List running containers and confirm all three broker containers are up and healthy.
2. From inside one broker's container (or using a local Kafka CLI install), run a command to list existing topics against each broker's port to confirm each one answers.
3. Create a test topic with a replication factor of 3 and multiple partitions, specifying one broker's address as the connection point.
4. Describe that topic and confirm the output shows partitions distributed with leaders and replicas spread across all three broker IDs — this proves the brokers are actually clustered together, not three isolated single-node brokers.
5. Delete the test topic once confirmed (or leave it if you'd like to reuse it in Step 5–7).

**Checkpoint:** The topic description shows replicas across all three broker IDs, not just one.

## Step 4: Scaffold a Spring Boot Kafka project

1. Generate a new Spring Boot project (Spring Initializr or your IDE) with the **Spring for Apache Kafka** dependency and **Spring Web** (needed for the REST trigger in Step 5).
2. Decide on a topic name the app will use and note it somewhere shared (e.g. `training-topic`) so producer and consumer agree on it.
3. Add the Kafka connection settings. Use whichever config file your project already has

`application.yml`:
```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9092,localhost:9093,localhost:9094
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
    consumer:
      group-id: training-consumer-group
      auto-offset-reset: earliest
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer

app:
  kafka:
    topic: training-topic
```

or the `application.properties` equivalent:
```properties
spring.kafka.bootstrap-servers=localhost:9092,localhost:9093,localhost:9094
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.consumer.group-id=training-consumer-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer

app.kafka.topic=training-topic
```

4. Confirm the project builds and runs with no Kafka connection yet attempted (an empty controller or main class is fine at this point).

**Checkpoint:** The Spring Boot app starts cleanly with the Kafka dependency and bootstrap-servers configuration in place, pointing at all three broker ports.

## Step 5: Build the producer

1. Add a producer configuration bean (or rely on Spring Boot's auto-configuration from Step 4) that defines how keys and values are serialized.
2. Autowire Spring Kafka's template object for sending messages into a service or `@RestController` class.
3. Write a method that sends a message to the agreed-upon topic, optionally with a key (useful later for reasoning about partitioning).
4. Expose the trigger as a **REST POST endpoint** that accepts a message body, e.g. `POST /api/messages` taking a small JSON payload like `{"message": "hello kafka"}`, and have the controller hand that message off to the producer.
5. Add basic logging so the associate can see each message the app attempts to send, along with success/failure.
6. Use **Postman** to test the endpoint: create a POST request to `http://localhost:8080/api/messages`, set the body to raw JSON, and send it. A `200`/`202` response plus a success log line confirms the send worked.

**Checkpoint:** Posting from Postman logs a successful send acknowledgment with no connection errors.

## Step 6: Build the consumer

1. Configure consumer-side deserializers matching the serializers used by the producer, and set a consumer group ID.
2. Write a listener method annotated to subscribe to the same topic the producer writes to.
3. Have the listener log the message payload, and optionally the partition and offset it was read from — this becomes useful evidence in Step 7 for seeing the cluster in action.
4. Decide on an offset reset policy (e.g. read from the beginning vs. only new messages) so behavior is predictable when the consumer restarts.
5. Run the application and confirm the consumer connects and is assigned partitions without errors.

**Checkpoint:** Application logs show the consumer has joined its group and been assigned partitions.

## Step 7: Run everything end-to-end

1. Confirm all three broker containers are still running.
2. Start the Spring Boot application (producer and consumer both live in the same app for this exercise).
3. Send a few messages to your API to trigger the producer to send a few messages.
4. Confirm the consumer's logs show each message being received, ideally with partition/offset info visible.

**Checkpoint:** Messages flow producer → topic → consumer end-to-end.

## Stretch goals

- Add a second topic and a second listener method to practice routing by topic
- Experiment with multiple partitions and multiple consumer instances in the same group to observe partition rebalancing
- Send a custom object (not just a string) using a JSON serializer/deserializer
- Add error handling for deserialization failures (e.g. a dead-letter topic)
