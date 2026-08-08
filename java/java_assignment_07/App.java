import java.util.Scanner;

import com.mycompany.app.Cat;
import com.mycompany.app.Dog;
import com.mycompany.app.Mouse;

public class App {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Mouse mouse = new Mouse();
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("""
                    Zoo Animal Sound Board
                    Select one of the following options
                    1.Dog
                    2.Cat
                    3.Mouse 
                    0.Exit
                    """);
            int command = 0;
            do {
                System.out.print("command: ");
                command = input.nextInt();
                switch (command) {
                    case 0:
                        break;
                    case 1:
                        System.out.println("Description: " + dog.describe() + " Noise: " + dog.makeSound());
                        break;
                    case 2:
                        System.out.println("Description: " + cat.describe() + " Noise: " + cat.makeSound());
                        break;
                    case 3:
                        System.out.println("Description: " + mouse.describe() + " Noise: " + mouse.makeSound());
                        break;

                    default:
                        System.out.println("Unrecognized command.");
                }
            } while (command != 0);
            System.out.println("Goodbye.");
        }

    }

}
