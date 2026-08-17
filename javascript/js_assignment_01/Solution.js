function countFuelStops(legDistances, fuelRange) {
    let refuels = 0;
    let currentDistance = 0;
    // Loop through leg distances
    for (let i = 0; i < legDistances.length; i++) {
        if (legDistances[i] > fuelRange) {
            return -1;
        }
        if (legDistances[i] + currentDistance > fuelRange) {
            currentDistance = 0;
            refuels += 1;
        }
        currentDistance += legDistances[i];
    }
    return refuels;
}

// console.log(countFuelStops([100, 200, 150, 300, 100], 500));
// console.log(countFuelStops([600, 100], 500));
// console.log(countFuelStops([], 500));

function getFuelStopIndices(legDistances, fuelRange) {
    let legIndexes = [];
    let currentDistance = 0;
    // Loop through leg distances
    for (let i = 0; i < legDistances.length; i++) {
        // if (legDistances[i] > fuelRange)
        if (legDistances[i] > fuelRange) {
            return -1;
        }
        if (legDistances[i] + currentDistance > fuelRange) {
            currentDistance = 0;
            legIndexes.push(i);
        }
        currentDistance += legDistances[i];
    }
    return legIndexes;
}

// console.log(getFuelStopIndices([100, 200, 150, 300, 100], 500));

function countFuelStopsWithStartingFuel(legDistances, fuelRange, startingFuel) {
    let refuels = 0;
    let currentDistance = 0;
    let currentFuel = startingFuel;
    // Loop through leg distances
    for (let i = 0; i < legDistances.length; i++) {
        if (legDistances[i] > fuelRange) {
            return -1;
        }
        if (legDistances[i] + currentDistance > currentFuel) {
            currentDistance = 0;
            refuels += 1;
            currentFuel = fuelRange;
        }
        currentDistance += legDistances[i];
    }
    return refuels;
}
