package com.revature.ccvi;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.SequencedCollection;
import java.util.Set;

public class ValidParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Valid Parentheses Validator ---");
        
        while (true) {
            // Explicit prompt for interactive looping
            System.out.print("Enter brackets (or type 'quit' to exit): ");
            
            if (!scanner.hasNextLine()) {
                break;
            }
            
            String input = scanner.nextLine().trim();
            
            // Exit condition
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }
            
            // Sanitize: Strip surrounding double quotes if present
            if (input.startsWith("\"") && input.endsWith("\"") && input.length() >= 2) {
                input = input.substring(1, input.length() - 1);
            }
            
            boolean isBalanced = isValid(input);
            System.out.println("Input: \"" + input + "\"");
            System.out.println("Output: " + isBalanced);
            System.out.println("-----------------------------------");
        }
        
        scanner.close();
    }

    /**
     * MAIN REQUIREMENT: Validates whether a string of brackets is balanced.
     * Treats an empty string as balanced.
     */
    public static boolean isValid(String s) {
        if (s == null) return false;
        
        // Java 21 SequencedCollection interface used as a stack
        SequencedCollection<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            switch (c) {
                // Push opening brackets onto the stack
                case '(', '{', '[', '<' -> stack.addFirst(c);
                
                // For closing brackets, check if the stack is empty or the top doesn't match
                case ')' -> {
                    if (stack.isEmpty() || stack.removeFirst() != '(') return false;
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.removeFirst() != '{') return false;
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.removeFirst() != '[') return false;
                }
                case '>' -> {
                    if (stack.isEmpty() || stack.removeFirst() != '<') return false;
                }
                default -> {
                    // Method strictly assumes only specified characters will appear
                    return false; 
                }
            }
        }
        
        // If stack is empty, all brackets were properly matched and closed
        return stack.isEmpty();
    }
    
    // --- STRETCH GOALS ---

    // Java Record to tightly couple a character with its original string index
    private record BracketInfo(char symbol, int index) {}
    
    /**
     * STRETCH GOAL 1: Identifies the indexes of all invalid brackets.
     * Includes unmatched closing brackets and leftover unmatched opening brackets.
     */
    public static List<Integer> identifyInvalidIndexes(String s) {
        List<Integer> invalidIndexes = new ArrayList<>();
        SequencedCollection<BracketInfo> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(', '{', '[', '<' -> stack.addFirst(new BracketInfo(c, i));
                case ')' -> {
                    if (stack.isEmpty() || stack.removeFirst().symbol() != '(') invalidIndexes.add(i);
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.removeFirst().symbol() != '{') invalidIndexes.add(i);
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.removeFirst().symbol() != '[') invalidIndexes.add(i);
                }
                case '>' -> {
                    if (stack.isEmpty() || stack.removeFirst().symbol() != '<') invalidIndexes.add(i);
                }
            }
        }
        
        // Any opening brackets remaining in the stack were left unmatched at the end
        for (BracketInfo info : stack) {
            invalidIndexes.add(info.index());
        }
        
        invalidIndexes.sort(Integer::compareTo);
        return invalidIndexes;
    }

    /**
     * STRETCH GOAL 2: Validates nesting based only on a provided subset of bracket symbols.
     * All other characters in the string are ignored.
     */
    public static boolean isValidForSymbols(String s, char[] symbols) {
        if (s == null || symbols == null) return false;
        
        // Identify which bracket pairs we should care about
        Set<Character> validTokens = getValidTokensForSymbols(symbols);
        SequencedCollection<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (!validTokens.contains(c)) continue; // Ignore ignored brackets entirely
            
            switch (c) {
                case '(', '{', '[', '<' -> stack.addFirst(c);
                case ')' -> {
                    if (stack.isEmpty() || stack.removeFirst() != '(') return false;
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.removeFirst() != '{') return false;
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.removeFirst() != '[') return false;
                }
                case '>' -> {
                    if (stack.isEmpty() || stack.removeFirst() != '<') return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    // Helper method to convert the array of symbols into a comprehensive set of matching parts
    private static Set<Character> getValidTokensForSymbols(char[] symbols) {
        Set<Character> set = new HashSet<>();
        for (char c : symbols) {
            switch (c) {
                case '(', ')' -> { set.add('('); set.add(')'); }
                case '{', '}' -> { set.add('{'); set.add('}'); }
                case '[', ']' -> { set.add('['); set.add(']'); }
                case '<', '>' -> { set.add('<'); set.add('>'); }
            }
        }
        return set;
    }
}
