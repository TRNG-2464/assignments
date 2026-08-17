function countFuelStops(legDistances, fuelRange) {
    if (legDistances.length === 0) {
        return 0;
    }
    if (legDistances.find(x => x > fuelRange)) {
        return -1;
    }
    let counter = 0;
    let currSum = 0;
    for (const distance of legDistances) {
        if (currSum + distance > fuelRange) {
            counter += 1;
            currSum = 0;
        }
        currSum += distance;
    }
    return counter;
}
//console.log(countFuelStops([100, 200, 150, 300, 100], 500)); //1
//console.log(countFuelStops([600, 100], 500)); //-1
//console.log(countFuelStops([], 500)); //0

function getFuelStopIndices(legDistances, fuelRange) {
    if (legDistances.length === 0) {
        return 0;
    }
    if (legDistances.find(x => x > fuelRange)) {
        return -1;
    }
    let arr = [];
    let currSum = 0;
    for (const i in legDistances) {
        if (legDistances[i] + currSum > fuelRange) {
            arr.push(i);
            currSum = 0;
        }
        currSum += legDistances[i]
    }
    return arr;
}
console.log(getFuelStopIndices([100, 200, 150, 300, 100], 500)); //[3]
console.log(getFuelStopIndices([600, 100], 500)); //-1
console.log(getFuelStopIndices([], 500)); //0
console.log(getFuelStopIndices([500], 500)); //[]
console.log(getFuelStopIndices([300, 300, 300], 500)); //[1, 2]

function countFuelStopsWithStartingFuel(legDistances, fuelRange, startingFuel) {
    if (legDistances.length === 0) {
        return 0;
    }
    if (legDistances.find(x => x > fuelRange)) {
        return -1;
    }
    let currSum = fuelRange - startingFuel;
    let counter = 0;
    for (const distance of legDistances) {
        if (currSum + distance > fuelRange) {
            counter += 1;
            currSum = 0;
        }
        currSum += distance;
    }
    return counter;
}

function countFuelStopsWithMinimum(legDistances, fuelRange, minLegsBetweenStops) {
    if (legDistances.length === 0) {
        return 0;
    }
    if (legDistances.find(x => x > fuelRange)) {
        return -1;
    }
    let currSum = 0;
    let counter = 0;
    let minStops = minLegsBetweenStops;
    for (const distance of legDistances) {
        minStops -= 1;
        if (minStops === 0 || distance + currSum > fuelRange) {
            counter += 1;
            currSum = 0;
            minStops = minLegsBetweenStops;
        }
        currSum += distance;
    }
    return counter;
}