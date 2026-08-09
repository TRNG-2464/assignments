# Group Anagrams

## Objective

Practice grouping elements by a computed key that represents some canonical or normalized form of each item — a pattern that generalizes well beyond just anagrams (grouping, deduplication, and categorization problems all share this shape).

## Instructions

- Write a method that accepts a single parameter: an array of `String` values (`String[]`). You can assume all input strings consist of lowercase letters only, with no punctuation, numbers, or spaces.
- The method should group the strings into sets of anagrams of one another — two strings are anagrams if they contain exactly the same characters, with the same frequency, just in a different order.
- The method should return a grouped structure — a `List<List<String>>`, where each inner list contains all strings from the input that are anagrams of one another.
- The order of the groups in the output, and the order of strings within each group, does not need to match any particular order — output will be evaluated based on which strings ended up grouped together, not the order they appear in.
- If the input array is empty, return an empty grouped result, rather than crashing.
- A string with no anagram matches anywhere else in the input should still appear in the output, as its own group containing just that one string.

> **Hint:** A `Map` can help here — consider computing some canonical form of each string (for example, its characters sorted into a fixed order) and using that as a key to group matching strings together, rather than comparing every string against every other string directly.

## Example Interactions

**Example 1**
```
Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
Output (order-independent): [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
```

**Example 2 — No anagram matches**
```
Input: ["abc", "def"]
Output: [["abc"], ["def"]]
```

**Example 3 — Empty input**
```
Input: []
Output: []
```

## Requirements Checklist

- [ ] Method accepts the array of strings as a parameter (not hardcoded)
- [ ] Correctly groups all anagram matches together, regardless of their order in the input
- [ ] Strings with no anagram matches appear in the output as their own group of one
- [ ] Empty input returns an empty result, without crashing
- [ ] Code is organized into at least one clearly named method (avoid putting all logic directly in `main`)

## Stretch Goals

Each stretch goal should be implemented as its own separate method — do not modify your original method to accommodate these. Your original solution should remain intact and callable on its own.

- **Largest Group Finder** — Given the grouped result, determine and return the largest group (the group containing the most anagram matches). If there is a tie for the largest group size, return all of the tied groups.
- **Only Group Anagrams** — Write a variation of your original method that returns only the groups containing **two or more** strings — any string with no anagram matches (a group of one) should be excluded entirely from the returned result, rather than appearing as its own singleton group.
