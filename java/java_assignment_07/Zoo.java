//package java.java_assignment_07;
import java.util.Scanner;

public class Zoo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Bird");
            System.out.println("0. Exit");
            System.out.print("Enter your selection: ");

            String input = scanner.nextLine();

            try {
                int choice = Integer.parseInt(input);

                Animal animal = null;

                switch (choice) {
                    case 1:
                        animal = new Dog();
                        break;
                    case 2:
                        animal = new Cat();
                        break;
                    case 3:
                        animal = new Bird();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Exiting the program.");
                        continue;
                    default:
                        String errorMessage = "'" + choice + "' is not a valid selection. Please choose a number from the menu.";
                        System.out.println(errorMessage);
                        continue;
                }
                if (animal != null) {
                    animal.displayInfo();
                }

            } catch (NumberFormatException e) {
                    String errorMessage = "'" + input + "' is not a valid selection. Please choose a number from the menu.";
                    System.out.println(errorMessage);
            }
        }

        scanner.close();
    }
}
