import java.util.Arrays;

public class main {

    static void weightCheck(double limit, double[] weights) {
        double total = 0.0;
        for (int i = 0; i < weights.length; i++) {
            total += weights[i];

            if (total >= limit) {
                System.out.println("Passenger " + (i + 1) + " caused an overload. Total weight: " + total);
                break;
            }
        }

        if (weights.length == 0) {
            System.out.println("No passengers entered elevator.");
        } else if (total < limit) {
            System.out.println("All passengers boarded safely. Total weight: " + total);
        }
    }

    static void maxSafeCount(double limit, double[] weights) {
        Arrays.sort(weights);
        int count = 0;
        double total = 0.0;
        for (int i = 0; i < weights.length; i++) {
            if (total + weights[i] >= limit) {
                break;
            }
            count += 1;
            total += weights[i];
        }
        System.out.println("Maximum number of safe passengers: " + count);
    }

    static void heavyLight(double limit, double[] weights) {
        double total = 0.0;
        int light = 0;
        int heavy = 0;
        for (int i = 0; i < weights.length; i++) {
            total += weights[i];

            if (weights[i] > weights[heavy]) {
                heavy = i;
            }
            if (weights[i] < weights[light]) {
                light = i;
            }

            if (total >= limit) {
                System.out.println("Passenger " + (i + 1) + " caused an overload. Total weight: " + total);
                break;
            }
        }

        if (total < limit) {
            System.out.println("All passengers boarded safely. Total weight: " + total);
        }

        System.out.println("Lighest: passenger " + (light + 1) + " weighs " + weights[light]);
        System.out.println("Heaviest: passenger " + (heavy + 1) + " weighs " + weights[heavy]);
    }

    static void elevatorTrips(double limit, double[] weights) {
        int tripCount = 0;
        int[] tripLengths = new int[weights.length + 1];
        int tripStart = 0;
        double runningTotal = 0.0;

        for (int i = 0; i < weights.length; i++) {
            if (i == weights.length - 1) {
                tripLengths[tripCount] = i - tripStart + 1; // includes the last passenger
                tripCount += 1;
            }

            if (runningTotal + weights[i] >= limit) {
                tripLengths[tripCount] = i - tripStart;
                tripStart = i;
                runningTotal = 0;
                tripCount += 1;
            }
            runningTotal += weights[i];
        }

        System.out.println("Trips required: " + tripCount);

        int passenger = 1;
        for (int i = 0; i < tripCount; i++) {
            int tripLength = tripLengths[i];
            if (tripLength == 1) {
                System.out.println("Trip " + (i+1) + ": passenger " + passenger);
            } else {
                System.out.println("Trip " + (i+1) + ": passenger " + passenger + " to passenger " + (passenger + tripLength - 1));
            }
            passenger += tripLengths[i];
        }
    }

    public static void main(String[] args) {
        // weightCheck(1000, new double[]{100, 200});
        // maxSafeCount(100, new double[]{100, 20, 30, 30, 10});
        // heavyLight(400, new double[]{70, 50, 100, 30, 200});
        // elevatorTrips(400.0, new double[]{100, 200, 200, 200, 100});
        // elevatorTrips(400.0, new double[]{100});
    }
}
