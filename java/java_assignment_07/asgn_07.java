import java.util.Scanner;

public class asgn_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Enter your selection: ");
            String input = scanner.nextLine();

            if (!isValidInt(input)) {
                System.out.println("'" + input + "' is not a valid selection. Please choose a number from the menu.");
                System.out.println();
                continue;
            }

            int choice = Integer.parseInt(input);
            switch (choice) {
                case 0:
                    System.out.println("Goodbye! Thanks for visiting the zoo.");
                    running = false;
                    break;
                case 1:
                    presentAnimal(new Dog());
                    break;
                case 2:
                    presentAnimal(new Cat());
                    break;
                case 3:
                    presentAnimal(new Bird());
                    break;
                default:
                    System.out.println("'" + choice + "' is not a valid selection. Please choose a number from the menu.");
                    System.out.println();
                    break;
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Bird");
        System.out.println("0. Exit");
    }

    private static void presentAnimal(Animal animal) {
        animal.makeSound();
        animal.describe();
        System.out.println();
    }

    private static boolean isValidInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

abstract class Animal {
    private final String name;

    protected Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void makeSound();

    public abstract void describe();
}

class Dog extends Animal {
    public Dog() {
        super("Dog");
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    @Override
    public void describe() {
        System.out.println("The dog wags its tail excitedly and looks up at you.");
    }
}

class Cat extends Animal {
    public Cat() {
        super("Cat");
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public void describe() {
        System.out.println("The cat stretches lazily and blinks slowly at you.");
    }
}

class Bird extends Animal {
    public Bird() {
        super("Bird");
    }

    @Override
    public void makeSound() {
        System.out.println("Tweet! Tweet!");
    }

    @Override
    public void describe() {
        System.out.println("The bird tilts its head and hops along its perch.");
    }
}
