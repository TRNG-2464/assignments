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