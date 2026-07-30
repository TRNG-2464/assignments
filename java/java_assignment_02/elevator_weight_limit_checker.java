import java.util.Scanner;

public class elevator_weight_limit_checker {

	public static void main(String[] args) {

		// Open Scanner and take max weight of elevator
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the maximum weight limit of the elevator: ");
		double maxWeight = sc.nextDouble();

		// Get the number of passengers and their weights
		System.out.print("Please enter the number of passengers: ");
		int numPassengers = sc.nextInt();
		double[] passengerWeights = new double[numPassengers];
		System.out.println("Please enter the weights of the passengers: ");
		for(int i = 0; i < numPassengers; i++) {
			System.out.print("Passenger " + (i + 1) + ": ");
			passengerWeights[i] = sc.nextDouble();
		}

		// Create an instance of the elevator_weight_limit_checker 
		elevator_weight_limit_checker ec = new elevator_weight_limit_checker();
		System.out.println(ec.checkCurrentWeight(maxWeight, passengerWeights));

		sc.close();
	}

	public String checkCurrentWeight(double maxWeight, double[] passengerWeights) {

		double currentWeight = 0;
		// Check if there are passengers
		if (passengerWeights.length == 0) {
			return "No passengers to check.";
		}

		// Weight checking logic
		for(int i = 0; i < passengerWeights.length; i++) {
			currentWeight += passengerWeights[i];
			if(currentWeight >= maxWeight) {
				return "Weight limit met or exceeded at position " + (i+1) + " with current weight: " + currentWeight;
			}
		} return "All passengers have boarded safely, current weight: " + currentWeight;
	}
}
