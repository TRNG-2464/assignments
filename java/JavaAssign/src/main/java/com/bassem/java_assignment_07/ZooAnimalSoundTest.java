package com.bassem.java_assignment_07;
import java.util.Scanner;
public class ZooAnimalSoundTest {

    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        while (true){
            //Display 1-4
            System.out.println("1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Bird");
            System.out.println("4. Exit");
            System.out.println("Enter your selection: ");
            String input = scanner.nextLine();

            int choice;
            // handle non_req_input
            try{
                choice = Integer.parseInt(input);
            }catch(NumberFormatException e){
                System.out.println("'" + input
                        + "' is not a valid selection. Please enter a number. " );
                continue;
            }

            //Exit
            if(choice == 0){
                System.out.println("Goodbye! thank you for visting the zoo.");
                break;
            }
            Animal animal;

            // select what animal you see
            switch (choice){
                case 1 :
                    animal =new Dog();
                    break;
                case 2 :
                    animal =new Cat();
                    break;
                case 3 :
                    animal =new Bird();
                    break;
                default:
                    System.out.println("'" + choice
                    + "' is not a valid selection. " +
                            "Please choose a number from the menu above. ");
                    continue;
            }

            // Display inheritance Polymorphism

            animal.makeSound();
            animal.describe();
            System.out.println();
        }
     scanner.close();
    }
}
