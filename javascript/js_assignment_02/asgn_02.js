function countOutOfOrder(ticketLine) {
    if (ticketLine.length === 0) {
        return 0;
    }

    let mismatches = 0;

    // Make a copy so sorting does not change the original ticketLine.
    const copyOfLine = [...ticketLine];
    // Sort the copy in ascending numeric order.
    copyOfLine.sort((a, b) => a - b); // can also do function(a,b){return a-b} // there's no extra function name or parenthesis, that's how it looked in the example

    // Compare each position in ticketLine to the sorted copy.
    for (let i = 0; i < ticketLine.length; i++) {
        if (copyOfLine[i] !== ticketLine[i]) mismatches++;
    }
    return mismatches;
}

// Example tests from the assignment
console.log(countOutOfOrder([3, 1, 2, 5, 4])); // expected: 5
console.log(countOutOfOrder([1, 2, 3, 4, 5])); // expected: 0
console.log(countOutOfOrder([]));               // expected: 0
