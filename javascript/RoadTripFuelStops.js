function countFuelStops(legDistances,fuelRange){
    let total =0;
    let count = 0;
    if(legDistances.length===0){
        return 0;
    }
    for(let i=0;i<legDistances.length;i++){
        if(legDistances[i]>fuelRange){
            return -1;
        }
        if(legDistances[i]+total<fuelRange){
            total = total +legDistances[i];
        }else{
            count ++;
            total = legDistances[i];
        }
    }
    return count;
}
console.log(countFuelStops([100, 200, 150, 300, 100], 500)); // expect 1
console.log(countFuelStops([600, 100], 500)); // expect -1
console.log(countFuelStops([], 500)); // expect 0

function getFuelStopIndices(legDistances, fuelRange){
    let total =0;
    const legIndices = [];
    if(legDistances.length===0){
        return legIndices;
    }
    for(let i=0;i<legDistances.length;i++){
        if(legDistances[i]>fuelRange){
            return -1;
        }
        if(legDistances[i]+total<fuelRange){
            total = total +legDistances[i];
        }else{
            legIndices.push(i);
            total = legDistances[i];
        }
    }
    return legIndices;
}

console.log(getFuelStopIndices([100, 200, 150, 300, 100], 500));

function countFuelStopsWithStartingFuel(legDistances,fuelRange,startingFuel){
    let total = fuelRange-startingFuel;
    let count = 0;
    if(legDistances.length===0){
        return 0;
    }
    for(let i=0;i<legDistances.length;i++){
        if(legDistances[i]>fuelRange){
            return -1;
        }
        if(legDistances[i]+total<fuelRange){
            total = total +legDistances[i];
        }else{
            count ++;
            total = legDistances[i];
        }
    }
    return count;
}

console.log(countFuelStopsWithStartingFuel([100, 200, 150, 300, 100], 500, 500)); // same as full tank, expect 1
console.log(countFuelStopsWithStartingFuel([100, 200, 150, 300, 100], 500, 200)); // starts with less fuel

function countFuelStopsWithMinimum(legDistances, fuelRange, minLegsBetweenStops) {
    let total = 0;
    let count = 0;
    let legsSinceStop = 0;

    if (legDistances.length === 0) {
        return 0;
    }

    for (let i = 0; i < legDistances.length; i++) {
        if (legDistances[i] > fuelRange) {
            return -1;
        }

        let needsFuelStop = legDistances[i] + total >= fuelRange;
        let needsMinimumStop = legsSinceStop >= minLegsBetweenStops;

        if (needsFuelStop || needsMinimumStop) {
            count++;
            total = legDistances[i];
            legsSinceStop = 1;
        } else {
            total = total + legDistances[i];
            legsSinceStop++;
        }
    }

    return count;
}

console.log(countFuelStopsWithMinimum([600, 100], 500, 3));
