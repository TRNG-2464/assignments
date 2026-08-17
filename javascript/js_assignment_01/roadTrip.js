function countFuelStops(stepsDistances, fuelRange) {
     
    let stop = 0;
    let distanceToFuel = 0;
    for(let i = 0; i<stepsDistances.length; i++){
        
        let leg =stepsDistances[i];
        if(leg>fuelRange){
            return -1;
        } 
        
        if(distanceToFuel + leg > fuelRange ){
            stop++; 
            distanceToFuel = 0;
        }
        distanceToFuel += leg;

    }
    return stop;

}

console.log("Test 1:", countFuelStops([100, 200, 150, 300, 100], 500));
console.log("Test 2:", countFuelStops([600, 100], 500));
console.log("Test 3:", countFuelStops([], 500));