'use strict';

const assert = require('node:assert/strict');
const test = require('node:test');

const {
  countFuelStops,
  getFuelStopIndices,
  countFuelStopsWithStartingFuel,
  countFuelStopsWithMinimum,
} = require('../index.js');

test('countFuelStops calculates the minimum stops with a running total', () => {
  assert.equal(countFuelStops([100, 200, 150, 300, 100], 500), 1);
  assert.equal(countFuelStops([250, 250, 250], 500), 1);
});

test('countFuelStops handles impossible and empty routes', () => {
  assert.equal(countFuelStops([600, 100], 500), -1);
  assert.equal(countFuelStops([], 500), 0);
});

test('getFuelStopIndices returns the leg immediately before each refuel', () => {
  assert.deepEqual(getFuelStopIndices([100, 200, 150, 300, 100], 500), [2]);
  assert.deepEqual(getFuelStopIndices([600], 500), [-1]);
});

test('countFuelStopsWithStartingFuel begins with the supplied fuel amount', () => {
  assert.equal(countFuelStopsWithStartingFuel([100, 200, 150, 300, 100], 500, 250), 2);
  assert.equal(countFuelStopsWithStartingFuel([], 500, 0), 0);
});

test('countFuelStopsWithMinimum enforces a leg interval before the next leg', () => {
  assert.equal(countFuelStopsWithMinimum([100, 100, 100, 100], 500, 2), 1);
  assert.equal(countFuelStopsWithMinimum([100, 100, 100], 500, 1), 2);
  assert.throws(() => countFuelStopsWithMinimum([100], 500, 0), RangeError);
});
