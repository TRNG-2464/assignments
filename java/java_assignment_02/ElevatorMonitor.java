public class ElevatorMonitor {

    public static String checkElevatorLoad(double weightLimit, double[] passengerWeights) {
        if (passengerWeights.length == 0) {
            return "No passengers boarded. Total weight: 0 lbs.";
        }

        double runningTotal = 0;

        for (int i = 0; i < passengerWeights.length; i++) {
            runningTotal += passengerWeights[i];

            if (runningTotal >= weightLimit) {
                int passengerNumber = i + 1;
                return String.format(
                    "Passenger %d caused an overload. Total weight at that point: %.0f lbs.",
                    passengerNumber, runningTotal
                );
            }
        }

        return String.format("All passengers boarded safely. Total weight: %.0f lbs.", runningTotal);
    }

    public static void main(String[] args) {
        System.out.println(checkElevatorLoad(1000, new double[]{150, 200, 300, 250, 180}));

        System.out.println(checkElevatorLoad(1000, new double[]{150, 200, 300}));

        System.out.println(checkElevatorLoad(500, new double[]{200, 300}));

        System.out.println(checkElevatorLoad(100, new double[]{150, 200}));

        System.out.println(checkElevatorLoad(1000, new double[]{}));
    }
}
