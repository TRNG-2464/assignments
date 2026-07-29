package com.mycompany.app;

public class ElevatorWeightLimitChecker {

    public static void main(String[] args) {

        // Example 1 - Overload occurs
        System.out.println(elevatorWeightLimitChecker(1000, 150, 200, 300, 250, 180));
        // Expected:
        // Passenger 5 caused an overload. Total weight at that point: 1080 lbs

        // Example 2 - All passengers board safely
        System.out.println(elevatorWeightLimitChecker(1000, 150, 200, 300));
        // Expected:
        // All passengers boarded safely. Total weight: 650 lbs

        // Example 3 - Exact match counts as overload
        System.out.println(elevatorWeightLimitChecker(500, 200, 300));
        // Expected:
        // Passenger 2 caused an overload. Total weight at that point: 500 lbs

        // Example 4 - First passenger alone exceeds the limit
        System.out.println(elevatorWeightLimitChecker(100, 150, 200));
        // Expected:
        // Passenger 1 caused an overload. Total weight at that point: 150 lbs

        // Empty passenger list
        System.out.println(elevatorWeightLimitChecker(500));
        // Expected:
        // All passengers boarded safely. Total weight: 0 lbs

        // Single passenger under the limit
        System.out.println(elevatorWeightLimitChecker(200, 150));
        // Expected:
        // All passengers boarded safely. Total weight: 150 lbs

        // Single passenger exactly at the limit
        System.out.println(elevatorWeightLimitChecker(150, 150));
        // Expected:
        // Passenger 1 caused an overload. Total weight at that point: 150 lbs

        // Overload in the middle
        System.out.println(elevatorWeightLimitChecker(700, 150, 200, 250, 100));
        // Expected:
        // Passenger 4 caused an overload. Total weight at that point: 700 lbs

        // No overload with many passengers
        System.out.println(elevatorWeightLimitChecker(1000, 100, 150, 175, 125, 200));
        // Expected:
        // All passengers boarded safely. Total weight: 750 lbs
    }

    public static String elevatorWeightLimitChecker(int weightLimit, int... passengers) {
        int total = 0;
        for (int i = 0; i < passengers.length; i++) {
            total += passengers[i];
            if (total >= weightLimit) {
                return String.format("Passenger %d caused an overload. Total weight at that point: %d lbs",
                        i + 1,
                        total
                );
            }
        }
        return String.format("All passengers boarded safely. Total weight: %d lbs", total);

    }
}
