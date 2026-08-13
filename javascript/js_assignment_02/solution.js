
function countOutOfOrder(ticketLine) {
    let count = 0;
    let sorted = [...ticketLine].sort((a, b) => a - b);

    for (let i = 0; i < ticketLine.length; i++) {
        if (ticketLine[i] != sorted[i]) {
            count += 1;
        }
    }

    return count;
}

console.log(countOutOfOrder([3, 1, 2, 5, 4]));
console.log(countOutOfOrder([1, 2, 3, 4, 5]));
console.log(countOutOfOrder([]));
