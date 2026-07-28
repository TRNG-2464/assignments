# Elevator Weight Limit Checker

## Objective

Practice iterating through a collection while maintaining a running total, using conditional logic to detect when a threshold has been reached or exceeded, and exiting a loop early once that condition is met.

## Instructions

- Write a method that accepts two parameters: a maximum weight limit (an `int` or `double`, your choice) and an array (or list) of passenger weights, representing passengers boarding an elevator one at a time, in the order given.
- Track the running total weight as each passenger boards, one at a time, in order.
- If adding a passenger would cause the running total to **meet or exceed** the weight limit, the elevator is overloaded. At that point, your method should report:
  - Which passenger (by position in line) caused the overload — for readability, passenger positions should be reported starting from 1, not 0 (e.g., the passenger at index 0 of your input array should be reported as "Passenger 1")
  - The running total weight at the point the overload occurred (i.e., including that passenger's weight)
  - No further passengers should be considered once the overload is detected
- If every passenger boards without the running total ever meeting or exceeding the limit, report that all passengers boarded safely, along with the final total weight.
- Consider what your method should do if it is given an empty array of passengers — this should not throw an error or crash.
- Consider what your method should do if the very first passenger's weight alone meets or exceeds the limit.
- You will need to decide how to represent and return your result (for example, a formatted `String` message, a custom result object, or printed output directly from the method) — there is no single required approach, but your design should clearly communicate both the outcome and the relevant numbers.

## Example Interactions

**Example 1 — Overload occurs**
```
Input: weightLimit = 1000, passengerWeights = [150, 200, 300, 250, 180]
Output: "Passenger 5 caused an overload. Total weight at that point: 1080 lbs."
```

**Example 2 — All passengers board safely**
```
Input: weightLimit = 1000, passengerWeights = [150, 200, 300]
Output: "All passengers boarded safely. Total weight: 650 lbs."
```

**Example 3 — Exact match counts as overload**
```
Input: weightLimit = 500, passengerWeights = [200, 300]
Output: "Passenger 2 caused an overload. Total weight at that point: 500 lbs."
```

**Example 4 — First passenger alone exceeds the limit**
```
Input: weightLimit = 100, passengerWeights = [150, 200]
Output: "Passenger 1 caused an overload. Total weight at that point: 150 lbs."
```

## Requirements Checklist

- [ ] Method accepts the weight limit and the passenger weight list as parameters (not hardcoded)
- [ ] Running total is calculated one passenger at a time, in the order given
- [ ] A running total that **meets or exceeds** the limit is treated as an overload (not just "greater than")
- [ ] Loop stops as soon as overload is detected — later passengers are not processed or included in the total
- [ ] Overload result clearly identifies which passenger caused it and the total weight at that point
- [ ] Non-overload result clearly reports that all passengers boarded safely and the final total weight
- [ ] Empty passenger list is handled gracefully (no crash, and a sensible result is returned/reported)
- [ ] First-passenger-exceeds-limit case is handled correctly
- [ ] Code is organized into at least one clearly named method (avoid putting all logic directly in `main`)

## Stretch Goals

Each stretch goal should be implemented as its own separate method — do not modify your original method to accommodate these. Your original solution should remain intact and callable on its own.

- **Maximum Safe Passenger Count** — Given the same inputs, instead of stopping at the first overload, determine and report the *maximum number of passengers from the given input array* that could board the elevator without meeting or exceeding the weight limit.
- **Heaviest and Lightest Passengers** — Alongside your original result, also determine and report the heaviest and lightest passenger weights. If an overload occurred, only consider the passengers who boarded before (and including) the one who caused the overload; if no overload occurred, consider all passengers.
- **Multiple Elevator Trips** — Given the full list of passengers and the weight limit, group the passengers into consecutive trips, preserving their original order, such that no single trip's total weight meets or exceeds the limit. Report how many trips are required and which passengers ride on each trip.
