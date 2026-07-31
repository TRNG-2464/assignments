package exercise7;

import java.util.*;

public abstract class Animal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Make a Selection: \n 1. Bird \n 2. Horse \n 3. Pig \n 0. Exit");
            int cmd = sc.nextInt();
            if (cmd == 1) {
                Bird tweety = new Bird("bird", "multi-colored", "small", "tweet");
                tweety.describe();
                tweety.makeSound();
            } else if (cmd == 2) {
                Horse horse = new Horse("horse", "brown", "large", "neigh");
                horse.describe();
                horse.makeSound();
            } else if (cmd == 3) {
                Pig pig = new Pig("pig", "pink", "medium", "oink");
                pig.describe();
                pig.makeSound();
            } else if (cmd == 0) {
                return;
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

    String name;
    String color;
    String size;
    String noise;

    public Animal(String name, String color, String size, String noise) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.noise = noise;
    }

    public void describe() {
        System.out.println("This animal is a " + this.name + ". It's color is " + this.color + ", and it's size is " + this.size + ".");
    }
    public void makeSound() {
        System.out.println(this.noise + " " + this.noise + "!");
    }
}
