# Valid Parentheses

## Objective

Practice using a stack-based approach to track and validate nested/paired structures — a foundational pattern for problems involving matching, balancing, or nesting.

## Instructions

- Write a method that accepts a single parameter: a `String` containing only the following characters: `(`, `)`, `{`, `}`, `[`, `]`, `<`, and `>`. No other characters, letters, or numbers will appear in the input.
- The method should return a `boolean` indicating whether the brackets in the string are **balanced** — meaning every opening bracket has a matching closing bracket of the same type, and brackets are closed in the correct order (properly nested, not just present in equal counts).
- An empty string should be treated as valid/balanced, since there is nothing unbalanced about it.
- Consider what should happen with a string that has closing brackets with no corresponding opening bracket, or leftover unmatched opening brackets at the end — both of these cases should result in `false`.

> **Hint:** This is a natural fit for a `Stack` (from `java.util`): push opening brackets as they're encountered, and when a closing bracket is encountered, check that it matches the most recently pushed opening bracket.

## Example Interactions

**Example 1 — Balanced, single type**
```
Input: "()"
Output: true
```

**Example 2 — Balanced, multiple types**
```
Input: "()[]{}<>"
Output: true
```

**Example 3 — Mismatched types**
```
Input: "(]"
Output: false
```

**Example 4 — Wrong nesting order**
```
Input: "([)]"
Output: false
```

**Example 5 — Balanced, nested**
```
Input: "<{[]}>"
Output: true
```

**Example 6 — Unmatched opening bracket**
```
Input: "(<>"
Output: false
```

**Example 7 — Empty string**
```
Input: ""
Output: true
```

## Requirements Checklist

- [ ] Method accepts the string as a parameter (not hardcoded)
- [ ] Correctly identifies balanced strings as `true`, including strings using all four bracket types
- [ ] Correctly identifies unbalanced strings (wrong type, wrong order, or unmatched brackets) as `false`
- [ ] Empty string is treated as valid/balanced
- [ ] Code is organized into at least one clearly named method (avoid putting all logic directly in `main`)

## Stretch Goals

Each stretch goal should be implemented as its own separate method — do not modify your original method to accommodate these. Your original solution should remain intact and callable on its own.

- **Identify All Invalid Character Indexes** — Instead of just returning `true`/`false`, write a method that returns a `List<Integer>` (or an `int[]`) containing the index of every character that contributes to the string being unbalanced — this includes closing brackets with no valid matching opening bracket, and opening brackets left unmatched at the end of the string. If the string is fully valid/balanced, return an empty list (or empty array).
- **Matching Given Symbols** — Write a method that accepts the original string, plus a second parameter: an array (or list) of symbols. This array specifies which bracket type(s) should be checked for valid nesting — a given symbol may be provided as either its opening or closing form (for example, providing `(` or `)` should be treated the same way, indicating that the `(`/`)` pair should be checked). Your method should only validate nesting for the bracket types included in this array, and should ignore any other bracket characters present in the string entirely, as if they weren't there. For example, given the input string `"([)]"` and a symbols array containing only `[`, the method should return `true`: ignoring the parentheses entirely and looking only at the `[` and `]` characters in the string, in order, they appear as `[` followed by `]` — a properly matched and nested pair.
