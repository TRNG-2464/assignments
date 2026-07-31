import java.util.Random;
import java.util.Scanner;

public class ZooAnimalSoundBoard {
    public void start() {
        String command = "";
        Animal animal = null;
        Scanner s = new Scanner(System.in);
        while (!command.equals("0")) {
            System.out.println("1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Bird");
            System.out.println("4. Suprise me");
            System.out.println("0. Exit");
            System.out.print("Enter your selection: ");
            command = s.nextLine();

            switch(command) {
                case "1": {
                    animal = new Dog("Husky");
                    break;
                }
                case "2": {
                    animal = new Cat(true);
                    break;
                }
                case "3": {
                    animal = new Bird(10);
                    break;
                }
                case "0": {
                    animal = null;
                    continue;
                }
                case "4": {
                    Random r = new Random();
                    int result = r.nextInt(3);
                    if (result == 0) {
                        animal = new Dog("Husky");
                    } else if (result == 1) {
                        animal = new Cat(true);
                    } else {
                        animal = new Bird(10);
                    }
                    break;
                }
            }
            
            animal.makeSound();
            animal.describe();
            animal.sleep();

            if (animal instanceof Dog) {
                Dog d = (Dog) animal;
                d.play();
            }
            
            if (animal instanceof Bird) {
                Bird b = (Bird) animal;
                b.flying();
            }
        }
    }
} 