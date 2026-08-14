function countOutOfOrder(ticketLine) {
    const sortedLine = [...ticketLine].sort((a, b) => a - b);
    let count = 0;
    
    for (let i = 0; i < ticketLine.length; i++) {
        if (ticketLine[i] !== sortedLine[i]) {
            count++;
        }
    }

    return count;
}

console.log(countOutOfOrder([3, 1, 2, 5, 4])); // 5
console.log(countOutOfOrder([1, 2, 3, 4, 5])); // 0
console.log(countOutOfOrder([]));               // 0