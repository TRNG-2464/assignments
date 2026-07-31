import java.util.Random;
import java.util.Scanner;

public class AnimalSounds {

    private boolean isRunning = true;

    private Random random = new Random();
    public Scanner scanner = new Scanner(System.in);
    
    public void startSoundBoard(){

        Integer selection;

        while(this.isRunning){

            System.out.println("1. Dog");
            System.out.println("2. Bird");
            System.out.println("3. Raccoon");
            System.out.println("0. Exit");

            System.out.print("Enter your selection: ");

            String input = this.scanner.nextLine().trim();

            try {
                selection = Integer.parseInt(input);

            } catch (Exception e) {
                System.out.println("Please enter a number in the options enter as an input.");
                continue;
            }

            switch(selection){
                case 1:
                    Animal dog = new Dog();
                    System.out.println(dog.makeSound());
                    System.out.println(dog.describe());
                    break;
                case 2:
                    Animal bird = new Bird();
                    System.out.println(bird.makeSound());
                    System.out.println(bird.describe());
                    break;
                case 3:
                    Animal raccoon = new Raccoon();
                    System.out.println(raccoon.makeSound());
                    System.out.println(raccoon.describe());
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    this.isRunning = false;
                    this.scanner.close();
                    break;
                default:
                    System.out.println("Please enter a number in the options enter as an input.");
            }

        }

       

    }

    public void startSoundBoardWithAttribute(){

        Integer selection;

        while(this.isRunning){

            System.out.println("1. Dog");
            System.out.println("2. Bird");
            System.out.println("3. Raccoon");
            System.out.println("0. Exit");

            System.out.print("Enter your selection: ");

            String input = this.scanner.nextLine().trim();

            try {
                selection = Integer.parseInt(input);

            } catch (Exception e) {
                System.out.println("Please enter a number in the options enter as an input.");
                continue;
            }

            switch(selection){
                case 1:
                    Animal dog = new DogWithFeat("daschund");
                    System.out.println(dog.makeSound());
                    System.out.println(dog.describe());
                    break;
                case 2:
                    Animal bird = new BirdWithFeat(true);
                    System.out.println(bird.makeSound());
                    System.out.println(bird.describe());
                    break;
                case 3:
                    Animal raccoon = new RaccoonWithFeat(true);
                    System.out.println(raccoon.makeSound());
                    System.out.println(raccoon.describe());
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    this.isRunning = false;
                    break;
                default:
                    System.out.println("Please enter a number in the options enter as an input.");
            }

        }

       

    }

    public void startSoundBoardWithRandom(){

        Integer selection;

        while(this.isRunning){

            System.out.println("1. Dog");
            System.out.println("2. Bird");
            System.out.println("3. Raccoon");
            System.out.println("4. Surprise Me!");
            System.out.println("0. Exit");

            System.out.print("Enter your selection: ");

            String input = this.scanner.nextLine().trim();

            try {
                selection = Integer.parseInt(input);

            } catch (Exception e) {
                System.out.println("Please enter a number in the options enter as an input.");
                continue;
            }
            
            if (selection == 4){
                selection = random.nextInt(3)+1;
            }

            switch(selection){
                case 1:
                    Animal dog = new Dog();
                    System.out.println(dog.makeSound());
                    System.out.println(dog.describe());
                    break;
                case 2:
                    Animal bird = new Bird();
                    System.out.println(bird.makeSound());
                    System.out.println(bird.describe());
                    break;
                case 3:
                    Animal raccoon = new Raccoon();
                    System.out.println(raccoon.makeSound());
                    System.out.println(raccoon.describe());
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    this.isRunning = false;
                    break;
                default:
                    System.out.println("Please enter a number in the options enter as an input.");
            }

        }

       

    }
    
}
