package Zoo;

import java.util.Random;
import java.util.Scanner;

public class ZooAnimalSoundBoard {

    public static void main(String[] args) {
        runBaseZooBoard();

        runStretchGoalZooBoard();
    }

    public static void runBaseZooBoard() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Zoo.Dog");
            System.out.println("2. Zoo.Cat");
            System.out.println("3. Zoo.Bird");
            System.out.println("0. Exit");
            System.out.print("Enter your selection: ");

            // Gracefully catch non-numeric input (e.g., text like "banana")
            if (!scanner.hasNextInt()) {
                String badInput = scanner.next(); // Clear the text from buffer
                System.out.println("'" + badInput + "' is not a valid selection. Please choose a number from the menu.");
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Goodbye! Thanks for visiting the zoo.");
                break;
            }

            Animal selectedAnimal = null;

            // Instantiate the correct subclass dynamically
            switch (choice) {
                case 1:
                    selectedAnimal = new Dog();
                    break;
                case 2:
                    selectedAnimal = new Cat();
                    break;
                case 3:
                    selectedAnimal = new Bird();
                    break;
                default:
                    // Gracefully handle out-of-range numbers
                    System.out.println("'" + choice + "' is not a valid selection. Please choose a number from the menu.");
                    continue;
            }

            // Polymorphic call execution
            selectedAnimal.makeSound();
            selectedAnimal.describe();
        }
        scanner.close();
    }
    public static void runStretchGoalZooBoard() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("\n1. Zoo.Dog (Advanced)");
            System.out.println("2. Zoo.Cat");
            System.out.println("3. Zoo.Bird (Advanced)");
            System.out.println("4. Surprise Me! (Random Choice)");
            System.out.println("0. Exit");
            System.out.print("Enter your selection: ");

            if (!scanner.hasNextInt()) {
                String badInput = scanner.next();
                System.out.println("'" + badInput + "' is not a valid selection. Please choose a number from the menu.");
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Goodbye! Thanks for visiting the advanced zoo.");
                break;
            }

            // If user selects 4, overwrite 'choice' variable with a random number between 1 and 3
            if (choice == 4) {
                System.out.println("[Surprise Me Activated!]");
                choice = random.nextInt(3) + 1; // Generates 1, 2, or 3
            }

            Animal selectedAnimal = null;

            switch (choice) {
                case 1:
                    selectedAnimal = new AdvancedDog("Golden Retriever");
                    break;
                case 2:
                    selectedAnimal = new Cat(); // Uses normal cat since it has no advanced attributes
                    break;
                case 3:
                    selectedAnimal = new AdvancedBird(false); // An advanced penguin or ostrich!
                    break;
                default:
                    System.out.println("'" + choice + "' is not a valid selection. Please choose a number from the menu.");
                    continue;
            }

            selectedAnimal.makeSound();
            selectedAnimal.describe();
        }
        scanner.close();
    }
}

