function fuelStops(legDistances, fuelRange) {
    let stops = 0;
    let milesSinceLastStop = 0;

    for (let i = 0; i < legDistances.length; i++) {
        const legDistance = legDistances[i];

        if (legDistance > fuelRange) {
            return -1; // Impossible to complete the leg
        }

        if (milesSinceLastStop + legDistance > fuelRange) {
            stops++;
            milesSinceLastStop = 0; // Reset after refueling
        }

        milesSinceLastStop += legDistance;
    }

    return stops;
}

console.log(fuelStops([100, 200, 150, 300, 100], 500)); // Output: 1
console.log(fuelStops([100, 200, 150, 300, 100], 400)); // Output: 2
console.log(fuelStops([600, 100], 500)); // Output: -1
console.log(fuelStops([], 500)); // Output: 0