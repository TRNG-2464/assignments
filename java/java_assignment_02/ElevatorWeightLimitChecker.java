import java.util.Scanner;
import java.util.Arrays;

public class ElevatorWeightLimitChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();

        System.out.print("Enter weight limit: ");
        int weightLimit = sc.nextInt();

        System.out.println("Enter amount of passengers: ");
        int s = sc.nextInt();
        int[] passengerWeights = new int[s];

        System.out.print("Enter the passenger weights: ");
        for (int i = 0; i < s; i++) {
            if (sc.hasNextInt()) {
                passengerWeights[i] = sc.nextInt();
            }
        }

        System.out.println();
        System.out.print("Input: weightLimit = " + weightLimit + ", ");
        System.out.println("passengerWeights = " + Arrays.toString(passengerWeights));

        checkWeight(weightLimit, passengerWeights, weightLimit);
        
        sc.close();
        System.out.println();
    }

    public static void checkWeight(int w, int[] p, int wl) {
        int currentWeight = 0;
        boolean weightExceeded = false;

        for (int i = 0; i < p.length; i++) {
            currentWeight += p[i];
            if (currentWeight >= wl) {
                System.out.println("Passenger " + (i + 1) + 
                    " caused an overload! Total weight at that point: " 
                    + currentWeight + "lbs.");
                weightExceeded = true;
                break;
            }
        }

        if (currentWeight == 0) {
            // empty array
            System.out.println("No passengers boarded.");
            weightExceeded = true; // Just to not trigger the following if statement.
        }
        if (!weightExceeded) {
            System.out.println("All passengers boarded safely! Total weight: " + currentWeight + "lbs.");
        }
    }

}
