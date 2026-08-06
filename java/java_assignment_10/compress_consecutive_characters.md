# Compress Consecutive Characters

## Objective

Practice iterating through a string while comparing adjacent characters, tracking a running count, and building a new string incrementally based on that tracking.

## Instructions

- Write a method that accepts a single parameter: a `String`.
- The method should return a new `String` where runs of consecutive, identical characters are replaced with the character followed by the count of how many times it repeated in that run (for example, `"aaabbbccd"` becomes `"a3b3c2d1"`).
- A character that does not repeat (a run of length 1) should still be followed by a `1` in the output, as shown in the example.
- Runs should be identified **case-insensitively** — for example, `"aA"` should be treated as a single run of length 2, not two separate runs. The character used in the compressed output for a given run should match the casing of the **first** character in that run (for example, `"aA"` compresses to `"a2"`, while `"Aa"` compresses to `"A2"`).
- Consider how your method should handle an empty string as input.

## Example Interactions

**Example 1**
```
Input: "aaabbbccd"
Output: "a3b3c2d1"
```

**Example 2 — No repeats**
```
Input: "abcd"
Output: "a1b1c1d1"
```

**Example 3 — Entire string is one run**
```
Input: "aaaaaa"
Output: "a6"
```

**Example 4 — Case-insensitive run, output keeps first character's casing**
```
Input: "aAaA"
Output: "a4"
```

**Example 5 — Empty string**
```
Input: ""
Output: ""
```

## Requirements Checklist

- [ ] Method accepts the string as a parameter (not hardcoded)
- [ ] Correctly identifies runs of consecutive identical characters
- [ ] Runs are identified case-insensitively (e.g., `"aA"` counts as one run)
- [ ] The character used in the output for each run matches the casing of that run's first character
- [ ] Correctly appends the character followed by its run count for every run, including runs of length 1
- [ ] Empty string input is handled without crashing, and returns an empty string
- [ ] Code is organized into at least one clearly named method (avoid putting all logic directly in `main`)

## Stretch Goals

Each stretch goal should be implemented as its own separate method — do not modify your original method to accommodate these. Your original solution should remain intact and callable on its own.

- **Only Compress When Shorter** — Return the compressed string only if it is actually shorter than the original input string; otherwise, return the original string unchanged.
- **Decompression** — Write a companion method that accepts a compressed string (in the same `letter + count` format produced by your original method) and expands it back into an uncompressed string. Keep in mind that compression is *lossy* with respect to casing: since each run only preserves the casing of its first character, decompression cannot recover the exact original mixed-case input if a run contained mixed casing (for example, both `"aA"` and `"AA"` compress to `"a2"` and `"A2"` respectively, but decompressing `"a2"` should simply produce `"aa"` — every character in the run takes on the casing recorded in the compressed string, rather than attempting to guess the original mix).
