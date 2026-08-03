# Vending Machine Change Maker

## Overview

This project is a Java implementation of a Vending Machine Change Maker. It evaluates item prices and inserted funds to process transactions, calculate change, handle insufficient funds, and validate inputs. The application features a fully interactive, menu-driven console interface for testing all core functionalities and stretch goals.

## Features

### Core Capabilities
*   **Transaction Processing:** Accepts item price and amount inserted.
*   **Input Validation:** Rejects negative prices and negative inserted amounts with clear error messages.
*   **Fund Evaluation:** Determines if the inserted amount is sufficient. If not, it calculates and outputs the remaining balance needed.
*   **Change Calculation:** Computes the exact change due upon a successful purchase, outputting $0.00 if exact change is provided.

### Stretch Goals Implemented
*   **Multiple Items / Running Total:** Accepts a continuous list of item prices, calculates the running total, and evaluates it against the provided funds.
*   **Making Change in Denominations:** Takes a change amount and breaks it down into the fewest number of standard US denominations ($1.00, $0.25, $0.10, $0.05, $0.01).

## Getting Started

### Prerequisites
*   Java Development Kit (JDK) 17 or higher installed on your machine.

### Running the Code
1.  Save the Java code to a file named `VendingMachineChangeMaker.java`.
2.  Open your terminal or command prompt.
3.  Compile the code using the `javac` compiler:
    ```bash
    javac VendingMachineChangeMaker.java
    ```
4.  Run the compiled class:
    ```bash
    java VendingMachineChangeMaker
    ```

### Interactive Commands
*   **`1-4`**: Select options from the main menu.
*   **`q` or `quit`**: Enter at the main menu to power down and exit the application.
*   **`d`**: Enter during the Multiple Items transaction (Option 2) to indicate you are done adding items and are ready to pay.

## Example Output

```text
=== Welcome to the Vending Machine Change Maker ===

Main Menu:
1. Single Item Transaction (Core)
2. Multiple Items Transaction (Stretch Goal 1)
3. Make Change in Denominations (Stretch Goal 2)
4. Quit
Select an option (1-4): 1

--- Single Item Transaction ---
Enter item price: 1.50
Enter amount inserted: 2.00

Input: price = 1.50, amountInserted = 2.00
Output: "Purchase successful. Change due: $0.50"
