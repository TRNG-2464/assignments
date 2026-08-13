
function countFuelStops(legDistances, fuelRange) {
    let fuelStops = 0;
    let running = 0;

    for (let i = 0; i < legDistances.length; i++) {
        let distance = legDistances[i];
        // Impossible to cover the distance
        if (distance > fuelRange) {
            return -1;
        }

        running += distance;
        if (running > fuelRange) {
            fuelStops += 1;
            running = distance;
        }
    }

    return fuelStops;
}


console.log(countFuelStops([100, 200, 150, 300, 100], 500));
console.log(countFuelStops([600, 100], 500));
console.log(countFuelStops([], 500));
