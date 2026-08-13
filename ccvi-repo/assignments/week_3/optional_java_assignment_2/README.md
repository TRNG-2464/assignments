# Group Anagrams

A Java command-line application that processes a list of words and groups them into sets of anagrams. Two strings are considered anagrams if they contain exactly the same characters with the same frequency, just in a different order.

## Features

- **Core Functionality:** Groups strings into anagram sets regardless of their order in the input. Words with no anagram matches are placed in their own single-item group.
- **Largest Group Finder (Stretch Goal 1):** Identifies and returns the largest group(s) of anagram matches.
- **Only Group Anagrams (Stretch Goal 2):** Filters the output to return only groups that contain two or more strings, excluding singletons.
- **Interactive CLI:** A user-friendly, space-separated interactive loop for continuous testing. 

## Requirements

- **Java Development Kit (JDK):** Version 21 or higher.

## How to Run

1. **Compile the code:**
   Open your terminal, navigate to the directory containing `GroupAnagrams.java`, and run:
   ```bash
   javac GroupAnagrams.java
   ```

2. **Execute the program:**
   Run the compiled Java class:
   ```bash
   java GroupAnagrams
   ```

3. **Usage:**
   When prompted, enter a list of words separated by spaces.
   ```text
   Enter words separated by spaces (or type 'exit' to quit):
   Example: eat tea tan ate nat bat
   > eat tea tan ate nat bat
   ```

## Example Interactions

**Example 1: Standard Input**
```text
> eat tea tan ate nat bat
Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
Output (order-independent): [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
Stretch Goal - Largest Group(s): [["eat", "tea", "ate"]]
Stretch Goal - Only Group Anagrams (2+): [["eat", "tea", "ate"], ["tan", "nat"]]
```

**Example 2: No anagram matches**
```text
> abc def
Input: ["abc", "def"]
Output: [["abc"], ["def"]]
Stretch Goal - Largest Group(s): [["abc"], ["def"]]
Stretch Goal - Only Group Anagrams (2+): []
```

**Example 3: Empty input**
```text
> 
Input: []
Output: []
Stretch Goal - Largest Group(s): []
Stretch Goal - Only Group Anagrams (2+): []
```
