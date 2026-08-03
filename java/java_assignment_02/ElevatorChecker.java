public class ElevatorChecker {

    // Checks if the elevator becomes overloaded
    public static String checkElevatorWeight(int weightLimit, int[] passengerWeights) {

        int total = 0;

        if (passengerWeights.length == 0) {
            return "No passengers boarded.";
        }

        for (int i = 0; i < passengerWeights.length; i++) {
            total += passengerWeights[i];

            if (total >= weightLimit) {
                return "Passenger " + (i + 1)
                        + " caused an overload. Total weight: "
                        + total + " lbs.";
            }
        }

        return "All passengers boarded safely. Total weight: "
                + total + " lbs.";
    }

    // Stretch Goal 1
    public static String maximumSafePassengerCount(int weightLimit, int[] passengerWeights) {

        int total = 0;
        int count = 0;

        for (int i = 0; i < passengerWeights.length; i++) {

            if (total + passengerWeights[i] >= weightLimit) {
                break;
            }

            total += passengerWeights[i];
            count++;
        }

        return "Maximum safe passengers: " + count
                + ". Total weight: " + total + " lbs.";
    }

    // Stretch Goal 2
    public static String heaviestAndLightest(int weightLimit, int[] passengerWeights) {

        if (passengerWeights.length == 0) {
            return "No passengers.";
        }

        int total = 0;
        int heaviest = passengerWeights[0];
        int lightest = passengerWeights[0];

        for (int i = 0; i < passengerWeights.length; i++) {

            total += passengerWeights[i];

            if (passengerWeights[i] > heaviest) {
                heaviest = passengerWeights[i];
            }

            if (passengerWeights[i] < lightest) {
                lightest = passengerWeights[i];
            }

            if (total >= weightLimit) {
                break;
            }
        }

        return "Heaviest passenger: " + heaviest
                + " lbs, Lightest passenger: "
                + lightest + " lbs.";
    }

    // Stretch Goal 3
    public static void multipleElevatorTrips(int weightLimit, int[] passengerWeights) {

        int total = 0;
        int trip = 1;

        if (passengerWeights.length == 0) {
            System.out.println("No passengers.");
            return;
        }

        System.out.println("Trip " + trip + ":");

        for (int i = 0; i < passengerWeights.length; i++) {

            if (total + passengerWeights[i] >= weightLimit) {
                trip++;
                total = 0;
                System.out.println();
                System.out.println("Trip " + trip + ":");
            }

            total += passengerWeights[i];

            System.out.println("Passenger " + (i + 1)
                    + " - " + passengerWeights[i] + " lbs");
        }

        System.out.println();
        System.out.println("Total trips: " + trip);
    }

    public static void main(String[] args) {

        int[] passengers1 = {150, 200, 300, 250, 180};
        int[] passengers2 = {150, 200, 300};
        int[] passengers3 = {200, 300};
        int[] passengers4 = {150, 200};
        int[] passengers5 = {};
        int[] passengers6 = {150, 200, 300, 250, 180, 350};

        System.out.println(checkElevatorWeight(1000, passengers1));
        System.out.println(checkElevatorWeight(1000, passengers2));
        System.out.println(checkElevatorWeight(500, passengers3));
        System.out.println(checkElevatorWeight(100, passengers4));
        System.out.println(checkElevatorWeight(1000, passengers5));

        System.out.println();

        System.out.println(maximumSafePassengerCount(1000, passengers6));

        System.out.println(heaviestAndLightest(1000, passengers6));

        System.out.println();

        multipleElevatorTrips(700, passengers6);
    }
}