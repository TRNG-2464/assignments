function countFuelStops(legDistances, fuelRange) {
    let currentDistance = 0;
    let stops = 0;

    if (Array.isArray(legDistances) && legDistances.length === 0) {
        console.log("No distance to drive");
        return 0;
    }

    for (num of legDistances) {
        if (num >= fuelRange) {
            return -1;
        }
        currentDistance += num;

        if (currentDistance >= fuelRange) {
            stops += 1;
            console.log(`------ Distance ${currentDistance} exceeds total fuel ${fuelRange} ------`);
            currentDistance = num;
        }

        console.log(`Distance driven: ${currentDistance} and stops: ${stops}`);
    }
    return stops;
}

console.log(countFuelStops([100, 200, 150, 300, 100], 500));
console.log(countFuelStops([600, 100], 500));
console.log(countFuelStops([], 500));