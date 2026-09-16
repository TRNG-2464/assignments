# AWS Mini Project | Cloud Project Upload

In this activity you will take your previously built full-stack web app (Spring Boot backend, PostgreSQL database, React single-page frontend) and deploy it onto AWS using EC2, RDS, and S3.

Each **Checkpoint** is meant to represent a touchpoint for you to confirm your setup/completion of previous steps before moving forward.

## Objectives

By the end of this activity, you should be able to:

- Create and secure an AWS account, including an IAM user for day-to-day work instead of the root login
- Launch and configure an EC2 instance to host a Spring Boot backend
- Launch and configure an RDS PostgreSQL instance and connect it securely to the backend
- Configure security groups so only the intended traffic reaches each service
- Host a React single-page app on S3 as a public static website
- Deploy their own already-built full-stack project end-to-end on AWS and verify it works
- Identify what's covered under AWS Free Tier and shut services down to avoid unexpected charges

## Prerequisites

- A completed full-stack project: a Spring Boot backend (packaged as a runnable JAR), a PostgreSQL schema/data the app expects, and a React frontend that has already been built for production (`npm run build`)
- A credit or debit card to create the AWS account (required even for Free Tier)
- Basic command line familiarity, including SSH
- An IDE and the ability to rebuild/repackage the project if a config value (like a database URL) needs to change

## Step 1: Create an AWS account and an IAM user

1. Sign up for an AWS account at aws.amazon.com using a work or personal email; this becomes the **root user** and has unrestricted access, so it should not be used day-to-day.
2. Set up a **budget alert** in AWS Budgets (e.g. alert at $1 or $5) so you're notified immediately if anything moves outside Free Tier.
3. Enable **multi-factor authentication (MFA)** on the root account.
4. In **IAM**, create a new IAM user for yourself with **AdministratorAccess** for this training exercise, and sign in as that user going forward instead of the root account.
5. Note your AWS **region** (e.g. `us-east-1`) — every resource in this activity should be created in the same region so they can reach each other easily.

**Checkpoint:** You're signed in as an IAM user (not root), MFA is enabled on the root account, and a budget alert is configured.

## Step 2: Launch an EC2 instance for the backend

1. In the EC2 console, launch a new instance using a **Free Tier eligible** Amazon Linux image and a `t2.micro` (or `t3.micro`, whichever is Free Tier eligible in your region) instance type.
2. Create (or reuse) a **key pair** and download the `.pem` file — this is your only way to SSH in, so keep it somewhere safe.
3. Create a **security group** for this instance with these inbound rules:
   - SSH (port 22) from **your IP only** (not `0.0.0.0/0`)
   - Custom TCP on whatever port your Spring Boot app listens on (e.g. 8080), from **anywhere** (`0.0.0.0/0`), so the React app and browser can reach the API
4. Launch the instance and wait for its status checks to pass.
5. SSH into the instance using the key pair and the instance's public IP or public DNS.
6. Install a Java runtime matching what your Spring Boot app was built with (e.g. 17 or 21).
7. Transfer your built Spring Boot JAR to the instance (`scp` using the same key pair works well).

**Checkpoint:** You can SSH into the EC2 instance, Java is installed, and your JAR file is present on the instance — but not started yet (it needs the database from Step 3 first).

## Step 3: Launch an RDS PostgreSQL instance

1. In the RDS console, create a new database using the **PostgreSQL** engine and the **Free Tier** template (`db.t3.micro` or `db.t4g.micro`, single-AZ, no Multi-AZ, minimal storage).
2. Set a master username and password, and note the initial database name.
3. Create a **security group** for the database with one inbound rule: PostgreSQL (port 5432) from the **EC2 instance's security group** as the source — not your IP, not "anywhere." This means only the backend server can reach the database directly.
4. Leave the database **not publicly accessible** - the EC2 instance is the only thing that should be able to reach it.
5. Once the instance is available, note its **endpoint** (hostname) — you'll need it for the Spring Boot connection string.
6. From the EC2 instance (not your laptop), test connectivity to the database on port 5432 to confirm the security group rule works before wiring up the app.

**Checkpoint:** The RDS instance shows as "Available," and the EC2 instance can reach it on port 5432, but your laptop cannot connect to it directly.

## Step 4: Deploy the backend and connect it to RDS

1. Update the Spring Boot app's database connection settings (`spring.datasource.url`, username, password) to point at the RDS endpoint from Step 3, and rebuild the JAR.
2. Re-transfer the updated JAR to the EC2 instance (or, better, externalize the database settings as environment variables on EC2 so you don't have to rebuild the JAR for connection changes).
3. On the EC2 instance, run the app (e.g. `java -jar app.jar`), ideally in a way that survives your SSH session ending — a background process with `nohup`, or a proper `systemd` service if time allows.
4. Check the application logs on EC2 to confirm it started and connected to the database without errors.
5. From your laptop's browser (or `curl`), hit a simple backend endpoint using the EC2 instance's public IP and port (e.g. `http://<ec2-public-ip>:8080/...`) to confirm the API is reachable from outside.

**Checkpoint:** The Spring Boot app is running on EC2, has successfully connected to the RDS database, and responds to a request made from outside the EC2 instance.

## Step 5: Host the React frontend on S3

1. If not already done, update the React app's API base URL to point at the EC2 backend's public IP/port from Step 4, then rebuild it (`npm run build`).
2. Create a new **S3 bucket** with a globally unique name (bucket names are shared across all AWS accounts).
3. Turn **off** "Block all public access" for this bucket — a public static website needs public read access to its files. This is safe here only because the bucket holds nothing but static frontend assets, no secrets or backend logic.
4. Enable **Static website hosting** on the bucket, setting the index document (usually `index.html`); for a single-page app, also set the error document to `index.html` so client-side routing works correctly.
5. Add a **bucket policy** granting public `s3:GetObject` on all objects in the bucket.
6. Upload the contents of the React build output folder (e.g. everything inside `build/` or `dist/`) to the bucket root.
7. Open the bucket's static website endpoint URL (shown on the bucket's Properties tab) in a browser.

**Checkpoint:** The React app loads from the S3 website endpoint URL, and refreshing on a non-root route doesn't break.

## Step 6: Wire it together and test end-to-end

1. Because the React app (served from the S3 website endpoint) and the API (served from EC2) are on different origins, add a **CORS** configuration to the Spring Boot app allowing requests from the S3 website endpoint's origin, then rebuild and redeploy the backend if this wasn't already in place.
2. Reload the React app from its S3 URL and exercise the features that call the backend (the ones that read/write data through the API to the database).
3. Open the browser's developer tools (Network/Console tabs) to confirm requests are succeeding and to debug any CORS or connection errors if they appear.
4. Confirm data written through the app is actually persisted by checking it from the RDS side, or by reloading and seeing it again.

**Checkpoint:** A user can open the S3 website URL, interact with the React app, and see it successfully create/read data through the EC2-hosted API into the RDS database — the full stack, working end-to-end on AWS.

## Cost management: Free Tier and shutting down

Everything in this activity is sized to fit within AWS Free Tier — but Free Tier is time-bound and usage-bound, so it's easy to drift outside it without noticing if instances are left running longer than intended.

- **When you're done for the day:** **stop** the EC2 instance and **stop** the RDS instance from their respective consoles. This pauses compute charges, but stopped instances are not the same as terminated ones — RDS storage and any EC2 EBS volume still incur a small storage cost even while stopped.
- **When you're fully done with the exercise:** terminate the EC2 instance, delete the RDS instance (skip the final snapshot only if you don't need the data anymore), and empty and delete the S3 bucket. Only a full teardown stops all charges completely.
- Check the **AWS Billing Dashboard** and the Free Tier usage page periodically during the activity to confirm you're still within limits.

**Checkpoint:** You know where to stop each service when you're done for the day, and where to fully tear them down — terminate, delete, empty and delete — once the exercise is complete.
