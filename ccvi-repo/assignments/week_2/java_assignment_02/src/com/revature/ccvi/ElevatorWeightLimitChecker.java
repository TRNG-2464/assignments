package com.revature.ccvi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ElevatorWeightLimitChecker {

    // Represents the elevator evaluation outcome
    public record ElevatorResult(boolean isOverloaded, int overloadPassengerNumber, double totalWeight) {
        public String formatResult() {
            if (isOverloaded) {
                // For overload scenarios
                return String.format("\"Passenger %d caused an overload. Total weight at that point: %.0f lbs.\"",
                        overloadPassengerNumber, totalWeight);
            } else {
                // For safe scenarios
                return String.format("\"All passengers boarded safely. Total weight: %.0f lbs.\"", totalWeight);
            }
        }
    }

    // Holds stretch goal calculation for min/max weights
    public record MinMaxWeights(double min, double max) {}

    // Holds stretch goal calculation for multiple trips
    public record TripResult(int totalTrips, List<List<Double>> trips) {}

    /**
     * Core Requirement: Evaluates passenger weights against elevator weight limit.
     * 
     * @param weightLimit Maximum allowed weight
     * @param passengerWeights List of passenger weights in order of arrival
     * @return ElevatorResult record with overload status and metrics
     */
    public static ElevatorResult checkElevatorLimit(double weightLimit, List<Double> passengerWeights) {
        if (passengerWeights == null || passengerWeights.isEmpty()) {
            return new ElevatorResult(false, 0, 0.0);
        }

        double runningTotal = 0.0;

        for (int i = 0; i < passengerWeights.size(); i++) {
            double weight = passengerWeights.get(i);
            runningTotal += weight;

            if (runningTotal >= weightLimit) {
                return new ElevatorResult(true, i + 1, runningTotal);
            }
        }

        return new ElevatorResult(false, 0, runningTotal);
    }

    // --- STRETCH GOALS ---

    public static int maxSafePassengers(double weightLimit, List<Double> passengerWeights) {
        if (passengerWeights == null || passengerWeights.isEmpty()) {
            return 0;
        }

        double runningTotal = 0.0;
        int count = 0;

        for (double weight : passengerWeights) {
            if (runningTotal + weight >= weightLimit) {
                break;
            }
            runningTotal += weight;
            count++;
        }

        return count;
    }

    public static MinMaxWeights getMinMaxBoardedWeights(double weightLimit, List<Double> passengerWeights) {
        if (passengerWeights == null || passengerWeights.isEmpty()) {
            return new MinMaxWeights(0.0, 0.0);
        }

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double runningTotal = 0.0;

        for (double weight : passengerWeights) {
            runningTotal += weight;
            min = Math.min(min, weight);
            max = Math.max(max, weight);

            if (runningTotal >= weightLimit) {
                break; 
            }
        }

        return new MinMaxWeights(min, max);
    }

    public static TripResult calculateTrips(double weightLimit, List<Double> passengerWeights) {
        List<List<Double>> trips = new ArrayList<>();
        if (passengerWeights == null || passengerWeights.isEmpty()) {
            return new TripResult(0, trips);
        }

        List<Double> currentTrip = new ArrayList<>();
        double currentTripTotal = 0.0;

        for (double weight : passengerWeights) {
            if (currentTripTotal + weight >= weightLimit && !currentTrip.isEmpty()) {
                trips.add(currentTrip);
                currentTrip = new ArrayList<>();
                currentTripTotal = 0.0;
            }
            currentTrip.add(weight);
            currentTripTotal += weight;
        }

        if (!currentTrip.isEmpty()) {
            trips.add(currentTrip);
        }

        return new TripResult(trips.size(), trips);
    }

    // --- INTERACTIVE DRIVER ---

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        boolean keepChecking = true;

        System.out.println("=========================================");
        System.out.println("      Elevator Weight Limit Checker      ");
        System.out.println("=========================================\n");

        while (keepChecking) {
            System.out.print("Enter maximum weight limit (lbs): ");
            double weightLimit = scanner.nextDouble();

            System.out.print("Enter passenger weights separated by spaces (e.g. 150 200 300): ");
            scanner.nextLine();
            String inputLine = scanner.nextLine().trim();

            List<Double> passengerWeights = new ArrayList<>();
            if (!inputLine.isEmpty()) {
                String[] tokens = inputLine.split("\\s+");
                for (String token : tokens) {
                    try {
                        passengerWeights.add(Double.parseDouble(token));
                    } catch (NumberFormatException e) {
                        System.out.println("Warning: Skipping invalid number token '" + token + "'");
                    }
                }
            }

            System.out.println("\n------------------------------------------------");

            // Format the passenger weights to look like an integer array string [150, 200, 300]
            String formattedArray = passengerWeights.stream()
                    .map(w -> String.valueOf(w.intValue()))
                    .collect(Collectors.joining(", ", "[", "]"));

            // Echo the input
            System.out.printf("Input: weightLimit = %d, passengerWeights = %s%n", 
                    (int) weightLimit, formattedArray);

            // Output
            ElevatorResult result = checkElevatorLimit(weightLimit, passengerWeights);
            System.out.printf("Output: %s%n", result.formatResult());

            System.out.println("------------------------------------------------\n");

            // Stretch Goal Prompts 
            System.out.println("Would you like to run Stretch Goal analyses? (Y/N)");
            String runStretch = scanner.nextLine().trim(); // Using nextLine() for clean buffer management

            switch (runStretch.toUpperCase()) {
                case "Y", "YES" -> {
                    System.out.println("\n--- Stretch Goals Analysis ---");
                    
                    int safeCount = maxSafePassengers(weightLimit, passengerWeights);
                    System.out.println("1. Max Safe Passengers: " + safeCount);

                    MinMaxWeights minMax = getMinMaxBoardedWeights(weightLimit, passengerWeights);
                    if (!passengerWeights.isEmpty()) {
                        System.out.printf("2. Heaviest Passenger: %.0f lbs | Lightest Passenger: %.0f lbs%n",
                                minMax.max(), minMax.min());
                    }

                    TripResult tripResult = calculateTrips(weightLimit, passengerWeights);
                    System.out.println("3. Total Trips Required: " + tripResult.totalTrips());
                    for (int i = 0; i < tripResult.trips().size(); i++) {
                        System.out.println("   - Trip " + (i + 1) + ": " + tripResult.trips().get(i));
                    }
                }
            }

            // Loop Prompt
            System.out.print("\nWould you like to run another Weight Limit Check? (Y/N): ");
            String runAgain = scanner.nextLine().trim();
            
            if (!runAgain.equalsIgnoreCase("Y") && !runAgain.equalsIgnoreCase("YES")) {
                keepChecking = false;
                System.out.println("Exiting...");
            } else {
                System.out.println("\n=========================================\n");
            }
        }

        scanner.close();
    }
}
