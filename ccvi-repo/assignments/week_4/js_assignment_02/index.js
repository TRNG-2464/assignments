'use strict';

/**
 * Counts positions whose current ticket differs from the ascending ticket order.
 *
 * @param {number[]} ticketLine Ticket numbers from the front to the back of the line.
 * @returns {number} Number of people standing out of order.
 */
function countOutOfOrder(ticketLine) {
  const sortedLine = [...ticketLine].sort((first, second) => first - second);
  let mismatches = 0;

  for (let index = 0; index < ticketLine.length; index += 1) {
    if (ticketLine[index] !== sortedLine[index]) {
      mismatches += 1;
    }
  }

  return mismatches;
}

/**
 * Returns the ticket numbers that are not in their ascending-order position.
 *
 * @param {number[]} ticketLine Ticket numbers from the front to the back of the line.
 * @returns {number[]} Ticket numbers currently standing in the wrong position.
 */
function getOutOfOrderTickets(ticketLine) {
  const sortedLine = [...ticketLine].sort((first, second) => first - second);
  const outOfOrderTickets = [];

  for (let index = 0; index < ticketLine.length; index += 1) {
    if (ticketLine[index] !== sortedLine[index]) {
      outOfOrderTickets.push(ticketLine[index]);
    }
  }

  return outOfOrderTickets;
}

/**
 * Finds the minimum number of swaps required to place unique ticket numbers in order.
 *
 * @param {number[]} ticketLine Unique ticket numbers from the front to the back of the line.
 * @returns {number} Minimum number of position swaps required.
 */
function minSwapsToOrder(ticketLine) {
  const positionsBySortedValue = ticketLine
    .map((ticketNumber, originalIndex) => ({ ticketNumber, originalIndex }))
    .sort((first, second) => first.ticketNumber - second.ticketNumber);
  const visited = Array(ticketLine.length).fill(false);
  let swaps = 0;

  for (let index = 0; index < positionsBySortedValue.length; index += 1) {
    if (visited[index] || positionsBySortedValue[index].originalIndex === index) {
      continue;
    }

    let cycleSize = 0;
    let currentIndex = index;

    while (!visited[currentIndex]) {
      visited[currentIndex] = true;
      currentIndex = positionsBySortedValue[currentIndex].originalIndex;
      cycleSize += 1;
    }

    swaps += cycleSize - 1;
  }

  return swaps;
}

/**
 * Locates empty positions and repeated ticket numbers without changing the line.
 *
 * @param {(number|null)[]} ticketLine Ticket numbers with possible empty positions.
 * @returns {{nullIndices: number[], duplicateTickets: {ticketNumber: number, indices: number[]}[]}}
 * A structured report of null positions and duplicate-number positions.
 */
function findLineIssues(ticketLine) {
  const nullIndices = [];
  const indicesByTicket = new Map();

  for (let index = 0; index < ticketLine.length; index += 1) {
    const ticketNumber = ticketLine[index];

    if (ticketNumber === null) {
      nullIndices.push(index);
      continue;
    }

    const matchingIndices = indicesByTicket.get(ticketNumber) ?? [];
    matchingIndices.push(index);
    indicesByTicket.set(ticketNumber, matchingIndices);
  }

  const duplicateTickets = [];

  for (const [ticketNumber, indices] of indicesByTicket) {
    if (indices.length > 1) {
      duplicateTickets.push({ ticketNumber, indices });
    }
  }

  return { nullIndices, duplicateTickets };
}

module.exports = {
  countOutOfOrder,
  getOutOfOrderTickets,
  minSwapsToOrder,
  findLineIssues,
};

if (require.main === module) {
  console.log('--- Example Interaction ---');
  console.log('countOutOfOrder([3, 1, 2, 5, 4]);');
  console.log('Sorted order would be: [1, 2, 3, 4, 5]');
  console.log('Position-by-position:');
  console.log('  index 0: 3 vs 1 -> mismatch');
  console.log('  index 1: 1 vs 2 -> mismatch');
  console.log('  index 2: 2 vs 3 -> mismatch');
  console.log('  index 3: 5 vs 4 -> mismatch');
  console.log('  index 4: 4 vs 5 -> mismatch');
  console.log(`Result: ${countOutOfOrder([3, 1, 2, 5, 4])}\n`);

  console.log('countOutOfOrder([1, 2, 3, 4, 5]);');
  console.log('Already in correct order');
  console.log(`Result: ${countOutOfOrder([1, 2, 3, 4, 5])}\n`);

  console.log('countOutOfOrder([]);');
  console.log('No one in line');
  console.log(`Result: ${countOutOfOrder([])}\n`);

  console.log('--- Stretch Goals ---');
  console.log(`getOutOfOrderTickets([3, 1, 2, 5, 4]): [${getOutOfOrderTickets([3, 1, 2, 5, 4])}]`);
  console.log(`minSwapsToOrder([3, 1, 2, 5, 4]): ${minSwapsToOrder([3, 1, 2, 5, 4])}`);
  console.log('findLineIssues([7, null, 4, 7, null, 4]):');
  console.log(findLineIssues([7, null, 4, 7, null, 4]));
}
