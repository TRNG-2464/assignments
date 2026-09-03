# Activity — Ticket Booth Line

## Objective

Write a JavaScript function that determines how many people in a line are **standing out of order** relative to their assigned ticket number. This activity focuses on **array comparison and sorting**, and practices array copying, the `.sort()` method, and iteration.

---

## Background

You're building tools for **Gate 7 Entertainment**, a company that runs will-call ticket booths at concerts and events. When tickets are issued, each one is stamped with a sequential number based on purchase order — ticket #1 was bought first, #2 second, and so on. At the venue, staff call ticket holders up in order, but people don't always line up correctly — some show up late, some cut in, some just stand wherever their friends are.

The booth manager wants a quick way to audit the line before it starts moving: given the order people are currently standing in (represented by their ticket numbers), how many people are **not** standing in the position they should be in if the line were in correct numerical order?

---

## Scenario / Problem Statement

A staff member walks down the line and records the ticket number held by each person, in the order they're standing — front of the line first. You need to compare this to what the line *should* look like if everyone were sorted correctly by ticket number, and count how many people are standing in the wrong spot.

Write a function `countOutOfOrder(ticketLine)` that returns the number of people whose current position does not match their position in the correctly sorted line.

---

## Requirements

- The function must accept `ticketLine` — an array of numbers representing ticket numbers, in the order people are currently standing (front to back)
- The function should determine what the line would look like if sorted in ascending order by ticket number, **without mutating the original array**
- The function should compare the original line to the sorted line, position by position
- The function should return an integer: the count of positions where the ticket number in the original line does not match the ticket number in the sorted line
- Assume all ticket numbers in a given line are unique

---

## Requirements Checklist

- Function named `countOutOfOrder` accepting `ticketLine`
- Creates a sorted copy of the array (e.g. using the spread operator or `.slice()`) rather than sorting `ticketLine` in place
- Uses `.sort()` with an appropriate comparator for numeric sorting
- Iterates through both arrays position-by-position to compare values
- Returns the correct count as an integer
- Original `ticketLine` array is unchanged after the function runs
- Handles an empty array by returning `0`
- Handles an already-correctly-ordered line by returning `0`

---

## Example Interaction

```js
countOutOfOrder([3, 1, 2, 5, 4]);
// Sorted order would be: [1, 2, 3, 4, 5]
// Position-by-position:
//   index 0: 3 vs 1 -> mismatch
//   index 1: 1 vs 2 -> mismatch
//   index 2: 2 vs 3 -> mismatch
//   index 3: 5 vs 4 -> mismatch
//   index 4: 4 vs 5 -> mismatch
// Result: 5

countOutOfOrder([1, 2, 3, 4, 5]);
// Already in correct order
// Result: 0

countOutOfOrder([]);
// No one in line
// Result: 0
```

---

## Stretch Goals

Once the core function is working, try writing these as **new, separate functions** that build on the same core logic:

1. **`getOutOfOrderTickets(ticketLine)`** — instead of returning just a count, return an array of the actual ticket numbers standing in the wrong spot.

2. **`minSwapsToOrder(ticketLine)`** — return the minimum number of position swaps needed to fully correct the line (this is a harder variant — not simply the mismatch count).

3. **`findLineIssues(ticketLine)`** — handle a line that may contain `null` entries (e.g. an empty spot where someone stepped away) and duplicate ticket numbers (e.g. a reprinted ticket). The function should report:
   - the **index** of every `null` entry found, and
   - for every duplicate ticket number, **both indices** where that value occurs
