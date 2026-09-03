# Activity — Ticket Booth Line

This Node.js project audits a ticket line by comparing it with the correctly sorted order. It preserves the original line and implements every required stretch goal: listing misplaced tickets, calculating the true minimum swap count, and identifying empty or duplicate ticket positions.

## Environment and commands

The project targets **JavaScript using ES2026-compatible syntax** and **Node.js 24.19.0 or later**. It has no third-party dependencies.

| Command | Purpose |
|---|---|
| `node index.js` | Runs the console demonstration in the assignment’s example-interaction style. |
| `npm start` | Runs the same demonstration through the package script. |
| `npm test` | Runs the automated tests with Node’s built-in test runner. |

## Included functions

| Function | Purpose | Return value |
|---|---|---|
| `countOutOfOrder(ticketLine)` | Counts the positions that differ from the ascending numeric ticket order. | Number of mismatched positions. |
| `getOutOfOrderTickets(ticketLine)` | Lists the ticket numbers currently standing in mismatched positions. | Array of ticket numbers. |
| `minSwapsToOrder(ticketLine)` | Calculates the fewest swaps needed to sort a line of unique ticket numbers. | Minimum swap count. |
| `findLineIssues(ticketLine)` | Reports `null` positions and every repeated ticket number with all matching indices. | `{ nullIndices, duplicateTickets }` object. |

## Example

```js
const { countOutOfOrder } = require('./index.js');

console.log(countOutOfOrder([3, 1, 2, 5, 4]));
// 5
```
