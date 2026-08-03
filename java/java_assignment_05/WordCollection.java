import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class WordCollection{

    public void tokenizer(String sentence){
        LinkedHashMap<String, Integer> collection = new LinkedHashMap<>();

        String[] collectionWords = sentence.split("\\s+");

        for (String word: collectionWords){
            collection.put(word.toLowerCase(), collection.getOrDefault(word.toLowerCase(), 0) + 1);
        }

        List<String> pairs = new ArrayList<>();
        for (Map.Entry<String, Integer> wordCountPairs: collection.entrySet()){
            pairs.add(wordCountPairs.getKey() + " - " + wordCountPairs.getValue());
        }
        System.out.println(String.join(", ", pairs));
    }

    // Only really works if there's only one space between words
    public String removeDuplicateWords(String sentence){
        HashSet<String> collection = new HashSet<>();

        String[] collectionWords = sentence.split("\\s+");

        List<String> answer = new ArrayList<>();

        for (String word: collectionWords){
            String lowercasedWord = word.toLowerCase();
            if (!collection.contains(lowercasedWord)){
                collection.add(lowercasedWord);
                answer.add(word);
            }
        }


        return String.join(" ", answer);
    }

    // Stretch goal 2
    public void tokenizerWithStatistics(String sentence){
        LinkedHashMap<String, Integer> collection = new LinkedHashMap<>();

        String[] collectionWords = sentence.split("\\s+");

        int minimumLength = collectionWords[0].length(), maximumLength  = collectionWords[0].length();

        for (String word: collectionWords){
            collection.put(word.toLowerCase(), collection.getOrDefault(word.toLowerCase(), 0) + 1);
            if (minimumLength > word.length()) minimumLength = word.length();
            if (maximumLength < word.length()) maximumLength = word.length();
        }

        int mostFrequent = 0, leastFrequent = Integer.MAX_VALUE;
        for (int count: collection.values()){
            if (count > mostFrequent) mostFrequent = count;
            if (count < leastFrequent) leastFrequent = count;
        }

        List<String> pairs = new ArrayList<>();
        for (Map.Entry<String, Integer> wordCountPairs: collection.entrySet()){
            pairs.add(wordCountPairs.getKey() + " - " + wordCountPairs.getValue());
        }
        System.out.println(String.join(", ", pairs));

        List<String> mostFrequentWords = new ArrayList<>();
        List<String> leastFrequentWords = new ArrayList<>();
        for (Map.Entry<String, Integer> wordCountPairs: collection.entrySet()){
            if (wordCountPairs.getValue() == mostFrequent) mostFrequentWords.add(wordCountPairs.getKey());
            if (wordCountPairs.getValue() == leastFrequent) leastFrequentWords.add(wordCountPairs.getKey());
        }
        System.out.println("The most frequent word/s is/are: " + String.join(" ", mostFrequentWords));
        System.out.println("The least frequent word/s is/are: " + String.join(" ", leastFrequentWords));

        List<String> longestWords = new ArrayList<>();
        List<String> shortestWords = new ArrayList<>();
        for (String word: collection.keySet()){
            if (word.length() == maximumLength) longestWords.add(word);
            if (word.length() == minimumLength) shortestWords.add(word);
        }
        System.out.println("The longest word/s is/are: " + String.join(" ", longestWords));
        System.out.println("The shortest word/s is/are: " + String.join(" ", shortestWords));
    }

    public static void main(String[] args){
        WordCollection wordCollection = new WordCollection();

        String sentenceWithDuplicates = "The time I went to the store I bought a watermelon";
        String sentenceWithoutDuplicates = "Every word here is unique";

        System.out.println("=== tokenizer ===");
        System.out.println("Input: \"" + sentenceWithDuplicates + "\"");
        wordCollection.tokenizer(sentenceWithDuplicates);

        System.out.println("Input: \"" + sentenceWithoutDuplicates + "\"");
        wordCollection.tokenizer(sentenceWithoutDuplicates);

        System.out.println();
        System.out.println("=== removeDuplicateWords (stretch goal 1) ===");
        System.out.println("Input: \"" + sentenceWithDuplicates + "\"");
        System.out.println("Output: \"" + wordCollection.removeDuplicateWords(sentenceWithDuplicates) + "\"");

        System.out.println();
        System.out.println("=== tokenizerWithStatistics (stretch goal 2) ===");
        System.out.println("Input: \"" + sentenceWithDuplicates + "\"");
        wordCollection.tokenizerWithStatistics(sentenceWithDuplicates);
    }

}
