// Road Trip Fuel Stops
// Finds the minimum number of fuel stops needed to complete a trip.

function countFuelStops(legDistances, fuelRange) {
  let stops = 0;
  let runningTotal = 0;

  for (let i = 0; i < legDistances.length; i++) {
    const leg = legDistances[i];

    // Leg too long for a full tank, trip is impossible
    if (leg > fuelRange) {
      return -1;
    }

    // Not enough fuel left, refuel
    if (runningTotal + leg > fuelRange) {
      stops++;
      runningTotal = 0;
    }

    runningTotal += leg;
  }

  return stops;
}

// --- Examples ---------------------------------------------------------

console.log(countFuelStops([100, 200, 150, 300, 100], 500)); // 1
console.log(countFuelStops([600, 100], 500)); // -1
console.log(countFuelStops([], 500)); // 0

