function countFuelStops(legDistances, fuelRange) {
  if (legDistances.length === 0) return 0;

  let stops = 0;
  let runningTotal = 0;

  for (let i = 0; i < legDistances.length; i++) {
    const leg = legDistances[i];

    if (leg > fuelRange) return -1;

    if (runningTotal + leg > fuelRange) {
      stops++;
      runningTotal = leg;
    } else {
      runningTotal += leg;
    }
  }

  return stops;
}