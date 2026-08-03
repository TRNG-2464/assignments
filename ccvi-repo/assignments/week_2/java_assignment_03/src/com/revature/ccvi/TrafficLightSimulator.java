package com.revature.ccvi;

import java.util.Scanner;

public class TrafficLightSimulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Traffic Light Simulator ---");
        System.out.println("Type 'exit' at any prompt to quit.\n");

        while (true) {
            System.out.print("Enter starting color (e.g., Green, Yellow, Red): ");
            String colorInput = scanner.nextLine().trim();
            
            if (colorInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter number of ticks: ");
            String tickString = scanner.nextLine().trim();
            
            if (tickString.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            int ticksInput = 0;
            try {
                ticksInput = Integer.parseInt(tickString);
            } catch (NumberFormatException e) {
                System.out.println("Output: \"Invalid input: tick count must be a valid integer.\"\n");
                continue; 
            }

            // Call the core method
            String result = simulateLight(colorInput, ticksInput);
            System.out.println("Output: \"" + result + "\"\n");
        }
        
        scanner.close();
    }

    /*
     * Core Requirement: Simulates the traffic light transitions.
     */
    public static String simulateLight(String startColor, int ticks) {
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        // Map the starting color to its index in the cycle
        int startIndex = switch (startColor) {
            case "Green" -> 0;
            case "Yellow" -> 1;
            case "Red" -> 2;
            default -> -1;
        };

        if (startIndex == -1) {
            return "Invalid input: '" + startColor + "' is not a recognized light color.";
        }

        // Calculate the final color index using modulo arithmetic 
        int finalIndex = (startIndex + ticks) % 3;

        // Transition to the final color
        return switch (finalIndex) {
            case 0 -> "Green";
            case 1 -> "Yellow";
            case 2 -> "Red";
            default -> "Unknown"; 
        };
    }

    /*
     * Stretch Goal 1: Full Cycle Log
     */
    public static String[] fullCycleLog(String startColor, int ticks) {
        if (ticks < 0) return new String[]{"Invalid input: tick count cannot be negative."};
        
        int startIndex = switch (startColor) {
            case "Green" -> 0;
            case "Yellow" -> 1;
            case "Red" -> 2;
            default -> -1;
        };

        if (startIndex == -1) return new String[]{"Invalid input: unrecognized color."};

        String[] log = new String[ticks];
        for (int i = 1; i <= ticks; i++) {
            int currentIndex = (startIndex + i) % 3;
            log[i - 1] = switch (currentIndex) {
                case 0 -> "Green";
                case 1 -> "Yellow";
                case 2 -> "Red";
                default -> "Unknown";
            };
        }
        return log;
    }

    /*
     * Stretch Goal 2: Variable Duration Lights
     * Green = 3 ticks, Yellow = 1 tick, Red = 2 ticks (Cycle Length = 6)
     */
    public static String variableDurationLight(String startColor, int ticks) {
        if (ticks < 0) return "Invalid input: tick count cannot be negative.";

        // Determine the starting tick offset within the 6-tick cycle
        int startTickOffset = switch (startColor) {
            case "Green" -> 0;
            case "Yellow" -> 3;
            case "Red" -> 4;
            default -> -1;
        };

        if (startTickOffset == -1) {
            return "Invalid input: '" + startColor + "' is not a recognized light color.";
        }

        // Calculate total ticks elapsed in the context of the 6-tick cycle
        int currentTickInCycle = (startTickOffset + ticks) % 6;

        // Map the current tick back to the corresponding color
        return switch (currentTickInCycle) {
            case 0, 1, 2 -> "Green";
            case 3 -> "Yellow";
            case 4, 5 -> "Red";
            default -> "Unknown";
        };
    }

    /*
     * Stretch Goal 3: Exception Handling for Invalid Input
     */
    public static String simulateLightWithExceptions(String startColor, int ticks) {
        if (ticks < 0) {
            throw new IllegalArgumentException("Tick count cannot be negative.");
        }

        int startIndex = switch (startColor) {
            case "Green" -> 0;
            case "Yellow" -> 1;
            case "Red" -> 2;
            default -> throw new IllegalStateException("'" + startColor + "' is not a recognized light color.");
        };

        int finalIndex = (startIndex + ticks) % 3;

        return switch (finalIndex) {
            case 0 -> "Green";
            case 1 -> "Yellow";
            case 2 -> "Red";
            default -> "Unknown";
        };
    }
}
