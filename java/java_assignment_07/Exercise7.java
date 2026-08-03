import java.util.Scanner;

public class Exercise7 {

    // Shows the menu
    public static void showMenu() {
        System.out.println();
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Bird");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            showMenu();
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
                        System.out.println("Goodbye! Thanks for visiting the zoo.");
                        running = false;
                        break;
                    default:
                        System.out.println("'" + choice + "' is not a valid selection. Please choose a number from the menu.");
                }

                if (animal != null) {
                    animal.makeSound();
                    animal.describe();
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        scanner.close();
    }
}
