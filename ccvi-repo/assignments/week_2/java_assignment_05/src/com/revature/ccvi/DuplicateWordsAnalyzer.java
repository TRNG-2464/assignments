package com.revature.ccvi;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SequencedMap;
import java.util.SequencedSet;
import java.util.stream.Collectors;

public class DuplicateWordsAnalyzer {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("--- Duplicate Words Analyzer ---");

        while (keepRunning) {
            System.out.print("\nEnter a sentence to analyze (or type 'exit' to quit): ");
            String sentence = inputScanner.nextLine().trim();

            // Check for exit condition
            if (sentence.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                keepRunning = false;
                break;
            }

            // Handle empty input
            if (sentence.isEmpty()) {
                System.out.println("No input detected. Please enter a valid sentence.");
                continue;
            }

            // Core Requirement execution
            System.out.println("\nInput: \"" + sentence + "\"\n");
            System.out.println("Console Output:");
            countWords(sentence);

            // Stretch Goals Prompt
            System.out.print("\nWould you like to run the Stretch Goals for this sentence? (y/n): ");
            String runStretch = inputScanner.nextLine().trim();

            if (runStretch.equalsIgnoreCase("y") || runStretch.equalsIgnoreCase("yes")) {
                System.out.println("\n--- STRETCH GOALS ---");
                
                System.out.println("Remove Duplicate Words:");
                System.out.println(removeDuplicateWords(sentence));
                
                System.out.println("\nSentence Statistics:");
                printSentenceStatistics(sentence);
            }
            
            System.out.println("\n--------------------------------------------------");
        }
        
        inputScanner.close();
    }

    /**
     * Core Requirement: Tokenizes a sentence, counts words case-insensitively, 
     * and prints them in original occurrence order.
     */
    public static void countWords(String sentence) {
        // Utilizing SequencedMap to explicitly define an ordered map
        SequencedMap<String, Integer> wordCounts = new LinkedHashMap<>();

        try (Scanner stringScanner = new Scanner(sentence)) {
            while (stringScanner.hasNext()) {
                // Read word and immediately convert to lowercase for case-insensitive matching
                String word = stringScanner.next().toLowerCase();
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }

        // Formatting the output: "word - count, word - count"
        String output = wordCounts.sequencedEntrySet().stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .collect(Collectors.joining(", "));

        System.out.println(output);
    }

    /**
     * Stretch Goal 1: Removes duplicate words, keeping only the first occurrence 
     * in its original order and casing.
     */
    public static String removeDuplicateWords(String sentence) {
        // Utilizing SequencedSet for ordered unique elements
        SequencedSet<String> seenWords = new LinkedHashSet<>();
        List<String> result = new ArrayList<>();

        try (Scanner stringScanner = new Scanner(sentence)) {
            while (stringScanner.hasNext()) {
                String originalWord = stringScanner.next();
                // Set.add() returns true if the collection did not already contain the element
                if (seenWords.add(originalWord.toLowerCase())) {
                    result.add(originalWord);
                }
            }
        }
        
        return String.join(" ", result);
    }

    /**
     * Stretch Goal 2: Determines and reports frequency and length statistics.
     */
    public static void printSentenceStatistics(String sentence) {
        SequencedMap<String, Integer> wordCounts = new LinkedHashMap<>();

        try (Scanner stringScanner = new Scanner(sentence)) {
            while (stringScanner.hasNext()) {
                String lowerWord = stringScanner.next().toLowerCase();
                wordCounts.put(lowerWord, wordCounts.getOrDefault(lowerWord, 0) + 1);
            }
        }

        // Calculate Maximums and Minimums
        int maxFreq = wordCounts.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        int minFreq = wordCounts.values().stream().mapToInt(Integer::intValue).min().orElse(0);

        List<String> uniqueWords = new ArrayList<>(wordCounts.sequencedKeySet());
        int maxLength = uniqueWords.stream().mapToInt(String::length).max().orElse(0);
        int minLength = uniqueWords.stream().mapToInt(String::length).min().orElse(0);

        // Filter to find all ties
        List<String> mostFreq = wordCounts.entrySet().stream()
                .filter(e -> e.getValue() == maxFreq).map(Map.Entry::getKey).toList();
        List<String> leastFreq = wordCounts.entrySet().stream()
                .filter(e -> e.getValue() == minFreq).map(Map.Entry::getKey).toList();
        List<String> longest = uniqueWords.stream()
                .filter(w -> w.length() == maxLength).toList();
        List<String> shortest = uniqueWords.stream()
                .filter(w -> w.length() == minLength).toList();

        // Output results
        System.out.println("- Most frequent:  " + String.join(", ", mostFreq) + " (" + maxFreq + ")");
        System.out.println("- Least frequent: " + String.join(", ", leastFreq) + " (" + minFreq + ")");
        System.out.println("- Longest:        " + String.join(", ", longest) + " (" + maxLength + " chars)");
        System.out.println("- Shortest:       " + String.join(", ", shortest) + " (" + minLength + " chars)");
    }
}
