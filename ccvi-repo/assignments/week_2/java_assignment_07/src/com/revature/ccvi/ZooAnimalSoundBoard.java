package com.revature.ccvi;

import java.util.Scanner;
import java.util.Random;

// Restricts which classes are allowed to extend Animal, enabling exhaustive pattern matching later.
abstract sealed class Animal permits Dog, Cat, Bird {
    abstract String makeSound();
    abstract String describe();
}

final class Dog extends Animal {
    private final String breed;
    
    public Dog(String breed) {
        this.breed = breed;
    }
    
    public String getBreed() {
        return breed;
    }
    
    @Override
    String makeSound() {
        return "Woof! Woof!";
    }
    
    @Override
    String describe() {
        return "The " + breed + " wags its tail excitedly and looks up at you.";
    }
}

final class Cat extends Animal {
    private final boolean isIndoor;
    
    public Cat(boolean isIndoor) {
        this.isIndoor = isIndoor;
    }
    
    public boolean isIndoor() {
        return isIndoor;
    }
    
    @Override
    String makeSound() {
        return "Meow! Meow!";
    }
    
    @Override
    String describe() {
        String habitat = isIndoor ? "indoor" : "outdoor";
        return "The " + habitat + " cat purrs and rubs against your leg.";
    }
}

final class Bird extends Animal {
    private final boolean canFly;
    
    public Bird(boolean canFly) {
        this.canFly = canFly;
    }
    
    public boolean canFly() {
        return canFly;
    }
    
    @Override
    String makeSound() {
        return "Tweet! Tweet!";
    }
    
    @Override
    String describe() {
        String action = canFly ? "takes flight and soars above" : "hops along its perch";
        return "The bird tilts its head, then " + action + ".";
    }
}

public class ZooAnimalSoundBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean keepRunning = true;
        
        while (keepRunning) {
            System.out.println("1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Bird");
            System.out.println("4. Surprise Me!");
            System.out.println("0. Exit");
            System.out.print("Enter your selection: ");
            
            String input = scanner.nextLine().trim();
            
            if (input.equals("4")) {
                int randomSelection = random.nextInt(3) + 1;
                input = String.valueOf(randomSelection);
                System.out.println("Surprise! You got animal option #" + input + "...\n");
            }
            
            if (input.equals("0")) {
                System.out.println("Goodbye! Thanks for visiting the zoo.");
                keepRunning = false;
                continue;
            }
            
            // Evaluates to a single value that we can immediately assign to a variable.
            Animal selectedAnimal = switch (input) {
                case "1" -> new Dog("Golden Retriever");
                case "2" -> new Cat(true);
                case "3" -> new Bird(false);
                default -> null;
            };
            
            if (selectedAnimal != null) {
                // Calling overridden methods
                System.out.println(selectedAnimal.makeSound());
                System.out.println(selectedAnimal.describe());
                
                // Because Animal is 'sealed', the compiler knows this switch is exhaustive.
                String extraContext = switch (selectedAnimal) {
                    case Dog d -> "[Additional DB Info: Breed is " + d.getBreed() + "]";
                    case Cat c -> "[Additional DB Info: Indoor status is " + c.isIndoor() + "]";
                    case Bird b -> "[Additional DB Info: Flight capability is " + b.canFly() + "]";
                };
                System.out.println(extraContext);
                System.out.println();
                
            } else {
                System.out.println("'" + input + "' is not a valid selection. Please choose a number from the menu.\n");
            }
        }
        scanner.close();
    }
}
