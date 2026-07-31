import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

abstract class Animal{
    abstract void makeSound();
    abstract void describe();
}

class Dog extends Animal{
    @Override
    void makeSound(){
        System.out.println("woof!");
    }

    @Override
    void describe(){
        System.out.println("I'm a dog. I like snacks and my owners!");
    }
}

class Cat extends Animal{
    @Override
    void makeSound(){
        System.out.println("meow...");
    }

    @Override
    void describe(){
        System.out.println("I'm a cat. I like lazing around in the sun all day.");
    }
}

class Bird extends Animal{
    @Override
    void makeSound(){
        System.out.println("chirp!");
    }

    @Override
    void describe(){
        System.out.println("I'm a bird! I like crackers and singing.");
    }
}

// The below classes are for the Stretch Goals

class DogExt extends Dog{
    String breed = "Labrador";

    @Override
    void describe(){
        super.describe();
        System.out.println("I am a " + this.breed + " breed.");
    }
}

class CatExt extends Cat{
    int weight = 10;
    @Override
    void describe(){
        super.describe();
        System.out.println("I weigh " + this.weight + " pounds.");
    }

}

class BirdExt extends Bird{
    boolean canFly = true;

    @Override
    void describe(){
        super.describe();
        if (this.canFly){
            System.out.println("I can fly!");
        }
        else{
            System.out.println("Unfortunately I cannot fly...");
        }
    }
}

public class Solution{
    static Scanner sc = new Scanner(System.in);

    /**
     * Main Assignment Code.
     * Loops continuously until 0 (exit) is called, creating new objects and 
     */
    static void run(){
    while (true){
            System.out.println("");
            System.out.println("1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Bird");
            System.out.println("0. Exit");

            int val;
            try{
                val = Integer.parseInt(sc.nextLine());
                if (val < 0 || val > 3){
                    throw new Exception();
                }
            }
            catch (Exception e){
                System.out.println("Invalid input.");
                continue;
            }
            
            Animal animal;
            if (val == 1){
                animal =  new Dog();
            }
            else if (val == 2){
                animal = new Cat();
            }
            else if (val == 3){
                animal = new Bird();
            }
            else{
                System.out.println("Thank you for visiting the zoo.");
                return;
            }

            animal.makeSound();
            animal.describe();
        }
    }    

    /**
     * Strech Goals 1 AND 2.
     * It's not very hard to extend the functionality, we just add a new option, change the validation check accordingly, and assign a random number if val == 4.
     */
    static void runExt(){
        while (true){
            System.out.println("");
            System.out.println("1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Bird");
            System.out.println("4. Surprise me!");
            System.out.println("0. Exit");

            int val;
            try{
                val = Integer.parseInt(sc.nextLine());
                if (val < 0 || val > 4){
                    throw new Exception();
                }
            }
            catch (Exception e){
                System.out.println("Invalid input.");
                continue;
            }

            if (val == 4){
                val = ThreadLocalRandom.current().nextInt(1, 4);
            }
            Animal animal;
            if (val == 1){
                animal =  new Dog();
            }
            else if (val == 2){
                animal = new Cat();
            }
            else if (val == 3){
                animal = new Bird();
            }
            else{
                System.out.println("Thank you for visiting the zoo.");
                return;
            }
            animal.makeSound();
            animal.describe();
        }
    }
    public static void main(String[] args){
        run();
    }
}