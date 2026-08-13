package com.revature.ccvi;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("--- Group Anagrams ---");
            
            while (true) {
                System.out.println("\nEnter words separated by spaces (or type 'exit' to quit):");
                System.out.println("Example: eat tea tan ate nat bat");
                System.out.print("> ");
                
                if (!scanner.hasNextLine()) {
                    break;
                }
                
                String inputLine = scanner.nextLine().trim();
                
                if (inputLine.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting program...");
                    break;
                }
                
                // Parse space-separated input, creating an empty array if the line is blank
                String[] parsedInput = inputLine.isEmpty() ? new String[0] : inputLine.split("\\s+");
                
                // Format and print the input
                String formattedInput = Arrays.stream(parsedInput)
                                              .map(s -> "\"" + s + "\"")
                                              .collect(Collectors.joining(", ", "[", "]"));
                System.out.println("Input: " + formattedInput);
                
                // Execute Core Requirement
                var groupedResult = groupAnagrams(parsedInput);
                
                // Dynamically determine the output label based on whether any anagrams were grouped
                boolean hasAnagrams = groupedResult.stream().anyMatch(group -> group.size() > 1);
                String outputLabel = hasAnagrams ? "Output (order-independent): " : "Output: ";
                
                System.out.println(outputLabel + formatOutput(groupedResult));
                
                // Execute Stretch Goals
                System.out.println("Stretch Goal - Largest Group(s): " + formatOutput(findLargestGroups(groupedResult)));
                System.out.println("Stretch Goal - Only Group Anagrams (2+): " + formatOutput(onlyGroupAnagrams(parsedInput)));
            }
        }
    }

    /**
     * Core Requirement: Groups anagrams together.
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return List.of(); 
        }
        
        return new ArrayList<>(
            Arrays.stream(strs)
                  .collect(Collectors.groupingBy(
                          str -> {
                              char[] chars = str.toCharArray();
                              Arrays.sort(chars);
                              return new String(chars);
                          },
                          // Use a LinkedHashMap to preserve the insertion order of the groups.
                          LinkedHashMap::new, 
                          Collectors.toList()
                  ))
                  .values()
        );
    }

    /**
     * Stretch Goal 1: Finds the largest group(s) of anagram matches.
     */
    public static List<List<String>> findLargestGroups(List<List<String>> groups) {
        if (groups == null || groups.isEmpty()) {
            return List.of();
        }
        
        int maxSize = groups.stream()
                            .mapToInt(List::size)
                            .max()
                            .orElse(0);
                            
        return groups.stream()
                     .filter(group -> group.size() == maxSize)
                     .toList(); 
    }

    /**
     * Stretch Goal 2: Returns only groups containing two or more strings.
     */
    public static List<List<String>> onlyGroupAnagrams(String[] strs) {
        return groupAnagrams(strs).stream()
                                  .filter(group -> group.size() >= 2)
                                  .toList();
    }

    /**
     * Helper utility to format standard output.
     */
    private static String formatOutput(List<List<String>> output) {
        if (output.isEmpty()) {
            return "[]";
        }
        return output.stream()
                     .map(list -> list.stream()
                                      .map(s -> "\"" + s + "\"")
                                      .collect(Collectors.joining(", ", "[", "]")))
                     .collect(Collectors.joining(", ", "[", "]"));
    }
}
