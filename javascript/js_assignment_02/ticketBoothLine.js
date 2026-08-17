function countOutOfOrder(ticketLine) {
    const sortedLine = [...ticketLine].sort((a, b) => a - b);

    let outOfOrderCount = 0;
    for (let i = 0; i < ticketLine.length; i++) {
        if (ticketLine[i] !== sortedLine[i]) {
            outOfOrderCount++;
        }
    }

    return outOfOrderCount;
}

//tests
console.log(countOutOfOrder([3, 1, 2, 5, 4]));
console.log(countOutOfOrder([1, 2, 3, 4, 5]));
console.log(countOutOfOrder([]));
console.log(countOutOfOrder([5, 4, 3, 2, 1]));
