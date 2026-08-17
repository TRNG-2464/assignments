function countFuelStops(legDistances, fuelRange) {
    if (legDistances.length === 0) {
        return 0;
    }

    let stops = 0;
    let milesSinceFillUp = 0;
    let remaining = fuelRange;

    for (let i = 0; i < legDistances.length; i++) {
        const leg = legDistances[i];

        // If this leg is longer than a full tank, the trip is impossible.
        if (leg > fuelRange) return -1;
        
        // If this leg would go past the remaining range, stop and refuel first.
        if (leg + milesSinceFillUp > fuelRange){
            stops += 1;
            remaining = fuelRange;
            milesSinceFillUp = 0;
        } 
        
        remaining -= leg;

        milesSinceFillUp += leg;
    }

    return stops;
}

// Example tests from the assignment
console.log(countFuelStops([100, 200, 150, 300, 100], 500)); // expected: 1
console.log(countFuelStops([600, 100], 500));                 // expected: -1
console.log(countFuelStops([], 500));                         // expected: 0
