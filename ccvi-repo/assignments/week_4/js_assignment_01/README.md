# Activity — Road Trip Fuel Stops

This Node.js project implements the required greedy route-planning function and all three stretch goals. A driver starts with a full tank, refuels only between route legs, and receives `-1` when a leg cannot be driven on a full tank.

## Environment and commands

The project targets **JavaScript using ES2026-compatible syntax** and **Node.js 24.19.0 or later**. It has no third-party dependencies.

| Command | Purpose |
|---|---|
| `node index.js` | Runs the console demonstration in the same narrative format as the assignment’s example interaction. |
| `npm start` | Runs the same demonstration through the package script. |
| `npm test` | Runs the automated tests with Node’s built-in test runner. |

## Included functions

| Function | Purpose | Return value |
|---|---|---|
| `countFuelStops(legDistances, fuelRange)` | Calculates the minimum number of refuelling stops with a running distance total. | Stop count, or `-1` if a leg is impossible. |
| `getFuelStopIndices(legDistances, fuelRange)` | Identifies the zero-based leg indices after which refuelling occurs. | Array of indices, or `[-1]` if a leg is impossible. |
| `countFuelStopsWithStartingFuel(legDistances, fuelRange, startingFuel)` | Recalculates the route when the car starts below full range. | Stop count, or `-1` if a leg is impossible. |
| `countFuelStopsWithMinimum(legDistances, fuelRange, minLegsBetweenStops)` | Forces a stop before the next leg after the selected leg interval, or earlier when fuel requires it. | Stop count, or `-1` if a leg is impossible. |

## Example

```js
const { countFuelStops } = require('./index.js');

console.log(countFuelStops([100, 200, 150, 300, 100], 500));
// 1
```
