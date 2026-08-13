


function countFuelStops(legDistances, fuelRange) {
    let totalMiles = 0;
    let stops = 0;

    for (let i = 0; i < legDistances.length; i++) {
        const leg = legDistances[i];
        if (leg > fuelRange) return -1;

        if (totalMiles + leg > fuelRange) {
            return ++stops;
        } else {
            totalMiles += leg;
        }
    }

    return stops;
}


console.log(countFuelStops([100, 200, 150, 300, 100], 500));
// Trip legs: 100, 200, 150, 300, 100 (total 850 miles)
// Running total: 100 -> 300 -> 450 -> (450 + 300 = 750, exceeds 500, so refuel) 
// After refueling: 300 -> (300 + 100 = 400, ok)
// Result: 1 stop

console.log(countFuelStops([600, 100], 500));
// The first leg (600) exceeds the fuel range (500) on its own
// Result: -1

console.log(countFuelStops([], 500));
// No legs to drive
// Result: 0