import java.util.LinkedHashMap;
import java.util.Map;

public class DuplicateWords {
    // Counts how many times each word appears
    public static void countWords(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split(" ");
        // LinkedHashMap keeps the words in the order they were added
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        // Go through each word
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();

            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        // Print the results
        boolean first = true;

        for (String word : wordCount.keySet()) {
            if (!first) {
                System.out.print(", ");
            }
            System.out.print(word + " - " + wordCount.get(word));
            first = false;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        countWords("The time I went to the store I bought a watermelon");
        countWords("Every word here is unique");
    }
}