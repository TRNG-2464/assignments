# Best Time to Buy and Sell Stock

## Objective

Practice iterating through an array while tracking relevant running state as you go — a pattern that shows up frequently in optimization-style problems where order (time, sequence) matters, so the array can't simply be sorted first.

## Instructions

- Write a method that accepts a single parameter: an array of integers, where each value represents a stock's price on a given day (index `0` represents day 1, index `1` represents day 2, and so on).
- The method should determine the maximum profit achievable from buying the stock on one day and selling it on a later day. The sell day must come after the buy day — you cannot sell before you buy.
- If no profitable transaction is possible (for example, if prices only ever decrease), the method should return `0`.
- You can assume the array will always contain at least one price. A single-element array should return `0`, since there is no later day available to sell on.

> **Hint:** This problem can be solved in a single pass through the array, without checking every possible pair of buy/sell days directly. Think about what running value(s) you would need to track as you scan through the array once, left to right.

## Example Interactions

**Example 1**
```
Input: [7, 1, 5, 3, 6, 4]
Output: 5
```
(Buy on the day priced at 1, sell on the day priced at 6.)

**Example 2 — No profit possible**
```
Input: [7, 6, 4, 3, 1]
Output: 0
```

**Example 3**
```
Input: [2, 4, 1]
Output: 2
```
(Buy on the day priced at 2, sell on the day priced at 4.)

**Example 4 — Single day, no later day to sell**
```
Input: [5]
Output: 0
```

## Requirements Checklist

- [ ] Method accepts the array of prices as a parameter (not hardcoded)
- [ ] Correctly computes the maximum achievable profit for a valid buy-then-sell pair
- [ ] Returns `0` when no profitable transaction is possible
- [ ] Correctly handles a single-element array (returns `0`)
- [ ] Code is organized into at least one clearly named method (avoid putting all logic directly in `main`)

## Stretch Goals

Each stretch goal should be implemented as its own separate method — do not modify your original method to accommodate these. Your original solution should remain intact and callable on its own.

- **Identify the Buy/Sell Days** — In addition to the maximum profit, determine which day to buy on and which day to sell on to achieve that profit, and print this information to the console (for example, "Buy on day 2, sell on day 5 for a profit of 5"). You do not need to change your method's return type to accomplish this — printing the result from within the method, or from your calling code after the method returns, is sufficient. Be clear and consistent about whether you're reporting day numbers or array indexes.
- **Two Purchases, One Sell** — Consider a strategy where, instead of a single buy day, you buy the stock on **two different days** (both of which must come before the sell day), and then sell all of it on a single later day, at that day's price. Write a method that determines the maximum profit achievable under this two-purchase, single-sell strategy. Then, compare this result against your original method's result for the same input, and determine whether buying twice at two different low days actually yields a higher profit than the original single buy/sell approach.
