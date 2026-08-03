import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Elevator {

    public String loadElevator(double weightLimit, double[] passengerWeights) {
        double totalPassengerWeight = 0.0;

        for (int i = 0; i < passengerWeights.length; i++) {
            totalPassengerWeight += passengerWeights[i];

            // Meeting OR exceeding the limit counts as overload.
            if (totalPassengerWeight >= weightLimit) {
                return "Passenger " + (i + 1)
                        + " caused an overload. Total weight at that point: "
                        + totalPassengerWeight + " lbs.";
            }
        }

        return "All passengers boarded safely. Total weight: "
                + totalPassengerWeight + " lbs.";
    }

    // Stretch goal 1: maximum number of passengers that can fit.
    public int maxPassengers(double weightLimit, double[] passengerWeights) {
        double[] sortedWeights = Arrays.copyOf(passengerWeights, passengerWeights.length);
        Arrays.sort(sortedWeights);

        double totalPassengerWeight = 0.0;
        int passengerCount = 0;

        for (double passengerWeight : sortedWeights) {
            if (totalPassengerWeight + passengerWeight >= weightLimit) {
                break;
            }

            totalPassengerWeight += passengerWeight;
            passengerCount++;
        }

        return passengerCount;
    }

    // Stretch goal 2: report heaviest and lightest passengers considered.
    public String loadElevatorWithMinMaxPassengers(
            double weightLimit,
            double[] passengerWeights) {

        if (passengerWeights.length == 0) {
            return "There are no passengers. Total weight: 0.0 lbs.";
        }

        double totalPassengerWeight = 0.0;
        double minimumWeight = passengerWeights[0];
        double maximumWeight = passengerWeights[0];

        for (int i = 0; i < passengerWeights.length; i++) {
            double currentWeight = passengerWeights[i];
            totalPassengerWeight += currentWeight;

            if (currentWeight < minimumWeight) {
                minimumWeight = currentWeight;
            }

            if (currentWeight > maximumWeight) {
                maximumWeight = currentWeight;
            }

            if (totalPassengerWeight >= weightLimit) {
                return "Passenger " + (i + 1)
                        + " caused an overload. Total weight at that point: "
                        + totalPassengerWeight + " lbs."
                        + "\nHeaviest passenger: " + maximumWeight + " lbs."
                        + "\nLightest passenger: " + minimumWeight + " lbs.";
            }
        }

        return "All passengers boarded safely. Total weight: "
                + totalPassengerWeight + " lbs."
                + "\nHeaviest passenger: " + maximumWeight + " lbs."
                + "\nLightest passenger: " + minimumWeight + " lbs.";
    }

    // Stretch goal 3: consecutive trips; every trip must remain below the limit.
    public String loadElevatorWithMultipleTrips(
            double weightLimit,
            double[] passengerWeights) {

        if (passengerWeights.length == 0) {
            return "There are no passengers. No trips are required.";
        }

        for (int i = 0; i < passengerWeights.length; i++) {
            if (passengerWeights[i] >= weightLimit) {
                return "Passenger " + (i + 1) + " weighs "
                        + passengerWeights[i]
                        + " lbs. and cannot ride because each trip must remain below "
                        + weightLimit + " lbs.";
            }
        }

        List<List<Integer>> trips = new ArrayList<>();
        List<Integer> currentTrip = new ArrayList<>();
        double currentTripWeight = 0.0;

        for (int i = 0; i < passengerWeights.length; i++) {
            double passengerWeight = passengerWeights[i];

            if (currentTripWeight + passengerWeight >= weightLimit) {
                trips.add(currentTrip);
                currentTrip = new ArrayList<>();
                currentTripWeight = 0.0;
            }

            currentTrip.add(i + 1);
            currentTripWeight += passengerWeight;
        }

        if (!currentTrip.isEmpty()) {
            trips.add(currentTrip);
        }

        StringBuilder result = new StringBuilder(
                "All passengers were assigned safely. Trips required: "
                        + trips.size());

        for (int i = 0; i < trips.size(); i++) {
            result.append("\nTrip ").append(i + 1).append(": passengers ");

            List<Integer> trip = trips.get(i);
            for (int j = 0; j < trip.size(); j++) {
                if (j > 0) {
                    result.append(", ");
                }
                result.append(trip.get(j));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Elevator elevator = new Elevator();

        System.out.println("=== Base requirement ===");
        System.out.println(elevator.loadElevator(
                1000, new double[]{150, 200, 300, 250, 180}));
        System.out.println(elevator.loadElevator(
                1000, new double[]{150, 200, 300}));
        System.out.println(elevator.loadElevator(
                500, new double[]{200, 300}));
        System.out.println(elevator.loadElevator(
                100, new double[]{150, 200}));
        System.out.println(elevator.loadElevator(
                1000, new double[]{}));

        System.out.println("\n=== Maximum safe passenger count ===");
        System.out.println(elevator.maxPassengers(
                500, new double[]{200, 100, 150, 75}));

        System.out.println("\n=== Heaviest and lightest ===");
        System.out.println(elevator.loadElevatorWithMinMaxPassengers(
                500, new double[]{120, 180, 250, 90}));

        System.out.println("\n=== Multiple trips ===");
        System.out.println(elevator.loadElevatorWithMultipleTrips(
                500, new double[]{150, 200, 100, 250, 125}));
        System.out.println(elevator.loadElevatorWithMultipleTrips(
                500, new double[]{500, 100}));
    }
}
