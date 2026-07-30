# Command-Based Calculator

## Objective

Practice using `Scanner` to read repeated input from the console inside a loop, parsing a line of input into a command and an argument, and maintaining state (a running value) across iterations until an exit condition is met.

## Instructions

- Write a program that maintains a running numeric value, as an `int`, starting at `0`.
- In a loop, prompt the user to enter a command. Support the following commands:
  - `add [number]` — adds the given number to the running value
  - `subtract [number]` — subtracts the given number from the running value
  - `reset` — resets the running value back to `0`
  - `total` — prints the current running value, without changing it
  - `exit` — ends the program
- After each command (other than `exit`), print a confirmation message along with the updated running value. `total` should simply print the current value, without implying any change occurred.
- The loop should continue until the user enters `exit`, at which point the program should print a final farewell message along with the final running value, and then stop.
- Handle an unrecognized command gracefully, with a clear error message, rather than crashing the program.
- Handle an `add` or `subtract` command that is missing its number, or whose argument is not a valid number, gracefully, with a clear error message, rather than crashing the program.
- Each command will be entered as a single line of input (for example, `add 5`). You will need to split this line into the command word and its argument (if any) in order to process it — this is a good opportunity to practice parsing a raw line of text into usable pieces, a pattern you will see again in later activities.

## Example Interactions

```
Enter a command: add 5
Added 5. Running total: 5

Enter a command: add 10
Added 10. Running total: 15

Enter a command: subtract 3
Subtracted 3. Running total: 12

Enter a command: total
Current total: 12

Enter a command: reset
Running total has been reset to 0.

Enter a command: fly 5
Unrecognized command: 'fly'

Enter a command: add banana
'add' requires a valid number. Please try again.

Enter a command: exit
Goodbye! Final total: 0
```

## Requirements Checklist

- [ ] Loop continues reading commands until `exit` is entered
- [ ] `add [number]` correctly increases the running value and reports the update
- [ ] `subtract [number]` correctly decreases the running value and reports the update
- [ ] `reset` correctly sets the running value back to 0
- [ ] `total` correctly displays the current value without altering it
- [ ] Unrecognized commands are handled gracefully, with a clear message, and do not crash the program
- [ ] Missing or non-numeric arguments to `add`/`subtract` are handled gracefully, with a clear message, and do not crash the program
- [ ] Program prints a final farewell message and the final value upon `exit`
- [ ] Code is organized into at least one clearly named method beyond `main` (e.g., a method to parse and handle a single command)

## Stretch Goals

Each stretch goal should be implemented as its own separate method — do not modify your original method(s) to accommodate these. Your original solution should remain intact and callable on its own.

- **Command History** — Add support for a `history` command, which prints every valid command entered so far, in the order they were entered.
- **Undo Command** — Add support for an `undo` command, which reverses the effect of the most recently entered `add`, `subtract`, or `reset` command, restoring the running value to what it was immediately before that command. Consider what `undo` should do if there is no previous command to undo.
