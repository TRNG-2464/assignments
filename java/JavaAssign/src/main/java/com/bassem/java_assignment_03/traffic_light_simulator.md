# Traffic Light Simulator

## Objective

Practice using `switch` statements to represent state transitions, modulo arithmetic for cyclical logic, and reasoning through repeating sequences over a number of steps.

## Instructions

- Write a method that accepts two parameters: a starting light color (as a `String`) and a number of "ticks" (time steps) that pass.
- The light cycles in a fixed order: **Green → Yellow → Red → Green → ...**, advancing one step in the cycle per tick.
- Your method should determine and report what color the light will be after the given number of ticks have passed.
- A tick count of `0` should leave the light unchanged.
- A tick count greater than the length of a single cycle (3) should still work correctly. Starting with a loop that advances one tick at a time is a reasonable first approach, but consider whether modulo arithmetic could get you to the answer more directly, without looping through every tick.
- If the starting color provided is not one of "Green", "Yellow", or "Red", your method should return a clear message indicating the input was not recognized, rather than attempting to calculate a result.
- If the tick count provided is negative, your method should return a clear error message string rather than attempting to calculate a result.
- Use a `switch` statement to represent the transition from one color to the next, rather than a long chain of `if`/`else if` statements.

## Example Interactions

**Example 1 — Single tick**
```
Input: startColor = "Green", ticks = 1
Output: "Yellow"
```

**Example 2 — Full cycle returns to the same color**
```
Input: startColor = "Green", ticks = 3
Output: "Green"
```

**Example 3 — Multiple full cycles plus a remainder**
```
Input: startColor = "Red", ticks = 5
Output: "Yellow"
```

**Example 4 — Zero ticks, no change**
```
Input: startColor = "Green", ticks = 0
Output: "Green"
```

**Example 5 — Unrecognized starting color**
```
Input: startColor = "Purple", ticks = 2
Output: "Invalid input: 'Purple' is not a recognized light color."
```

**Example 6 — Negative tick count**
```
Input: startColor = "Green", ticks = -3
Output: "Invalid input: tick count cannot be negative."
```

## Requirements Checklist

- [ ] Method accepts starting color and tick count as parameters (not hardcoded)
- [ ] A tick count of 0 correctly leaves the light unchanged
- [ ] Tick counts larger than a single cycle (3+) are handled correctly
- [ ] An unrecognized starting color returns a clear message rather than crashing or returning an incorrect color
- [ ] A negative tick count returns a clear error message rather than crashing or returning an incorrect color
- [ ] A `switch` statement is used to represent color transitions, rather than an `if`/`else if` chain
- [ ] Code is organized into at least one clearly named method (avoid putting all logic directly in `main`)

## Stretch Goals

Each stretch goal should be implemented as its own separate method — do not modify your original method to accommodate these. Your original solution should remain intact and callable on its own.

- **Full Cycle Log** — Given a starting color and a number of ticks, return an array of `String` values representing every color the light passes through, in order, one entry per tick (not including the starting color). For example, a starting color of "Green" with 4 ticks should return an array equivalent to `["Yellow", "Red", "Green", "Yellow"]`.
- **Variable Duration Lights** — Rework the simulation so that each color has its own duration before transitioning to the next (for example, Green lasts 3 ticks, Yellow lasts 1 tick, and Red lasts 2 ticks, before advancing to the next color in the cycle). Given a starting color and a number of ticks elapsed, determine the color of the light at that point, accounting for these differing durations.
- **Exception Handling for Invalid Input** — Rework your handling of an unrecognized starting color and a negative tick count to each throw an appropriate exception, instead of returning a message string. These two error cases should result in two *different* exception types — consider what exception types are most appropriate for each, and where the responsibility for catching and handling those exceptions should live.
