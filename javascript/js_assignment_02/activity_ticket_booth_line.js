

function countOutOfOrder(ticketLine){
    if(ticketLine.length == 0) return 0;
    let copyTix = [...ticketLine];
    copyTix.sort((a, b) => a - b);

    let count = 0;
    for(let i = 0; i < copyTix.length; i++){
        if(copyTix[i] != ticketLine[i]) count++
    }

    return count
}

console.log(countOutOfOrder([3, 1, 2, 5, 4]));
// Sorted order would be: [1, 2, 3, 4, 5]
// Position-by-position:
//   index 0: 3 vs 1 -> mismatch
//   index 1: 1 vs 2 -> mismatch
//   index 2: 2 vs 3 -> mismatch
//   index 3: 5 vs 4 -> mismatch
//   index 4: 4 vs 5 -> mismatch
// Result: 5

console.log(countOutOfOrder([1, 2, 3, 4, 5]));
// Already in correct order
// Result: 0

console.log(countOutOfOrder([]));
// No one in line
// Result: 0