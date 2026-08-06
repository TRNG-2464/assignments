# Closest Value in Array

## Objective

Practice linear iteration through an array while tracking the "best so far" result — comparing each element against a running best using a calculated difference, a common pattern that shows up across many search and optimization-style problems.

## Instructions

- Write a method that accepts two parameters: an array of integers and a target integer value. The array is **not** assumed to be sorted, and all numbers in the array will always be **positive integers**.
- The method should return the value from the array that is numerically closest to the target.
- If there is a tie (two values are equally close to the target), return the **smaller** of the two tied values.
- Since the array is not sorted, a straightforward linear scan comparing each element's distance from the target is the expected approach here. Sorting the array first is not required, but you are welcome to sort it as part of your solution if you'd like to explore whether it helps "optimize" your approach.
- If the array is empty, return `-1`. Since the array will otherwise always contain positive integers, `-1` can be safely used as a signal that no result was found.

## Example Interactions

**Example 1**
```
Input: array = [4, 9, 1, 15, 8], target = 10
Output: 9
```

**Example 2**
```
Input: array = [4, 9, 1, 15, 8], target = 2
Output: 1
```

**Example 3 — Tie, smaller value returned**
```
Input: array = [5, 15], target = 10
Output: 5
```

**Example 4 — Empty array**
```
Input: array = [], target = 10
Output: -1
```

## Requirements Checklist

- [ ] Method accepts the array and target as parameters (not hardcoded)
- [ ] Correctly finds the closest value via linear comparison, without assuming the array is sorted
- [ ] Ties are broken consistently, returning the smaller of the two tied values
- [ ] Empty array input returns `-1`
- [ ] Code is organized into at least one clearly named method (avoid putting all logic directly in `main`)

## Stretch Goals

Each stretch goal should be implemented as its own separate method — do not modify your original method to accommodate these. Your original solution should remain intact and callable on its own.

- **Closest 'K' Values** — Given an additional parameter `k`, return the `k` closest values in the array to the target, rather than just the single closest value. This method should return its result as an array of integers.
- **Find Farthest Match** — Write a method that finds the opposite result: given the same inputs, return the value in the array that is numerically **farthest** from the target. If there is a tie, apply the same tie-breaking rule as your original method (return the smaller of the two tied values).
- **Higher/Lower Flag** — Add a `boolean` parameter to your original closest-value logic (in this new method) that controls how ties are broken: `false` should favor the original behavior (returning the smaller of two equidistant values), while `true` should favor returning the **larger** of two equidistant values instead.
