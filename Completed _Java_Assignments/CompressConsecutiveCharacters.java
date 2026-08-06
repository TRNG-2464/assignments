public class CompressConsecutiveCharacters {

    public static void main(String[] args) {
        // Examples from the prompt
        System.out.println(compress("aaabbbccd")); // Output: a3b3c2d1
        System.out.println(compress("abcd"));      // Output: a1b1c1d1
        System.out.println(compress("aaaaaa"));    // Output: a6
        System.out.println(compress("aAaA"));      // Output: a4
        System.out.println(compress(""));          // Output: ""

        // Stretch Goal 1 Test
        System.out.println(compressIfShorter("aAaA")); // Output: a4
        System.out.println(compressIfShorter("abcd")); // Output: abcd

        // Stretch Goal 2 Test
        System.out.println(decompress("a3b3c2d1"));  // Output: aaabbbccd
        System.out.println(decompress("a4"));        // Output: aaaa
    }

    /**
     * Primary Method: Compresses consecutive characters case-insensitively while preserving
     * the casing of the first character in each run.
     */
    public static String compress(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder compressed = new StringBuilder();

        char currentChar = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            char nextChar = input.charAt(i);

            // Compare case-insensitively
            if (Character.toLowerCase(nextChar) == Character.toLowerCase(currentChar)) {
                count++;
            } else {
                // Append the preserved first character and its count
                compressed.append(currentChar).append(count);

                // Reset for the new run
                currentChar = nextChar;
                count = 1;
            }
        }

        // Append the final run after the loop ends
        compressed.append(currentChar).append(count);

        return compressed.toString();
    }

    /**
     * Stretch Goal 1: Returns the compressed string only if it is shorter
     * than the original input string; otherwise, returns the original string.
     */
    public static String compressIfShorter(String input) {
        String compressed = compress(input);
        return compressed.length() < input.length() ? compressed : input;
    }

    /**
     * Stretch Goal 2: Expands a compressed string back to its uncompressed form.
     */
    public static String decompress(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder decompressed = new StringBuilder();
        int i = 0;

        while (i < input.length()) {
            // Get the character of the run
            char c = input.charAt(i++);

            // Read the number count (handles multi-digit counts like 'a12')
            int startNumIndex = i;
            while (i < input.length() && Character.isDigit(input.charAt(i))) {
                i++;
            }

            int count = Integer.parseInt(input.substring(startNumIndex, i));

            // Repeat character 'count' times
            for (int k = 0; k < count; k++) {
                decompressed.append(c);
            }
        }

        return decompressed.toString();
    }
}