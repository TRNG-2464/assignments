# Elevator Weight Limit Checker

## Overview
The **Elevator Weight Limit Checker** is a Java console application that evaluates a queue of passenger weights against a specified elevator weight capacity. It calculates the running total of weights as passengers board one at a time and immediately detects if a passenger causes the elevator to meet or exceed its safety limit. 

## Features
* **Core Weight Checking**: Iterates through a collection of weights and stops processing immediately upon detecting an overload.
* **Interactive CLI**: Uses an interactive, loop-based menu allowing users to continuously check different limits and passenger groups without restarting the program.
* **Graceful Edge Case Handling**: Safely manages empty inputs and scenarios where the first passenger alone exceeds the weight limit.

## Stretch Goals Implemented
This project also includes the following advanced analyses (which can be toggled via the interactive menu):
1. **Maximum Safe Passenger Count**: Determines the maximum number of passengers from the given input array that could board the elevator safely.
2. **Heaviest and Lightest Passengers**: Identifies the minimum and maximum weights among the passengers who successfully boarded (including the passenger who triggered an overload).
3. **Multiple Elevator Trips**: Groups the entire line of passengers into consecutive, safe elevator trips while preserving their original order in line.

## Prerequisites
* Java Development Kit (JDK) 17 or higher.

## How to Run

1. Compile the Java file from your terminal:
   ```bash
   javac ElevatorWeightLimitChecker.java
   ```
2. Execute the compiled class:
   ```bash
   java ElevatorWeightLimitChecker
   ```
3. Follow the on-screen prompts to input the weight limit and passenger weights.

## Example Interactions

**Example 1 — Overload occurs**
```text
Input: weightLimit = 1000, passengerWeights = [150, 200, 300, 250, 180]
Output: "Passenger 5 caused an overload. Total weight at that point: 1080 lbs."
```

**Example 2 — All passengers board safely**
```text
Input: weightLimit = 1000, passengerWeights = [150, 200, 300]
Output: "All passengers boarded safely. Total weight: 650 lbs."
```

**Example 3 — Exact match counts as overload**
```text
Input: weightLimit = 500, passengerWeights = [200, 300]
Output: "Passenger 2 caused an overload. Total weight at that point: 500 lbs."
```
