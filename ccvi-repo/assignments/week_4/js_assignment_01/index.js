'use strict';

/**
 * Returns the minimum number of refuelling stops needed to complete a route.
 *
 * @param {number[]} legDistances Distances between consecutive stops.
 * @param {number} fuelRange Maximum distance available on a full tank.
 * @returns {number} The minimum stop count, or -1 when a leg is impossible.
 */
function countFuelStops(legDistances, fuelRange) {
  if (legDistances.length === 0) {
    return 0;
  }

  let stops = 0;
  let distanceSinceLastStop = 0;

  for (const leg of legDistances) {
    if (leg > fuelRange) {
      return -1;
    }

    if (distanceSinceLastStop + leg > fuelRange) {
      stops += 1;
      distanceSinceLastStop = leg;
    } else {
      distanceSinceLastStop += leg;
    }
  }

  return stops;
}

/**
 * Returns the zero-based indices of legs after which the driver refuels.
 *
 * @param {number[]} legDistances Distances between consecutive stops.
 * @param {number} fuelRange Maximum distance available on a full tank.
 * @returns {number[]} Stop indices, or [-1] when a leg is impossible.
 */
function getFuelStopIndices(legDistances, fuelRange) {
  const stopIndices = [];
  let distanceSinceLastStop = 0;

  for (let index = 0; index < legDistances.length; index += 1) {
    const leg = legDistances[index];

    if (leg > fuelRange) {
      return [-1];
    }

    if (distanceSinceLastStop + leg > fuelRange) {
      stopIndices.push(index - 1);
      distanceSinceLastStop = leg;
    } else {
      distanceSinceLastStop += leg;
    }
  }

  return stopIndices;
}

/**
 * Returns the minimum refuelling-stop count for a non-full starting tank.
 *
 * @param {number[]} legDistances Distances between consecutive stops.
 * @param {number} fuelRange Maximum distance available on a full tank.
 * @param {number} startingFuel Distance available in the tank at departure.
 * @returns {number} The minimum stop count, or -1 when a leg is impossible.
 */
function countFuelStopsWithStartingFuel(legDistances, fuelRange, startingFuel) {
  if (legDistances.length === 0) {
    return 0;
  }

  let stops = 0;
  let fuelRemaining = Math.min(startingFuel, fuelRange);

  for (const leg of legDistances) {
    if (leg > fuelRange) {
      return -1;
    }

    if (leg > fuelRemaining) {
      stops += 1;
      fuelRemaining = fuelRange;
    }

    fuelRemaining -= leg;
  }

  return stops;
}

/**
 * Stops before a leg when fuel is insufficient or the leg interval is reached.
 *
 * @param {number[]} legDistances Distances between consecutive stops.
 * @param {number} fuelRange Maximum distance available on a full tank.
 * @param {number} minLegsBetweenStops Maximum legs driven before the next refuel.
 * @returns {number} The required stop count, or -1 when a leg is impossible.
 */
function countFuelStopsWithMinimum(legDistances, fuelRange, minLegsBetweenStops) {
  if (legDistances.length === 0) {
    return 0;
  }

  if (!Number.isInteger(minLegsBetweenStops) || minLegsBetweenStops < 1) {
    throw new RangeError('minLegsBetweenStops must be an integer of at least 1.');
  }

  let stops = 0;
  let distanceSinceLastStop = 0;
  let legsSinceLastStop = 0;

  for (const leg of legDistances) {
    if (leg > fuelRange) {
      return -1;
    }

    const needsFuel = distanceSinceLastStop + leg > fuelRange;
    const reachedLegInterval = legsSinceLastStop === minLegsBetweenStops;

    if (needsFuel || reachedLegInterval) {
      stops += 1;
      distanceSinceLastStop = 0;
      legsSinceLastStop = 0;
    }

    distanceSinceLastStop += leg;
    legsSinceLastStop += 1;
  }

  return stops;
}

module.exports = {
  countFuelStops,
  getFuelStopIndices,
  countFuelStopsWithStartingFuel,
  countFuelStopsWithMinimum,
};

if (require.main === module) {
  console.log('--- Example Interaction ---');
  console.log('countFuelStops([100, 200, 150, 300, 100], 500);');
  console.log('Trip legs: 100, 200, 150, 300, 100 (total 850 miles)');
  console.log('Running total: 100 -> 300 -> 450 -> (450 + 300 = 750, exceeds 500, so refuel)');
  console.log('After refueling: 300 -> (300 + 100 = 400, ok)');
  console.log(`Result: ${countFuelStops([100, 200, 150, 300, 100], 500)} stop\n`);

  console.log('countFuelStops([600, 100], 500);');
  console.log('The first leg (600) exceeds the fuel range (500) on its own');
  console.log(`Result: ${countFuelStops([600, 100], 500)}\n`);

  console.log('countFuelStops([], 500);');
  console.log('No legs to drive');
  console.log(`Result: ${countFuelStops([], 500)}\n`);

  console.log('--- Stretch Goals ---');
  console.log(`getFuelStopIndices([100, 200, 150, 300, 100], 500): [${getFuelStopIndices([100, 200, 150, 300, 100], 500)}]`);
  console.log(`countFuelStopsWithStartingFuel([100, 200, 150, 300, 100], 500, 250): ${countFuelStopsWithStartingFuel([100, 200, 150, 300, 100], 500, 250)}`);
  console.log(`countFuelStopsWithMinimum([100, 100, 100, 100], 500, 2): ${countFuelStopsWithMinimum([100, 100, 100, 100], 500, 2)}`);
}
