# Valid Parentheses Validator

## Objective
A Java application that utilizes a stack-based approach to track and validate nested and paired bracket structures.

## Features
- **Interactive CLI**: Continuously prompts for input until the user types `quit`.
- **Input Sanitization**: Automatically strips surrounding double quotes from the user's input to accommodate copy-pasted examples.
- **Balanced Validation**: Evaluates if strings containing `()`, `{}`, `[]`, and `<>` are properly matched and correctly nested. Treats empty strings as valid and perfectly balanced.
- **Stretch Goals Included**:
  - `identifyInvalidIndexes`: Identifies and returns a list of indexes for any brackets that contribute to an unbalanced state (e.g., unmatched opening or closing brackets).
  - `isValidForSymbols`: Validates nesting strictly for a specified subset of bracket symbols while ignoring all other characters in the string.

## Prerequisites
- **Java Development Kit (JDK) 21** or higher.

## Getting Started

### 1. Compilation
Navigate to the directory containing the project file in your terminal and compile the source code:
```bash
javac ValidParentheses.java
```

### 2. Execution
Start the interactive program by running:
```bash
java ValidParentheses
```

## Example Usage

```text
--- Valid Parentheses Validator ---
Enter brackets (or type 'quit' to exit): ()[]{}<>
Input: "()[]{}<>"
Output: true
-----------------------------------
Enter brackets (or type 'quit' to exit): "(]"
Input: "(]"
Output: false
-----------------------------------
Enter brackets (or type 'quit' to exit): quit
Exiting program. Goodbye!
```
