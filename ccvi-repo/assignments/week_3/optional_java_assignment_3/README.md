# Best Time to Buy and Sell Stock

## Overview
This project is a Java implementation of the "Best Time to Buy and Sell Stock" optimization problem. The application processes an array of stock prices to determine the maximum profit achievable from a single buy and a subsequent sell transaction. 

## Features
* **Core Logic:** Computes the maximum achievable profit in a highly efficient single pass. Returns `0` if no profitable transaction is possible.
* **Continuous Interactive CLI:** Accepts user input (comma-separated or space-separated integers) in a continuous loop until the user types `exit`.
* **Stretch Goal 1 (Identify Transaction Days):** Calculates and prints the specific buy and sell prices that yield the maximum profit, matching the required output format.
* **Stretch Goal 2 (Two Purchases, One Sell):** Evaluates a hypothetical strategy of buying on two different days prior to selling on a single later day to compare profitability against the single-purchase strategy.

## Prerequisites
* Java Development Kit (JDK) 21 or higher installed on your system.

## Setup and Execution

1. Open your terminal or command prompt and navigate to the directory containing the file.
2. Compile the Java file using the following command:
   ```bash
   javac StockProfitCalculator.java
   ```
3. Run the compiled class:
   ```bash
   java StockProfitCalculator
   ```

## Example Interaction

```text
Enter prices separated by spaces or commas (or type 'exit' to quit).
> 7 1 5 3 6 4
Input: [7, 1, 5, 3, 6, 4]
Output: 5
(Buy on the day priced at 1, sell on the day priced at 6.)

> 7, 6, 4, 3, 1
Input: [7, 6, 4, 3, 1]
Output: 0

> 2 4 1
Input: [2, 4, 1]
Output: 2
(Buy on the day priced at 2, sell on the day priced at 4.)

> exit
Exiting program.
```
