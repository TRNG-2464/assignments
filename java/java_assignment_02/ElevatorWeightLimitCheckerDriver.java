public class ElevatorWeightLimitCheckerDriver {
    public static void main(String[] args) {
        ElevatorWeightLimitChecker e = new ElevatorWeightLimitChecker();
        int[] passengerWeights1 = {150, 200, 300, 250, 180};
        e.checkWeightLimit(1000, passengerWeights1);

        int[] passengerWeights2 = {150, 200, 300};
        e.checkWeightLimit(1000, passengerWeights2);

        int[] passengerWeights3 = {200, 300};
        e.checkWeightLimit(500, passengerWeights3);

        int[] passengerWeights4 = {150, 200};
        e.checkWeightLimit(100, passengerWeights4);

        int[] passengerWeights5 = {100, 100, 100};
        e.getMaximumSafePassengerCount(150, passengerWeights5);

        
        int[] passengerWeights6 = {100, 100, 100};
        e.getMaximumSafePassengerCount(500, passengerWeights6);

        int[] passengerWeights7 = {100, 200, 300, 400};
        e.getHeaviestAndLightestPassengers(600, passengerWeights7);

        int[] passengerWeights8 = {50, 100, 50, 300, 50, 50};
        e.getNumberOfTrips(200, passengerWeights8);

    }
}
