// Ticket Booth Line
// Counts how many people are standing out of order compared to their ticket numbers.

function countOutOfOrder(ticketLine) {
  // Sorted copy, doesn't mutate the original
  const sortedLine = [...ticketLine].sort((a, b) => a - b);

  let mismatches = 0;
  for (let i = 0; i < ticketLine.length; i++) {
    if (ticketLine[i] !== sortedLine[i]) {
      mismatches++;
    }
  }

  return mismatches;
}

// --- Examples ---------------------------------------------------------

console.log(countOutOfOrder([3, 1, 2, 5, 4])); // 5
console.log(countOutOfOrder([1, 2, 3, 4, 5])); // 0
console.log(countOutOfOrder([])); // 0
