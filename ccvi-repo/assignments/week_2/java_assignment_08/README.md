# Order Processing System

A Java console application designed to demonstrate custom exception hierarchies, precise exception handling strategies (specific subclasses versus broader parent types), interactive terminal workflows, and batch order processing.

## Objective

This project practices designing a custom exception hierarchy—featuring two top-level custom exceptions with specific subclasses beneath them—and using that hierarchy to catch errors at varying levels of specificity.

---

## Exception Hierarchy

- `java.lang.Exception`
  - `InventoryException`
    - `OutOfStockException` (Includes custom fields for requested vs. available quantities)
    - `InvalidQuantityException`
  - `PaymentException`
    - `PaymentDeclinedException`
    - `PaymentExpiredException`

---

## Features & Implementation Details

- **Interactive Terminal Workflow:** Prompts the user step-by-step for single order validations (`item`, `requestedQty`, `availableStock`, `paymentAmount`, `orderCost`, `isExpired`) with built-in `"exit"` command handling.
- **Batch Processing & Summary Report (Stretch Goal):** Loops through a predefined collection of multi-outcome orders, guarantees continuation past failures, and outputs a statistical breakdown by exception type.
- **Custom Fields on Exceptions (Stretch Goal):** `OutOfStockException` carries state fields (`requested` and `available`) accessed via getter methods to build tailored error messages.
- **Proper Catch Ordering:** Adheres to Java compiler requirements by placing specific exception subclasses before their broader parent types (`InventoryException` / `PaymentException`).

---

## Example Interactions

**Example 1 — Out of stock**
* **Input:** `item = "Widget", requestedQty = 5, availableStock = 2, paymentAmount = 50.00, orderCost = 50.00, isExpired = false`
* **Output:** `"Order failed: Out of stock. Requested 5, but only 2 available."`

**Example 2 — Invalid quantity**
* **Input:** `item = "Widget", requestedQty = -1, availableStock = 10, paymentAmount = 50.00, orderCost = 50.00, isExpired = false`
* **Output:** `"Order failed: Invalid quantity. Quantity must be greater than 0."`

**Example 3 — Payment declined**
* **Input:** `item = "Widget", requestedQty = 2, availableStock = 10, paymentAmount = 10.00, orderCost = 50.00, isExpired = false`
* **Output:** `"Order failed: Payment declined. Insufficient funds."`

**Example 4 — Payment expired**
* **Input:** `item = "Widget", requestedQty = 2, availableStock = 10, paymentAmount = 50.00, orderCost = 50.00, isExpired = true`
* **Output:** `"Order failed: Payment method expired."`

**Example 5 — Successful order**
* **Input:** `item = "Widget", requestedQty = 2, availableStock = 10, paymentAmount = 50.00, orderCost = 50.00, isExpired = false`
* **Output:** `"Order successful! 2 x Widget confirmed."`

---

## How to Compile and Run

1. Save the source code into a file named `OrderProcessor.java`.
2. Compile the program using the Java compiler:
   ```bash
   javac OrderProcessingSystem.java
   ```
3. Run the executable class:
   ```bash
   java OrderProcessingSystem
   ```
