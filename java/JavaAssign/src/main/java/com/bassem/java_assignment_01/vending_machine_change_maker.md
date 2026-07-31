# Vending Machine Change Maker

## Objective

Practice input validation using conditional logic, basic arithmetic, and returning clear, distinct outcomes based on multiple possible conditions.

## Instructions

- Write a method that accepts two parameters: the price of an item and the amount of money inserted by the customer.
- Your method should evaluate the inputs and determine one of the following outcomes:
  - **Invalid input** — if the item price is negative, or the amount inserted is negative, the inputs are invalid. Your method should return a clear string message describing the problem rather than attempting to calculate a result.
  - **Insufficient funds** — if the amount inserted is less than the item price, the method should return a clear string message reporting that more money is needed, along with how much additional money is required.
  - **Successful purchase** — if the amount inserted meets or exceeds the item price, return a message reporting that the purchase was successful and calculate the change owed (amount inserted minus price). An amount inserted that exactly matches the price is a successful purchase with $0.00 in change.
- You may use `double` values to represent money for this activity. Be aware that floating-point arithmetic can introduce small rounding errors (for example, `0.1 + 0.2` does not always equal exactly `0.3` in Java) — this is a known limitation you should be aware of, but resolving it is not a requirement for the base activity.
- Your method should clearly communicate which of the three outcomes occurred, along with the relevant number (amount still needed, or change owed) where applicable.

## Example Interactions

**Example 1 — Successful purchase with change**
```
Input: price = 1.50, amountInserted = 2.00
Output: "Purchase successful. Change due: $0.50"
```

**Example 2 — Insufficient funds**
```
Input: price = 1.50, amountInserted = 1.00
Output: "Insufficient funds. Please insert $0.50 more."
```

**Example 3 — Exact payment, no change**
```
Input: price = 1.50, amountInserted = 1.50
Output: "Purchase successful. Change due: $0.00"
```

**Example 4 — Invalid input**
```
Input: price = 1.50, amountInserted = -1.00
Output: "Invalid input: amount inserted cannot be negative."
```

## Requirements Checklist

- [ ] Method accepts item price and amount inserted as parameters (not hardcoded)
- [ ] Negative item price is treated as invalid input, with a clear returned message
- [ ] Negative amount inserted is treated as invalid input, with a clear returned message
- [ ] Amount inserted less than price returns a message indicating how much more money is needed
- [ ] Amount inserted exactly equal to price is treated as a successful purchase with $0.00 change
- [ ] Amount inserted greater than price is treated as a successful purchase, with correct change calculated
- [ ] Only one outcome (invalid, insufficient, or successful) is reported per call
- [ ] Code is organized into at least one clearly named method (avoid putting all logic directly in `main`)

## Stretch Goals

Each stretch goal should be implemented as its own separate method — do not modify your original method to accommodate these. Your original solution should remain intact and callable on its own.

- **Multiple Items / Running Total** — Accept a list of item prices being purchased together, along with a single amount inserted, and determine whether the total was fully covered. Report either the change owed or how much more is needed, based on the sum of all item prices.
- **Making Change in Denominations** — Given a change amount owed, break it down into the fewest number of standard bills and coins ($1.00, $0.25, $0.10, $0.05, $0.01) needed to make that amount, and report the count of each denomination used.
