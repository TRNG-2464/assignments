import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateWords {

    // Counts and prints each unique word
    public static void countWords(String sentence) {

        // Matching is case-insensitive
        sentence = sentence.toLowerCase();

        // Split the sentence into individual words
        String[] words = sentence.split(" ");

        // LinkedHashMap to keep words in original first-appearance order
        Map<String, Integer> wordCounts = new LinkedHashMap<>();

        // Count each word with enhanced for loop
        for (String word : words) {

            if (wordCounts.containsKey(word)) {

                // Add 1 to the word's current count
                wordCounts.put(
                        word,
                        wordCounts.get(word) + 1
                );

            } else {

                // Add the word to the map with a count of 1
                wordCounts.put(word, 1);
            }
        }

        // Print each word and its total count
        boolean firstEntry = true;

        for (Map.Entry<String, Integer> entry
                : wordCounts.entrySet()) {

            // Add a comma before every entry except the first
            if (!firstEntry) {
                System.out.print(", ");
            }

            System.out.print(
                    entry.getKey()
                            + " - "
                            + entry.getValue()
            );

            firstEntry = false;
        }

        // Move to the next line after printing the results
        System.out.println();
    }


    // Allows the user to manually test the method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");

        String sentence = scanner.nextLine();

        System.out.println();
        countWords(sentence);

        scanner.close();
    }
}