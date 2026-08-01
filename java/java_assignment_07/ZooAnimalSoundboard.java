import java.util.Scanner;

public class ZooAnimalSoundboard {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Bird bird = new Bird();

        boolean running = true;
        Scanner sc = new Scanner(System.in);
        
        while (running) {
            System.out.println("\n1. Dog\n2. Cat\n3. Bird\n0. Exit");
            System.out.print("Enter selection: ");
            int choice;

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                
                switch (choice) {
                    case 0:
                        System.out.println("Goodbye!\n");
                        running = false;
                        break;
                    case 1:
                        dog.makeSound();
                        dog.describe();
                        break;
                    case 2:
                        cat.makeSound();
                        cat.describe();
                        break;
                    case 3:
                        bird.makeSound();
                        bird.describe();
                        break;
                    default:
                        System.out.println("Enter a valid selection!");
                        break;
                }
            } else {
                System.out.println("'" + sc.next() + "' is not an integer. Try again!");
                //sc.next();
                continue;
            }
        }
        sc.close();
    }
}
