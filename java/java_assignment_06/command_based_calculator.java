import java.util.Scanner;

public class command_based_calculator {

	public static void main(String[] args) {
		command_based_calculator calculator = new command_based_calculator();
		calculator.calculator();
	}

	public void calculator() {

		boolean exit = false;
		int total = 0;
		Scanner sc = new Scanner(System.in);
		while (!exit) {
			System.out.println("Enter command: \n1. Add\n2. Subtract\n3. Reset\n4. Total\n5. Exit");
			String command = sc.nextLine();
			switch (command) {
				case "Add":
					System.out.print("Enter number to add: ");
					int addNum = sc.nextInt();
					total = add(total, addNum);
					System.out.println("Addition successful. Total: " + total);
					break;
				case "Subtract":
					System.out.print("Enter number to subtract: ");
					int subNum = sc.nextInt();
					total = subtract(total, subNum);
					System.out.println("Subtraction successful. Total: " + total);
					break;
				case "Reset":
					total = 0;
					System.out.println("Reset successful. Total: " + total);
					break;
				case "Total":
					System.out.println("Total: " + total);
					break;
				case "Exit":
					exit = true;
					System.out.println("Exiting calculator.");
					break;
			}
		}
		sc.close();
	}

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}
}
