# Duplicate Word Analysis Utility

## Project Overview
This project focuses on the development of a Java-based command-line utility designed to perform string tokenization and frequency analysis. The primary objective is to parse an input string into individual word tokens and utilize data structures (such as a `Map`) to compute the occurrence frequency of each unique token.

## System Prerequisites
- **Java Development Kit (JDK):** Version 21 or higher is explicitly required to execute this application and leverage modern Java features.

## Technical Requirements
- **Method Implementation:** Implement a dedicated method that accepts a single `String` parameter representing the target sentence.
- **Tokenization:** The sentence must be parsed into discrete words to accurately determine the frequency of each token.
- **Case-Insensitive Evaluation:** Lexical matching must be strictly case-insensitive (e.g., "The" and "the" evaluate to the same token).
- **Standardized Output Formatting:** Results must be printed to the standard console in a precise list format, displaying each unique word alongside its total count.
- **Output Normalization:** All parsed tokens in the console output must be normalized to lowercase, regardless of their original capitalization in the input string.
- **Assumptions:** For the scope of this assignment, the input will be completely free of punctuation, and will reliably contain at least one valid word. Handling for `null` or empty string inputs is not required.

## Execution Examples

**Example 1**
```text
Input: "The time I went to the store I bought a watermelon"

Console Output:
the - 2, time - 1, i - 2, went - 1, to - 1, store - 1, bought - 1, a - 1, watermelon - 1
```

**Example 2 — Unique Tokens**
```text
Input: "Every word here is unique"

Console Output:
every - 1, word - 1, here - 1, is - 1, unique - 1
```
