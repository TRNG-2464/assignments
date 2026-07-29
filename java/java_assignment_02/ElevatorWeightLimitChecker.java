
public class ElevatorWeightLimitChecker {
    
    public void checkWeightLimit(int limit, int[] weights) {
        if (limit < 0) {
            System.out.println("Weight limit cannot be negative.");
            return;
        }

        if (weights.length == 0) {
            System.out.println("No passengers boarded.");
            return;
        }

        int total = 0;
        for (int i = 0; i < weights.length; i++) {
            total += weights[i];
            if (total >= limit) {
                System.out.printf("Passenger %d caused an overload. Total weight at that point: %d lbs.%n", i + 1, total);
                return;
            }
        }
        System.out.printf("All passengers boarded safely. Total weight: %d lbs.%n", total);
    }

    public void getMaximumSafePassengerCount(int limit, int[] weights)  {
        if (limit < 0) {
            System.out.println("Weight limit cannot be negative.");
            return;
        }

        if (weights.length == 0) {
            System.out.println("No passengers boarded.");
            return;
        }

        int total = 0;
        int i;
        for (i = 0; i < weights.length; i++) {
            total += weights[i];
            if (total >= limit) {
                break;
            }
        }
        System.out.printf("Max number of passengers: %d%n", i);
    }

    public void getHeaviestAndLightestPassengers(int limit, int[] weights) {
        if (limit < 0) {
            System.out.println("Weight limit cannot be negative.");
            return;
        }

        if (weights.length == 0) {
            System.out.println("No passengers boarded.");
            return;
        }

        int lowestWeight = Integer.MAX_VALUE;
        int highestWeight = Integer.MIN_VALUE;
        int total = 0;
        for (int i = 0; i < weights.length; i++) {
            total += weights[i];
            lowestWeight = Math.min(lowestWeight, weights[i]);
            highestWeight = Math.max(highestWeight, weights[i]);
            if (total >= limit) {
                System.out.printf("Passenger %d caused an overload. Total weight at that point: %d lbs.%n", i + 1, total);
                System.out.printf("Heaviest passenger weight: %s%n", highestWeight);
                System.out.printf("Lowest passenger weight: %s%n", lowestWeight);
                return;
            }
        }
        System.out.printf("All passengers boarded safely. Total weight: %d lbs.%n", total);
        System.out.printf("Heaviest passenger weight: %s%n", highestWeight);
        System.out.printf("Lowest passenger weight: %s%n", lowestWeight);
    }

    public void getNumberOfTrips(int limit, int[] weights) {
        if (limit < 0) {
            System.out.println("Weight limit cannot be negative.");
            return;
        }

        if (weights.length == 0) {
            System.out.println("No passengers boarded.");
            return;
        }

        int curr = 0;
        int trips = 0;
        for (int i = 0; i < weights.length; i++) {
            // curr > 0 means there must be passengers on ship
            if (curr + weights[i] >= limit && curr > 0) {
                trips += 1;
                // This single passenger exceeds limit, can't start new trip with them
                if (weights[i] >= limit) {
                    curr = 0;
                } else {
                    curr = weights[i];
                }
                continue;
            }
            curr += weights[i];
        }
        System.out.printf("Total trips: %d%n", trips + 1);
    }

}