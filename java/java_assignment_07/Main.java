import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AnimalSounds animalSounds = new AnimalSounds();

        try (Scanner scanner = animalSounds.scanner) {
            System.out.println("Which sound board would you like to test?");
            System.out.println("1. Base sound board (Dog, Bird, Raccoon)");
            System.out.println("2. Sound board with additional attributes (stretch goal)");
            System.out.println("3. Sound board with random 'Surprise Me!' option (stretch goal)");
            System.out.print("Enter your selection: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "2":
                    animalSounds.startSoundBoardWithAttribute();
                    break;
                case "3":
                    animalSounds.startSoundBoardWithRandom();
                    break;
                case "1":
                default:
                    animalSounds.startSoundBoard();
                    break;
            }
        }
    }
}
