import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class WordCollection{

    public void tokenizer(String sentence){
        HashMap<String, Integer> collection = new HashMap<>();

        String[] collectionWords = sentence.split("\\s+");

        for (String word: collectionWords){
            collection.put(word.toLowerCase(), collection.getOrDefault(word.toLowerCase(), 0) + 1);
        }

        for (HashMap.Entry<String, Integer> wordCountPairs: collection.entrySet()){
            System.out.print(wordCountPairs.getKey() + " - " + wordCountPairs.getValue());
        }

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
                answer.add(lowercasedWord);
            }
        }


        return String.join(" ", answer);
    }

    // Stretch goal 2
    public void tokenizerWithStatistics(String sentence){
        HashMap<String, Integer> collection = new HashMap<>();

        String[] collectionWords = sentence.split("\\s+");

        int minimumLength = collectionWords[0].length(), maximumLength  = collectionWords[0].length(), mostFrequent = 1, leastFrequent = Integer.MAX_VALUE;

        for (String word: collectionWords){
            collection.put(word.toLowerCase(), collection.getOrDefault(word.toLowerCase(), 0) + 1);
            if (minimumLength > word.length()) minimumLength = word.length();
            if (maximumLength < word.length()) maximumLength = word.length();
        }

        for (HashMap.Entry<String, Integer> wordCountPairs: collection.entrySet()){
            System.out.print(wordCountPairs.getKey() + " - " + wordCountPairs.getValue());
            if (leastFrequent > wordCountPairs.getValue()) leastFrequent = wordCountPairs.getValue();
            if (mostFrequent < wordCountPairs.getValue()) mostFrequent = wordCountPairs.getValue();
        }

        System.out.println("The most frequent word/s is/are: ");
        for (HashMap.Entry<String, Integer> wordCountPairs: collection.entrySet()){
            if (wordCountPairs.getValue() == mostFrequent) System.out.print(wordCountPairs.getKey() + " ");
        }

        System.out.println("The least frequent word/s is/are: ");
        for (HashMap.Entry<String, Integer> wordCountPairs: collection.entrySet()){
            if (wordCountPairs.getValue() == leastFrequent) System.out.print(wordCountPairs.getKey() + " ");
        }

        System.out.println("The longest word/s is/are: ");
        for (HashMap.Entry<String, Integer> wordCountPairs: collection.entrySet()){
            if (wordCountPairs.getValue() == maximumLength) System.out.print(wordCountPairs.getKey() + " ");
        }

        System.out.println("The shortest word/s is/are: ");
        for (HashMap.Entry<String, Integer> wordCountPairs: collection.entrySet()){
            if (wordCountPairs.getValue() == minimumLength) System.out.print(wordCountPairs.getKey() + " ");
        }
    }

}