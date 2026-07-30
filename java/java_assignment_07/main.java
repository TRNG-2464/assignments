import java.util.*;

abstract class Animal {
    abstract String makeSound();
    abstract String describe();
}

class Dog extends Animal {
    String breed;

    Dog() {
        this.breed = "";
    }
    Dog(String breed) {
        this.breed = breed;
    }

    @Override
    String makeSound() {
        return "Woof! Woof!";
    }

    @Override
    String describe() {
        return "The " + (breed.isEmpty() ? "dog" : breed) + " wags its tail excitedly and looks up at you.";
    }
}

class Bird extends Animal {
    boolean canFly;

    Bird() {
        this.canFly = true;
    }

    Bird(boolean canFly) {
        this.canFly = canFly;
    }

    @Override
    String makeSound() {
        return "Tweet! Tweet!";
    }

    @Override
    String describe() {
        return "The" + (canFly ? "" : " flightless") + " bird tilts its head and hops along its perch.";
    }
}

class Cat extends Animal {
    @Override
    String makeSound() {
        return "meow..";
    }

    @Override
    String describe() {
        return "The cat whines for its hundreth snack of the day.";
    }
}

public class main {

    static void printAnimal(int c) {
        Animal animal = null;
        switch (c) {
        default:
            return;
        case 1:
            animal = new Dog();
            break;
        case 2:
            animal = new Cat();
            break;
        case 3:
            animal = new Bird();
            break;
        }

        System.out.println(animal.makeSound());
        System.out.println(animal.describe());
    }

    static void soundBoard() {
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.print(
            " 1. Dog\n" +
            "2. Cat\n" +
            "3. Bird\n" +
            "0. Exit\n" +
            "Enter your selection: ");

            String line = sc.nextLine();
            try {
                int choice = Integer.parseInt(line);
                if (choice == 0) {
                    System.out.println("Goodbye! Thanks for visiting the zoo.");
                    running = false;
                } else if (choice >= 1 && choice <= 3) {
                    printAnimal(choice);
                } else {
                    System.out.println(line + " is not a valid selection. Please choose a number from the menu.");
                }
            } catch (NumberFormatException e) {
                System.out.println(line + " is not a valid selection. Please choose a number from the menu.");
            }
        }

        sc.close();
    }

    static void printAnimalAttrib(int c) {
        Animal animal = null;
        switch (c) {
        default:
            return;
        case 1:
            animal = new Dog("German Shepherd");
            break;
        case 2:
            animal = new Cat();
            break;
        case 3:
            animal = new Bird(false);
            break;
        }

        System.out.println(animal.makeSound());
        System.out.println(animal.describe());
    }

    static void soundBoardAttrib() {
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.print(
                " 1. Dog\n" +
                "2. Cat\n" +
                "3. Bird\n" +
                "0. Exit\n" +
                "Enter your selection: ");

            String line = sc.nextLine();
            try {
                int choice = Integer.parseInt(line);
                if (choice == 0) {
                    System.out.println("Goodbye! Thanks for visiting the zoo.");
                    running = false;
                } else if (choice >= 1 && choice <= 3) {
                    printAnimalAttrib(choice);
                } else {
                    System.out.println(line + " is not a valid selection. Please choose a number from the menu.");
                }
            } catch (NumberFormatException e) {
                System.out.println(line + " is not a valid selection. Please choose a number from the menu.");
            }
        }
        sc.close();
    }

    static void soundBoardRandom() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        boolean running = true;

        while (running) {
            System.out.print(
            " 1. Dog\n" +
            "2. Cat\n" +
            "3. Bird\n" +
            "4. Surprise Me\n" +
            "0. Exit\n" +
            "Enter your selection: ");

            String line = sc.nextLine();
            try {
                int choice = Integer.parseInt(line);
                if (choice == 0) {
                    System.out.println("Goodbye! Thanks for visiting the zoo.");
                    running = false;
                } else if (choice >= 1 && choice <= 3) {
                    printAnimal(choice);
                } else if (choice == 4) {
                    int c = rand.nextInt(3) + 1;
                    printAnimal(c);
                } else {
                    System.out.println(line + " is not a valid selection. Please choose a number from the menu.");
                }
            } catch (NumberFormatException e) {
                System.out.println(line + " is not a valid selection. Please choose a number from the menu.");
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        soundBoard();
    }
}
