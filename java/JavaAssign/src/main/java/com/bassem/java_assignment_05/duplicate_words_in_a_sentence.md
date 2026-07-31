# Duplicate Words in a Sentence

## Objective

Practice tokenizing a string into individual words, and using a data structure (such as a `Map`) to count occurrences of each word.

## Instructions

- Write a method that accepts a single parameter: a sentence `String`.
- Split the sentence into individual words, and determine how many times each word appears in the sentence.
- Word matching should be **case-insensitive** — for example, "The" and "the" should be counted as the same word.
- Print the results to the console in a list format, showing every unique word and its total count (see the example below for the expected format). Since words are being evaluated case-insensitively, all words in the console output should be printed in **lowercase**, regardless of how they originally appeared in the sentence.
- You can assume the input sentence will not contain punctuation — no punctuation stripping is required for this activity.
- You can assume the sentence provided will always contain at least one word — you do not need to handle `null` or empty string input for this activity.

## Example Interactions

**Example 1**
```
Input: "The time I went to the store I bought a watermelon"

Console Output:
the - 2, time - 1, i - 2, went - 1, to - 1, store - 1, bought - 1, a - 1, watermelon - 1
```

**Example 2 — No duplicates**
```
Input: "Every word here is unique"

Console Output:
every - 1, word - 1, here - 1, is - 1, unique - 1
```

## Requirements Checklist

- [ ] Method accepts the sentence as a parameter (not hardcoded)
- [ ] Sentence is correctly split into individual words
- [ ] Word comparison for counting is case-insensitive
- [ ] Console output clearly lists every unique word and its total count, in a list format
- [ ] All words in the console output are printed in lowercase, regardless of original casing
- [ ] Word order in the console output matches the order words first appear in the sentence
- [ ] Code is organized into at least one clearly named method (avoid putting all logic directly in `main`)

## Stretch Goals

Each stretch goal should be implemented as its own separate method — do not modify your original method to accommodate these. Your original solution should remain intact and callable on its own.

- **Remove Duplicate Words** — Return a new `String` representing the original sentence with all *duplicate* occurrences of a word removed, keeping only the **first** occurrence of each word, in its original order and original casing. For example, given the input `"The time I went to the store I bought a watermelon"`, this method should return `"The time I went to store bought a watermelon"`.
- **Sentence Statistics** — Given the same sentence, determine and report the following:
  - The most frequently occurring word(s) in the sentence (report all of them if there is a tie)
  - The least frequently occurring word(s) in the sentence (report all of them if there is a tie)
  - The longest word(s) in the sentence, by character count (report all of them if there is a tie)
  - The shortest word(s) in the sentence, by character count (report all of them if there is a tie)
