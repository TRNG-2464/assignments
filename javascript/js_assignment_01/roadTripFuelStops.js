
function countFuelStops(legDistances, fuelRange) {
    let stops = 0;
    let runningTotal = 0;

    for (let i = 0; i < legDistances.length; i++) {
        const leg = legDistances[i];

        if (leg > fuelRange) {
            return -1;
        }

        if (runningTotal + leg > fuelRange) {
            stops++;
            runningTotal = 0;
        }

        runningTotal += leg;
    }

    return stops;
}



// Stretch Goal 1
function getFuelStopIndices(legDistances, fuelRange) {
    const stopIndices = [];
    let runningTotal = 0;

    for (let i = 0; i < legDistances.length; i++) {
        const leg = legDistances[i];

        if (leg > fuelRange) {
            return -1;
        }

        if (runningTotal + leg > fuelRange) {
            stopIndices.push(i - 1); 
            runningTotal = 0;
        }

        runningTotal += leg;
    }

    return stopIndices;
}



// Stretch Goal 2
function countFuelStopsWithStartingFuel(legDistances, fuelRange, startingFuel) {
    let stops = 0;
    let fuelUsed = fuelRange - startingFuel;

    for (let i = 0; i < legDistances.length; i++) {
        const leg = legDistances[i];

        if (leg > fuelRange) {
            return -1;
        }

        if (fuelUsed + leg > fuelRange) {
            stops++;
            fuelUsed = 0;
        }

        fuelUsed += leg;
    }

    return stops;
}



// Stretch Goal 3
function countFuelStopsWithMinimum(legDistances, fuelRange, minLegsBetweenStops) {
    let stops = 0;
    let runningTotal = 0;
    let legsSinceStop = 0;

    for (let i = 0; i < legDistances.length; i++) {
        const leg = legDistances[i];

        if (leg > fuelRange) {
            return -1;
        }

        const needsFuelStop = runningTotal + leg > fuelRange;
        const needsMandatoryStop = legsSinceStop >= minLegsBetweenStops;

        if (needsFuelStop || needsMandatoryStop) {
            stops++;
            runningTotal = 0;
            legsSinceStop = 0;
        }

        runningTotal += leg;
        legsSinceStop++;
    }

    return stops;
}



// tests
console.log(countFuelStops([100, 200, 150, 300, 100], 500)); 
console.log(countFuelStops([600, 100], 500));                 
console.log(countFuelStops([], 500));                         

console.log(getFuelStopIndices([100, 200, 150, 300, 100], 500));
console.log(countFuelStopsWithStartingFuel([100, 200, 150, 300, 100], 500, 200));
console.log(countFuelStopsWithMinimum([100, 100, 100, 100, 100], 500, 2));
