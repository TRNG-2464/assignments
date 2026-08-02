# Order Processing System

## Objective

Practice designing a custom exception hierarchy — two top-level custom exceptions, each with more specific subclasses beneath them — and using that hierarchy to catch errors at different levels of specificity: catching a specific subtype versus catching its broader parent type.

## Instructions

- Define two top-level custom exception classes, both extending `Exception`:
  - `InventoryException`
  - `PaymentException`
- Define the following subclasses:
  - Extending `InventoryException`:
    - `OutOfStockException` — thrown when an order requests more of an item than is currently available in stock
    - `InvalidQuantityException` — thrown when an order requests a zero or negative quantity of an item
  - Extending `PaymentException`:
    - `PaymentDeclinedException` — thrown when a simulated payment amount is less than the order's total cost
    - `PaymentExpiredException` — thrown when a simulated payment method is marked as expired
- Each custom exception should provide a clear, descriptive message explaining what went wrong.
- Write a method that processes a single simulated order. It should accept an item name, a requested quantity, the available stock for that item, a payment amount, the order's total cost, and whether the payment method is expired.
  - Validate inventory-related rules first:
    - If the requested quantity is zero or negative, throw `InvalidQuantityException`
    - If the requested quantity exceeds the available stock, throw `OutOfStockException`
  - Then validate payment-related rules:
    - If the payment method is expired, throw `PaymentExpiredException`
    - If the payment amount is less than the order's total cost, throw `PaymentDeclinedException`
  - If all validations pass, report a successful order confirmation, including the item name and quantity ordered.
- In your driving code (e.g., `main`), call this method with several different simulated orders, each designed to trigger a different outcome (each type of exception, as well as at least one successful order).
- Demonstrate catching these exceptions at **both levels of specificity** across your driving code:
  - At least one `catch` block that catches a specific subclass (for example, `OutOfStockException`) and handles it with a tailored message
  - At least one `catch` block that catches the broader parent type (for example, `PaymentException`) and handles any of its subclasses more generically
  - **Important:** in Java, a `catch` block for a subclass must appear *before* a `catch` block for its parent class in the same `try` statement, or the code will not compile. Keep this in mind when deciding which exceptions you catch specifically versus generically within the same `try` block.

## Example Interactions

**Example 1 — Out of stock**
```
Input: item = "Widget", requestedQty = 5, availableStock = 2, paymentAmount = 50.00, orderCost = 50.00, isExpired = false
Output: "Order failed: Out of stock. Requested 5, but only 2 available."
```

**Example 2 — Invalid quantity**
```
Input: item = "Widget", requestedQty = -1, availableStock = 10, paymentAmount = 50.00, orderCost = 50.00, isExpired = false
Output: "Order failed: Invalid quantity. Quantity must be greater than 0."
```

**Example 3 — Payment declined**
```
Input: item = "Widget", requestedQty = 2, availableStock = 10, paymentAmount = 10.00, orderCost = 50.00, isExpired = false
Output: "Order failed: Payment declined. Insufficient funds."
```

**Example 4 — Payment expired**
```
Input: item = "Widget", requestedQty = 2, availableStock = 10, paymentAmount = 50.00, orderCost = 50.00, isExpired = true
Output: "Order failed: Payment method expired."
```

**Example 5 — Successful order**
```
Input: item = "Widget", requestedQty = 2, availableStock = 10, paymentAmount = 50.00, orderCost = 50.00, isExpired = false
Output: "Order successful! 2 x Widget confirmed."
```

## Requirements Checklist

- [ ] `InventoryException` and `PaymentException` are defined as top-level custom exceptions, extending `Exception`
- [ ] `OutOfStockException` and `InvalidQuantityException` both extend `InventoryException`
- [ ] `PaymentDeclinedException` and `PaymentExpiredException` both extend `PaymentException`
- [ ] Each custom exception provides a clear, descriptive message
- [ ] Order processing method correctly validates inventory rules before payment rules
- [ ] Each validation failure throws the correct, specific exception subclass
- [ ] A successful order (passing all validations) is clearly reported
- [ ] Driving code calls the order method with inputs that trigger each of the four exception types, plus at least one successful order
- [ ] Driving code includes at least one `catch` block for a specific exception subclass, with tailored handling
- [ ] Driving code includes at least one `catch` block for a broader parent exception type, with generic handling
- [ ] Catch blocks are ordered correctly within any `try` statement that catches both a subclass and its parent (subclass first)

## Stretch Goals

Each stretch goal should be implemented as its own separate method (or set of methods) — do not modify your original order-processing method to accommodate these. Your original solution should remain intact and callable on its own.

- **Custom Fields on Exceptions** — Add custom fields to at least one exception class (for example, `OutOfStockException` could carry the requested quantity and the available quantity as fields, accessible via getter methods), and update your `catch` block for that exception to use those fields when building its error message, rather than relying only on the exception's message string.
- **Batch Order Processing with a Summary Report** — Write a new method that accepts a list of multiple simulated orders and processes them one at a time in a loop, continuing on to the next order even after a failure (rather than stopping the whole batch). After processing all orders, print a summary report showing how many orders succeeded, how many failed, and a breakdown of failures by exception type.
