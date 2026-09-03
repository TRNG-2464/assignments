'use strict';

const assert = require('node:assert/strict');
const test = require('node:test');

const {
  countOutOfOrder,
  getOutOfOrderTickets,
  minSwapsToOrder,
  findLineIssues,
} = require('../index.js');

test('countOutOfOrder compares the original line with a sorted copy', () => {
  const ticketLine = [3, 1, 2, 5, 4];

  assert.equal(countOutOfOrder(ticketLine), 5);
  assert.deepEqual(ticketLine, [3, 1, 2, 5, 4]);
  assert.equal(countOutOfOrder([1, 2, 3, 4, 5]), 0);
  assert.equal(countOutOfOrder([]), 0);
});

test('getOutOfOrderTickets returns the values in mismatched positions', () => {
  assert.deepEqual(getOutOfOrderTickets([3, 1, 2, 5, 4]), [3, 1, 2, 5, 4]);
  assert.deepEqual(getOutOfOrderTickets([1, 2, 3]), []);
});

test('minSwapsToOrder counts permutation cycles instead of mismatches', () => {
  assert.equal(minSwapsToOrder([3, 1, 2, 5, 4]), 3);
  assert.equal(minSwapsToOrder([4, 3, 2, 1]), 2);
  assert.equal(minSwapsToOrder([]), 0);
});

test('findLineIssues reports every null position and repeated ticket indices', () => {
  assert.deepEqual(findLineIssues([7, null, 4, 7, null, 4]), {
    nullIndices: [1, 4],
    duplicateTickets: [
      { ticketNumber: 7, indices: [0, 3] },
      { ticketNumber: 4, indices: [2, 5] },
    ],
  });
  assert.deepEqual(findLineIssues([1, 2, 3]), {
    nullIndices: [],
    duplicateTickets: [],
  });
});
