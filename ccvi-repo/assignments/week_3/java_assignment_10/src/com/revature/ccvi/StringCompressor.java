package com.revature.ccvi;

import java.util.Scanner;

public class StringCompressor {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input: ");
            String input = scanner.nextLine();
            
            // Clean up double quotes if the user typed them to match the example format exactly
            if (input.startsWith("\"") && input.endsWith("\"") && input.length() >= 2) {
                input = input.substring(1, input.length() - 1);
            }
            
            String compressed = compress(input);
            System.out.println("Output: \"" + compressed + "\"");
        }
    }

    /**
     * Core Requirement: Compresses a string by replacing runs of identical
     * characters with the character and its count.
     */
    public static String compress(String input) {
        // Handles empty strings without crashing
        if (input == null || input.isEmpty()) {
            return "";
        }

        var compressed = new StringBuilder();
        char currentChar = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            char nextChar = input.charAt(i);
            
            // Identifies runs case-insensitively
            if (Character.toLowerCase(currentChar) == Character.toLowerCase(nextChar)) {
                count++;
            } else {
                compressed.append(currentChar).append(count);
                currentChar = nextChar;
                count = 1;
            }
        }
        
        // Appends the character followed by its run count for the final run, even if length is 1
        compressed.append(currentChar).append(count);
        return compressed.toString();
    }

    /**
     * Stretch Goal 1: Returns the compressed string only if it is shorter than the original input string.
     */
    public static String compressIfShorter(String input) {
        String compressed = compress(input);
        return compressed.length() < input.length() ? compressed : input;
    }

    /**
     * Stretch Goal 2: Decompression (expands a compressed string back into an uncompressed string).
     */
    public static String decompress(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        
        var decompressed = new StringBuilder();
        int i = 0;
        
        while (i < input.length()) {
            char c = input.charAt(i);
            i++;
            int count = 0;
            
            // Extracts the count (handles multi-digit counts appropriately)
            while (i < input.length() && Character.isDigit(input.charAt(i))) {
                count = count * 10 + (input.charAt(i) - '0');
                i++;
            }
            
            decompressed.repeat(c, count);
        }
        
        return decompressed.toString();
    }
}
