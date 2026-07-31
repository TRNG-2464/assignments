import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Elevator{
    public String loadElevator(double weightLimit, double[] passengerWeights){
        double totalPassengerWeight = 0.00;

        for (int i = 0; i < passengerWeights.length; i++){
            totalPassengerWeight += passengerWeights[i];
            if (totalPassengerWeight > weightLimit){
                return "Passenger " + (i+1) + " cause and overload. Total weight at that point: " + totalPassengerWeight;
            }
        }

        return "All Passengers loaded safely. Total weight: " + totalPassengerWeight;
    }

    // Stretch goals
    public int maxPassengers(double weightLimit, double[] passengerWeights){
        double totalPassengerWeight = 0.00;
        Arrays.sort(passengerWeights);

        for (int i = 0; i < passengerWeights.length; i++){
            totalPassengerWeight += passengerWeights[i];
            if (totalPassengerWeight > weightLimit){
                return i;
            }
        }
        return passengerWeights.length - 1;
    }

    // Stretch goal 2
    public String loadElevatorWithMinMaxPassengers(double weightLimit, double[] passengerWeights){
        double totalPassengerWeight = 0.00;
        if (passengerWeights.length == 0){
            return "There are no passengers";
        }
        double minimumWeight = passengerWeights[0];
        double maximumWeight = passengerWeights[0];
        for (int i = 0; i < passengerWeights.length; i++){
            totalPassengerWeight += passengerWeights[i];

            if (minimumWeight > passengerWeights[i]){
                minimumWeight = passengerWeights[i];
            }

            if (maximumWeight < passengerWeights[i]){
                maximumWeight = passengerWeights[i];
            }

            if (totalPassengerWeight > weightLimit){
                return "Passenger " + (i+1) + " cause and overload. Total weight at that point: " + totalPassengerWeight + 
                "\nThe heaviest passenger weight: " + maximumWeight + " The lightest passenger weight: " + minimumWeight;
            }
        }

        return "All Passengers loaded safely. Total weight: " + totalPassengerWeight + 
                "\nThe heaviest passenger weight: " + maximumWeight + " The lightest passenger weight: " + minimumWeight;
    }

    // Stretch goal 3. Because there are some instances that a single passenger may outweight the elevator, there's a fail condition that way.
    public String loadElevatorWithMultipleTrips(double weightLimit, double[] passengerWeights){
        double totalPassengerWeight = 0.00;
        List<Integer> elevatorTrips = new ArrayList<>();

        /* I'm actually checking if a single passenger outweights any other passenger. If one does, I have to set a fail condition early.
        I could technically do this through the first for loop, but calculating each max weights then creating new lists seem like
        such a heavy operation than checking beforehand
        */ 

        for (double passengerWeight: passengerWeights){
            if (passengerWeight > weightLimit) {
                return "Could not successfully load all passengers because 1 passenger is too heavy.";
            }
        }


        for (int i = 0; i < passengerWeights.length; i++){
            
            totalPassengerWeight += passengerWeights[i];
            
            if (totalPassengerWeight > weightLimit){
                totalPassengerWeight = passengerWeights[i];
                elevatorTrips.add(i+1);
            }

        }

        String result = "All Passengers loaded safely. It took " + elevatorTrips.size() + " trips \nFor each trip:";
        
        for (int i = 0; i < elevatorTrips.size(); i++){
            result += "\n Trip " + (i+1) + " included ";
            if (elevatorTrips.get(i) == 0){
                result += "\nPassenger 1";
            } else if (elevatorTrips.get(i) - elevatorTrips.get(i-1) == 1 ){
                result += "\nPassenger" + elevatorTrips.get(i) + 1;
            } else {
                result += "\nPassengers" + (elevatorTrips.get(i-1) + 1) + "-" +(elevatorTrips.get(i) + 1);
            }
        }
        
        return result;

    }


}