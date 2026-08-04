import java.util.Scanner;

public class ElevatorWeightLimitChecker {

    // Base assignment method
    public static String checkElevatorWeight(
            int weightLimit,
            int[] passengerWeights
    ) {

        // Handle an empty array safely
        if (passengerWeights == null || passengerWeights.length == 0) {
            return "No passengers boarded. Total weight: 0 lbs.";
        }

        int totalWeight = 0;

        // Process passengers one at a time
        for (int i = 0; i < passengerWeights.length; i++) {

            // Add the current passenger's weight
            totalWeight += passengerWeights[i];

            // Meet OR exceed the limit = overload
            if (totalWeight >= weightLimit) {
                return "Passenger " + (i + 1)
                        + " caused an overload. "
                        + "Total weight at that point: "
                        + totalWeight + " lbs.";
            }
        }

        // This only runs if every passenger boarded safely
        return "All passengers boarded safely. "
                + "Total weight: " + totalWeight + " lbs.";
    }

// Stretch Goal 1:
// Find the maximum number of passengers who can board
// without the total meeting or exceeding the weight limit
public static String findMaximumSafePassengerCount(
        int weightLimit,
        int[] passengerWeights
) {

    int totalWeight = 0;
    int safePassengerCount = 0;

    // Check each passenger in order
    for (int i = 0; i < passengerWeights.length; i++) {

        // Check what the total would be if this passenger boarded
        if (totalWeight + passengerWeights[i] >= weightLimit) {

            return "Maximum safe passenger count: "
                    + safePassengerCount
                    + ". Total safe weight: "
                    + totalWeight
                    + " lbs.";
        }

        // Add the passenger only if the limit is not met or exceeded
        totalWeight += passengerWeights[i];
        safePassengerCount++;
    }

    // All passengers were able to board safely
    return "Maximum safe passenger count: "
            + safePassengerCount
            + ". Total safe weight: "
            + totalWeight
            + " lbs.";
}

// Stretch Goal 2:
// Find the heaviest and lightest passengers considered
public static String findHeaviestAndLightest(
        int weightLimit,
        int[] passengerWeights
) {

    // Handle an empty array
    if (passengerWeights == null
            || passengerWeights.length == 0) {

        return "No passengers were provided.";
    }

    int totalWeight = 0;

    // Start both values with the first passenger's weight
    int heaviest = passengerWeights[0];
    int lightest = passengerWeights[0];

    // Check passengers one at a time
    for (int i = 0; i < passengerWeights.length; i++) {

        // Add the passenger to the running total
        totalWeight += passengerWeights[i];

        // Check for a new heaviest passenger
        if (passengerWeights[i] > heaviest) {
            heaviest = passengerWeights[i];
        }

        // Check for a new lightest passenger
        if (passengerWeights[i] < lightest) {
            lightest = passengerWeights[i];
        }

        // Stop after including the passenger
        // who caused the overload
        if (totalWeight >= weightLimit) {

            return "Passenger " + (i + 1)
                    + " caused an overload. "
                    + "Total weight: "
                    + totalWeight
                    + " lbs. "
                    + "Heaviest passenger: "
                    + heaviest
                    + " lbs. "
                    + "Lightest passenger: "
                    + lightest
                    + " lbs.";
        }
    }

    // This runs if every passenger boarded safely
    return "All passengers boarded safely. "
            + "Total weight: "
            + totalWeight
            + " lbs. "
            + "Heaviest passenger: "
            + heaviest
            + " lbs. "
            + "Lightest passenger: "
            + lightest
            + " lbs.";
}

    // Manual testing using Scanner
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the elevator weight limit: ");
        int weightLimit = scanner.nextInt();

        System.out.print("Enter the number of passengers: ");
        int numberOfPassengers = scanner.nextInt();

        int[] passengerWeights = new int[numberOfPassengers];

        // Get each passenger's weight
        for (int i = 0; i < passengerWeights.length; i++) {
            System.out.print(
                    "Enter the weight of Passenger "
                            + (i + 1) + ": "
            );

            passengerWeights[i] = scanner.nextInt();
        }

        // Call the method and display the result
        System.out.println(checkElevatorWeight(weightLimit,passengerWeights));
        System.out.println(findMaximumSafePassengerCount(weightLimit,passengerWeights));
        System.out.println(findHeaviestAndLightest(weightLimit,passengerWeights));

        scanner.close();
    }
}