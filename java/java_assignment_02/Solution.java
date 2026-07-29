import java.util.Arrays;

public class Solution{
    /**
     * main assignment method. Loops through the weight values adding to a total weight variable, stops and prints as soon as the limit is reached.
     * @param limit the overflow weight of the elevator - anything lower is safe
     * @param weights the array of passenger weights
     */
    static void checkElevator(int limit, int[] weights){
        if (weights.length == 0){
            System.out.println("No passengers in elevator.");
            return;
        }
        
        int runningWeight = 0, passNum = 1; // passnum is the current passenger being processed
        for (int weight: weights){
            runningWeight += weight;
            if (runningWeight >= limit){
                // note we do the check before incrementing passNum
                System.out.println("Passenger " + passNum + " caused overflow: total weight " + runningWeight);
                return;
            }
            passNum++;
        }

        System.out.println("All passengers boarded safely: total weight " + runningWeight);

    }

    /**
     * Stretch Goal 1: we sort the array and greedily select the lightest possible passenger to add to the elevator.
     * @param limit the overflow weight of the elevator
     * @param weights the array of passenger weights
     */

    static void findMaxPassengers(int limit, int[] weights){
        if (weights.length == 0){
            System.out.println("No passengers in elevator.");
            return;
        }
        Arrays.sort(weights);
        int runningWeight = 0, count = 0;

        for (int weight: weights){
            runningWeight += weight;
            if (runningWeight >= limit){
                runningWeight -= weight;
                break;
            }
            count++;
        }

        System.out.println("Max passengers: " + count + ", total weight: " + runningWeight);
    }

    /**
     * Stretch Goal 2: Like our main assignment, but we also keep track of the heaviest and lightest weights using two variables
     * @param limit the overflow weight of the elevator
     * @param weights the array of passenger weights
     */
    static void checkElevatorAndReport(int limit, int[] weights){
        if (weights.length == 0){
            System.out.println("No passengers in elevator.");
            return;
        }
        
        int runningWeight = 0, passNum = 1;
        int lightest = 10000000, heaviest = 0; // store the lightest and heaviest values (hopefully nothing has negative or stellar weight)

        for (int weight: weights){
            runningWeight += weight;
            if (weight < lightest){lightest = weight;} // update max/min if needed
            if (weight > heaviest){heaviest = weight;}
            if (runningWeight >= limit){
                System.out.println("Passenger " + passNum + " caused overflow: total weight " + runningWeight);
                System.out.println("Heaviest weight: " + heaviest + ", lightest weight: " + lightest);
                return;
            }
            passNum++;
        }

        System.out.println("All passengers boarded safely: total weight " + runningWeight);
        System.out.println("Heaviest weight: " + heaviest + ", lightest weight: " + lightest);
    }

    /**
     * Stretch Goal 3: Calculate the number of consecutive trips it will take to transport all passengers in order
     * @param limit the overflow weight of the elevator
     * @param weights the array of passenger weights
     */
    static void calcTrips(int limit, int[] weights){
        if (weights.length == 0){
            System.out.println("No passengers in elevator.");
            return;
        }
        int runningWeight = 0, tripNum = 1, firstIdx = 0; // have counters for the running weight on an elevator, the trip number, as well as the index of the first passenger in the elevator.

        for (int i = 0; i < weights.length; i++){

            int weight = weights[i];
            runningWeight += weight;

            if (weight >= limit){
                // if the individual's weight is greater than the elevator's limit on its own, we can't transport all passengers.
                // I think it's best to print an error message and return in that scenario.
                System.out.println("Sorry, passenger " + (i + 1) + " overflows the limit by themselves. All passengers cannot be processed.");
                return;
            }

            if (runningWeight >= limit){
                    System.out.println("Trip " + tripNum + ": Passengers " + (firstIdx + 1) + " - " + i);
                    tripNum++;
                    firstIdx = i;
                    // set running weight to be the weight of the first passenger in the new batch
                    runningWeight = weight;
            }
        }
        // final pring statement for the last elevator
        System.out.println("Trip " + tripNum + ": Passengers " + (firstIdx + 1) + " - " + weights.length);
        System.out.println("Total trips: " + tripNum);

    }

    public static void main(String[] args){
        checkElevator(100, new int[]{1, 5, 6, 63, 6039}); // Output: Passenger 5 caused overflow: total weight 6114
        checkElevator(100, new int[]{100}); // Output: Passenger 1 caused overflow: total weight 100
        checkElevator(100, new int[]{}); // Output: No passengers in elevator.
        checkElevator(100, new int[]{10, 20, 30, 10}); // Output: All passengers boarded safely: total weight 70
    }
}