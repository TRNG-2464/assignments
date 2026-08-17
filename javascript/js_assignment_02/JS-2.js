function countOutOfOrder(ticketLine) {
    let unsortedLine = ticketLine;
    let sortedLine = [...ticketLine].sort();
    let mismatch = 0;

    if (Array.isArray(unsortedLine) && unsortedLine.length === 0) {
        console.log("Empty array.");
        return 0;
    }

    let same = unsortedLine.length === sortedLine.length &&
           unsortedLine.every((value, index) => value === sortedLine[index]);
    if (same) {
        console.log("Already in correct order");
        return 0;
    }

    console.log(`arrays ${ticketLine} and ${sortedLine}`);

    for (let i = 0; i < ticketLine.length; i++) {
        if (unsortedLine[i] === sortedLine[i]) {
            console.log(`index ${i}: ${unsortedLine[i]} and ${sortedLine[i]} match`);
        } else {
            console.log(`index ${i}: ${unsortedLine[i]} and ${sortedLine[i]} do not match`);
            mismatch += 1;
        }
    }
    return mismatch;
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