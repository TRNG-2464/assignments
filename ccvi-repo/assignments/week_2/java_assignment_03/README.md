# Traffic Light Simulator

A Java console application that simulates traffic light state transitions. This project demonstrates the use of modern Java `switch` expressions, modulo arithmetic for cyclical logic, and interactive command-line input handling.

## Features

* **Core Simulation:** Calculates the final state of a traffic light cycle (Green → Yellow → Red) after a given number of elapsed ticks.
* **Interactive CLI:** Prompts users for starting colors and tick counts sequentially, with built-in validation and a graceful `exit` command.
* **Stretch Goals Implemented:**
  * **Full Cycle Log:** Generates an array representing every color the light passes through during the specified ticks.
  * **Variable Duration Lights:** Accounts for different time weights per color (e.g., Green lasts 3 ticks, Yellow 1 tick, Red 2 ticks) using a 6-tick cycle pattern.
  * **Custom Exception Handling:** Employs `IllegalArgumentException` and `IllegalStateException` for strict programmatic error management.

## Prerequisites

* **Java Development Kit (JDK) 17** or higher.

## Getting Started

1. **Compile the program:**
   Open your terminal, navigate to the directory containing `TrafficLightSimulator.java`, and run:
   ```bash
   javac TrafficLightSimulator.java
   ```

2. **Execute the program:**
   Run the compiled class using:
   ```bash
   java TrafficLightSimulator
   ```

## Example Interaction

```text
--- Traffic Light Simulator ---
Type 'exit' at any prompt to quit.

Enter starting color (e.g., Green, Yellow, Red): Green
Enter number of ticks: 1
Output: "Yellow"

Enter starting color (e.g., Green, Yellow, Red): Red
Enter number of ticks: 5
Output: "Yellow"

Enter starting color (e.g., Green, Yellow, Red): Purple
Enter number of ticks: 2
Output: "Invalid input: 'Purple' is not a recognized light color."

Enter starting color (e.g., Green, Yellow, Red): exit
Exiting...
```

## Project Structure

* `main()`: Handles the `Scanner` input loop and basic string validation.
* `simulateLight()`: Contains the core modulo arithmetic logic for uniform tick transitions.
* `fullCycleLog()`: Stretch goal method for returning transition histories.
* `variableDurationLight()`: Stretch goal method incorporating weighted durations.
* `simulateLightWithExceptions()`: Stretch goal method demonstrating strict exception throwing for invalid states.
