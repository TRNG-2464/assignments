# Activity — Road Trip Fuel Stops

## Objective

Write a JavaScript function that determines the **minimum number of fuel stops** required to complete a road trip, given a car's fuel range and the distances between stops along the route. This activity focuses on **array iteration and greedy algorithm thinking**, and practices `for` loops, running totals, and conditional logic.

---

## Background

You've just joined the routing team at **TrailBlazer Trips**, a company that plans long-distance road trips for customers. Every route is broken into a series of legs — the distances between one town and the next. Each customer's car has a maximum range on a full tank, and the app needs to tell them, before they leave, how many times they'll need to stop and refuel along the way.

Your manager wants a reusable function that can plug into the trip-planning app: given the leg distances and the car's range, calculate the minimum number of fuel stops needed to make it to the final destination.

---

## Scenario / Problem Statement

A customer is driving from **Denver to Chicago**, and the route has been broken into legs — the distance (in miles) from one town to the next. Their car can travel **500 miles** on a full tank, and they start with a full tank at the very first town.

Assume the driver **always refuels to full** whenever they stop, and that they can only decide to stop *between* legs — not partway through one. If a single leg is longer than the car's full range, the trip is impossible with this car, and your function should indicate that clearly (e.g. return `-1`).

Write a function `countFuelStops(legDistances, fuelRange)` that returns the minimum number of fuel stops needed to complete the trip.

---

## Requirements

- The function must accept:
  - `legDistances` — an array of numbers, each representing the distance (in miles) of one leg of the trip
  - `fuelRange` — a number representing the car's maximum distance on a full tank
- The car starts with a full tank at the beginning of the trip (this does **not** count as a stop)
- The function should use a **running total** of miles driven since the last fill-up, only refueling (incrementing the stop count) when necessary to complete the next leg
- If any single leg exceeds `fuelRange`, the trip is impossible — return `-1`
- The function should return an integer: the minimum number of fuel stops needed

---

## Requirements Checklist

- Function named `countFuelStops` accepting `(legDistances, fuelRange)`
- Uses a `for` loop to iterate through the legs
- Tracks a running total of distance driven since the last fuel stop
- Increments a stop counter only when refueling is required to cover the next leg
- Returns `-1` immediately if a single leg exceeds `fuelRange`
- Returns the total number of stops as an integer
- Handles an empty `legDistances` array by returning `0`

---

## Example Interaction

```js
countFuelStops([100, 200, 150, 300, 100], 500);
// Trip legs: 100, 200, 150, 300, 100 (total 850 miles)
// Running total: 100 -> 300 -> 450 -> (450 + 300 = 750, exceeds 500, so refuel) 
// After refueling: 300 -> (300 + 100 = 400, ok)
// Result: 1 stop

countFuelStops([600, 100], 500);
// The first leg (600) exceeds the fuel range (500) on its own
// Result: -1

countFuelStops([], 500);
// No legs to drive
// Result: 0
```

---

## Stretch Goals

Once the core function is working, try writing these as **new, separate functions** that build on the same core logic:

1. **`getFuelStopIndices(legDistances, fuelRange)`** — instead of returning just a count, return an array of the leg indices after which the driver stopped to refuel.

2. **`countFuelStopsWithStartingFuel(legDistances, fuelRange, startingFuel)`** — instead of always starting with a full tank, accept a third argument specifying how much fuel the car starts the trip with.

3. **`countFuelStopsWithMinimum(legDistances, fuelRange, minLegsBetweenStops)`** — accept a third argument, `minLegsBetweenStops`, representing the minimum number of legs the driver must travel before stopping again. The car should stop either when it would run out of fuel before completing the next leg, **or** once `minLegsBetweenStops` legs have passed since the last stop — whichever comes first. For example, a value of `1` means the driver stops and refuels after every leg; a value of `2` means the driver stops at least every other leg, even if the tank isn't empty yet.
