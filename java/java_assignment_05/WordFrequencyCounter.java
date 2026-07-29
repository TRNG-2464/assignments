
import java.util.LinkedHashMap;
import java.util.Map;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        countWords("The time I went to the store I bought a watermelon");
        countWords("Every word here is unique");
    }

    public static void countWords(String sentence) {

        String[] words = sentence.split(" ");

        LinkedHashMap<String, Integer> wordCounts = new LinkedHashMap<>();

        for (String word : words) {
            word = word.toLowerCase();

            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        boolean first = true;

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {

            if (!first) {
                System.out.print(", ");
            }

            System.out.print(entry.getKey() + " - " + entry.getValue());

            first = false;
        }

        System.out.println();
    }
}
