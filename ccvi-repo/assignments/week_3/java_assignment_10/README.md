# String Compressor

A Java application that implements string compression by replacing runs of consecutive, identical characters with the character followed by its count.

## Features

*   **Core Compression:** Compresses strings (e.g., `"aaabbbccd"` to `"a3b3c2d1"`).
*   **Case-Insensitive:** Treats uppercase and lowercase characters as the same run (e.g., `"aA"` becomes `"a2"`), preserving the casing of the first character.
*   **Stretch Goals Included:**
    *   `compressIfShorter(String input)`: Returns the compressed string only if it is shorter than the original input string.
    *   `decompress(String input)`: Expands a compressed string back into its original (lossy) form.

## Requirements

*   Java JDK 21 or higher.

## How to Run

1.  Compile the program:
    ```bash
    javac StringCompressor.java
    ```
2.  Run the program:
    ```bash
    java StringCompressor
    ```
3.  Enter a string when prompted:
    ```text
    Input: aaabbbccd
    Output: "a3b3c2d1"
    ```
