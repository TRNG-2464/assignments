import java.util.Scanner;

public class traffic_light_simulator {

	public static void main(String[] args) {

		traffic_light_simulator sim = new traffic_light_simulator();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the current color of the traffic light (Green/Yellow/Red): ");
		String color = sc.nextLine();

		System.out.print("Enter the number of ticks that will pass: ");
		int ticks = sc.nextInt();

		if (ticks == 0) {
			System.out.println("The traffic light remains " + color + ".");
			sc.close();
		} else if(ticks < 0) {
			System.out.println("The number of ticks cannot be negative.");
			sc.close();
		} else if (!color.equals("Green") && !color.equals("Yellow") && !color.equals("Red")) {
			System.out.println("Invalid color input. Please enter Green, Yellow, or Red.");
			sc.close();
		} else {
			String newColor = sim.trafficLight(color, ticks);
			System.out.println("The new color of the traffic light after " + ticks + " ticks is: " + newColor);
			sc.close();
		}
	}

	public String trafficLight(String color, int ticks) {

		int newColor = ticks;
		if (color.equals("Green")) {
			newColor += 1;
		} else if (color.equals("Yellow")) {
			newColor += 2;
		} else if (color.equals("Red")) {
			newColor += 3;
		}

		switch (newColor%3) {
			case 1:
				return "Green";
			case 2:
				return "Yellow";
			case 0:
				return "Red";
			default:
				return "Invalid color";
		}
	}
}
