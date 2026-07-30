import java.util.Scanner;
 
public class Zoo {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Animal[] animals = { new Dog(), new Cat(), new Bird() };
        boolean running = true;
 
        while (running) {
            displayMenu(animals);
            System.out.print("Enter your selection: ");
            String input = scanner.nextLine().trim();
 
            running = handleSelection(input, animals);
        }
 
        scanner.close();
    }
 
    private static void displayMenu(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            System.out.println((i + 1) + ". " + animals[i].getName());
        }
        System.out.println("0. Exit");
    }
 
    private static boolean handleSelection(String input, Animal[] animals) {
        int selection;
        try {
            selection = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("'" + input + "' is not a valid selection. Please choose a number from the menu.");
            return true;
        }
 
        if (selection == 0) {
            System.out.println("Goodbye! Thanks for visiting the zoo.");
            return false;
        }
 
        if (selection < 1 || selection > animals.length) {
            System.out.println("'" + selection + "' is not a valid selection. Please choose a number from the menu.");
            return true;
        }
 
        Animal chosen = animals[selection - 1];
        chosen.makeSound();
        chosen.describe();
        return true;
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
        System.out.println("Meow!");
    }
 
    @Override
    public void describe() {
        System.out.println("The cat stretches lazily and blinks at you slowly.");
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
