package com.revature.ccvi;

import java.util.Arrays;
import java.util.Scanner;

public class ClosestValueFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("## Interactive Mode Initialized");
        
        while (true) {
            System.out.println("\nEnter an array of positive integers separated by spaces (or type 'exit' to quit):");
            String line = scanner.nextLine().trim();
            
            if (line.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program...");
                break;
            }
            
            if (line.isEmpty()) {
                continue;
            }
            
            try {
                System.out.println("Enter target integer:");
                int userTarget = Integer.parseInt(scanner.nextLine().trim());
                
                String[] parts = line.split("\\s+");
                int[] userArray = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    userArray[i] = Integer.parseInt(parts[i]);
                }
                
                System.out.println("\nInput: array = " + Arrays.toString(userArray) + ", target = " + userTarget);
                System.out.println("Output: " + closestValue(userArray, userTarget));
                
                // Outputting stretch goals based on user input
                System.out.println("\nStretch Goal (Top 2 Closest): " + Arrays.toString(closestKValues(userArray, userTarget, 2)));
                System.out.println("Stretch Goal (Farthest): " + farthestValue(userArray, userTarget));
                System.out.println("Stretch Goal (Higher Flag): " + closestValue(userArray, userTarget, true));
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input detected. Please ensure you only enter valid integers.");
            }
        }
        
        scanner.close();
    }

    // ---------------------------------------------------------
    // PRIMARY REQUIREMENT
    // ---------------------------------------------------------
    public static int closestValue(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        
        int best = array[0];
        for (int num : array) {
            int currentDiff = Math.abs(num - target);
            int bestDiff = Math.abs(best - target);
            
            if (currentDiff < bestDiff) {
                best = num;
            } else if (currentDiff == bestDiff) {
                best = Math.min(best, num);
            }
        }
        return best;
    }

    // ---------------------------------------------------------
    // STRETCH GOALS
    // ---------------------------------------------------------
    
    // Stretch Goal 1: Closest 'K' Values
    public static int[] closestKValues(int[] array, int target, int k) {
        if (array == null || array.length == 0 || k <= 0) {
            return new int[0];
        }
        
        Integer[] boxedArray = Arrays.stream(array).boxed().toArray(Integer[]::new);
        
        Arrays.sort(boxedArray, (a, b) -> {
            int diffA = Math.abs(a - target);
            int diffB = Math.abs(b - target);
            if (diffA == diffB) {
                return Integer.compare(a, b); 
            }
            return Integer.compare(diffA, diffB);
        });
        
        int limit = Math.min(k, boxedArray.length);
        int[] result = new int[limit];
        for (int i = 0; i < limit; i++) {
            result[i] = boxedArray[i];
        }
        
        return result;
    }

    // Stretch Goal 2: Find Farthest Match
    public static int farthestValue(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        
        int worst = array[0];
        for (int num : array) {
            int currentDiff = Math.abs(num - target);
            int worstDiff = Math.abs(worst - target);
            
            if (currentDiff > worstDiff) {
                worst = num;
            } else if (currentDiff == worstDiff) {
                worst = Math.min(worst, num);
            }
        }
        return worst;
    }

    // Stretch Goal 3: Higher/Lower Flag
    public static int closestValue(int[] array, int target, boolean returnLarger) {
        if (array == null || array.length == 0) {
            return -1;
        }
        
        int best = array[0];
        for (int num : array) {
            int currentDiff = Math.abs(num - target);
            int bestDiff = Math.abs(best - target);
            
            if (currentDiff < bestDiff) {
                best = num;
            } else if (currentDiff == bestDiff) {
                best = returnLarger ? Math.max(best, num) : Math.min(best, num);
            }
        }
        return best;
    }
}
