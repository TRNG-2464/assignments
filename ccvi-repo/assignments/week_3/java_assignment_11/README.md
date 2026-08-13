# Closest Value in Array

## Overview
This is a Java console-based application designed to iterate through an unsorted array of positive integers and find the value numerically closest to a specified target. The project demonstrates linear scanning, difference calculations, and consistent tie-breaking logic without relying on pre-sorting the data for its primary function.

## Features
* **Interactive Mode:** Continuously prompts for arrays and target values until the user types `exit`.
* **Primary Requirement:** Finds the closest value to a target. In the event of a tie (two numbers equally close), it consistently returns the smaller value.
* **Stretch Goal 1 - Closest 'K' Values:** Returns an array of the top `k` closest values.
* **Stretch Goal 2 - Farthest Match:** Identifies the value numerically farthest from the target, using the same tie-breaking logic.
* **Stretch Goal 3 - Higher/Lower Flag:** An overloaded method that accepts a boolean flag to reverse the tie-breaking logic (returning the larger value in a tie when set to `true`).

## Prerequisites & Environment
* **Java Development Kit (JDK):** Version 21 or higher.

## Usage

1. Compile the Java file:
   ```bash
   javac ClosestValueFinder.java
   ```

2. Run the application:
   ```bash
   java ClosestValueFinder
   ```

3. Follow the on-screen prompts:
   * Enter a space-separated list of positive integers (e.g., `4 9 1 15 8`).
   * Enter a target integer (e.g., `10`).
   * Review the output for the primary closest value and the implemented stretch goals.
   * Type `exit` at the initial prompt to gracefully terminate the application.

## Error Handling
The interactive loop includes basic exception handling. If a non-integer value is accidentally entered during the input phase, the application will catch the `NumberFormatException`, notify the user, and safely loop back to the initial prompt without crashing.
