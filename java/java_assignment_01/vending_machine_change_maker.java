import java.util.Scanner;

public class vending_machine_change_maker {


	public static void main(String[] args) {

		// Opens scanner to receive user input 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the amount of money inserted: $");
		double wallet = sc.nextDouble();
		System.out.print("Enter the price of the item: $");
		double price = sc.nextDouble();

		// Create class instance to reference non-static method makeChange in main
		vending_machine_change_maker vm = new vending_machine_change_maker();
		System.out.println(vm.makeChange(wallet, price));

		// Cleanup
		sc.close();
	}

	public String makeChange(double wallet, double price) {

		if (wallet < 0 || price < 0) {
			return "Invalid input: wallet and price must be non-negative.";
		} else if (wallet < price) {
			return "Insufficient funds provided: $" + (price - wallet) + " more is needed for purchase.";
		} return "Thank you for your purchase! Your change is: $" + (wallet - price);
	}
}


