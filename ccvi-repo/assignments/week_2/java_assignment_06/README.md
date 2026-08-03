# Command-Based Calculator

## Overview
This project is a Java console application designed to practice reading repeated input from the console inside a loop. It parses text into commands and arguments while maintaining a running numeric value across iterations until the user chooses to exit.

## System Prerequisites
- **Java Development Kit (JDK):** Version 21 or higher is explicitly required to execute this application and leverage modern Java features.

## Features
The calculator starts with a running value of `0` and supports the following core commands:
*   `add [number]` — Adds the specified number to the running value.
*   `subtract [number]` — Subtracts the specified number from the running value.
*   `reset` — Resets the running value back to `0`.
*   `total` — Prints the current running value without changing it.
*   `exit` — Prints a final farewell message with the final value and terminates the program.

### Advanced Features (Stretch Goals)
*   **Command History**: The `history` command prints every valid command entered during the session, in chronological order.
*   **Undo Functionality**: The `undo` command reverses the effect of the most recently entered `add`, `subtract`, or `reset` command, restoring the running value to its previous state.

### Error Handling
*   Gracefully handles unrecognized commands with a clear error message instead of crashing.
*   Gracefully handles missing or non-numeric arguments for math commands (e.g., `add banana`).

## How to Run

1. Open your terminal or command prompt.
2. Navigate to the directory containing `CommandBasedCalculator.java`.
3. Compile the program using the Java compiler:
   ```bash
   javac CommandBasedCalculator.java
   ```
4. Run the compiled application:
   ```bash
   java CommandBasedCalculator
   ```

## Example Interaction

```text
Enter a command: add 5
Added 5. Running total: 5

Enter a command: add 10
Added 10. Running total: 15

Enter a command: subtract 3
Subtracted 3. Running total: 12

Enter a command: total
Current total: 12

Enter a command: undo
Undo successful. Restored running total to: 15

Enter a command: history
Command History:
1. add 5
2. add 10
3. undo

Enter a command: add banana
'add' requires a valid number. Please try again.

Enter a command: exit
Goodbye! Final total: 15
```
