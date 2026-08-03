public class asgn_02 {
    public static void main(String[] args) {
        int weightLimit = Integer.parseInt(args[0]);
        int[] passengerWeights = new int[args.length - 1];
        for (int i = 0; i < args.length-1; i++) {
            passengerWeights[i] = Integer.parseInt(args[i+1]);
        }
        System.out.println(checkWeightLimit(weightLimit, passengerWeights));
    }

    public static String checkWeightLimit(int weightLimit, int[] passengerWeights) {
        if (passengerWeights == null || passengerWeights.length == 0) {
            return "No passengers to board. Total weight: 0 lbs.";
        }

        int total = 0;
        for (int i = 0; i < passengerWeights.length; i++) {
            total +=passengerWeights[i];
            if (total >= weightLimit) {
                return String.format(
                    "Passenger %d caused an overload. Total weight at that point: %d lbs.",
                    i+1, total);
            }
        }
        return String.format("All passengers boarded safely. Total weight: %d lbs.", total);
    }
}
