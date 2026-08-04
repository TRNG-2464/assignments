import java.util.Scanner;

// Abstract base class
abstract class Animal {

    // Each animal must provide its own sound
    public abstract String makeSound();

    // Each animal must provide its own description
    public abstract String describe();

    // Shared method used by every animal
    public void displayAnimalInfo() {
        System.out.println(makeSound());
        System.out.println(describe());
    }
}


// Dog subclass
class Dog extends Animal {
    
    public String makeSound() {
        return "Woof! Woof!";
    }

    @Override
    public String describe() {
        return "The dog wags its tail excitedly and looks up at you.";
    }
}


// Cat subclass
class Cat extends Animal {

    @Override
    public String makeSound() {
        return "Meow! Meow!";
    }

    @Override
    public String describe() {
        return "The cat stretches lazily and curls up in a warm spot.";
    }
}


// Bird subclass
class Bird extends Animal {

    @Override
    public String makeSound() {
        return "Tweet! Tweet!";
    }

    @Override
    public String describe() {
        return "The bird tilts its head and hops along its perch.";
    }
}


// Main program class
public class AnimalMenu {

    // Displays the menu
    public static void displayMenu() {

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

            // Show the menu
            displayMenu();

            System.out.print("Enter your selection: ");

            // Read the entire line so non-numeric input
            // can be handled without crashing
            String input = scanner.nextLine();

            try {

                // Convert the user's input into an integer
                int selection = Integer.parseInt(input);

                // Store the selected animal
                Animal selectedAnimal = null;

                switch (selection) {

                    case 1:
                        selectedAnimal = new Dog();
                        break;

                    case 2:
                        selectedAnimal = new Cat();
                        break;

                    case 3:
                        selectedAnimal = new Bird();
                        break;

                    case 0:
                        System.out.println(
                                "Goodbye! Thanks for visiting the zoo."
                        );

                        running = false;
                        break;

                    default:
                        System.out.println(
                                "'" + selection
                                        + "' is not a valid selection. "
                                        + "Please choose a number "
                                        + "from the menu."
                        );
                }

                // If an animal was selected,
                // display its sound and description
                if (selectedAnimal != null) {

                    System.out.println();

                    selectedAnimal.displayAnimalInfo();
                }

            } catch (NumberFormatException exception) {

                // Handle non-numeric input
                System.out.println(
                        "'" + input
                                + "' is not a valid selection. "
                                + "Please enter a number "
                                + "from the menu."
                );
            }
        }

        scanner.close();
    }
}