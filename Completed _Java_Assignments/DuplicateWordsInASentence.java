import java.util.*;

public class DuplicateWordsInASentence {
    public static void main(String[] args){
        duplicateWords("The time I went to the store I bought a watermelon");
    }
    public static void duplicateWords(String sentence){
        String[] words = sentence.toLowerCase().split("\\W+");
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        System.out.println("--- All Word Counts ---");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    public static String removeDuplicateWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return sentence;
        }

        String[] words = sentence.split(" ");

        Set<String> uniqueWords = new LinkedHashSet<>();

        Set<String> seenLowerCase = new HashSet<>();

        for (String word : words) {
            String lowerWord = word.toLowerCase();

            if (!seenLowerCase.contains(lowerWord)) {
                uniqueWords.add(word);
            }
        }

        return String.join(" ", uniqueWords);
    }

    public static void printSentenceStats(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            System.out.println("Sentence is empty.");
            return;
        }

        // 1. Clean and split the text into raw words
        // Using \\W+ keeps only characters/numbers and removes commas/periods
        String[] words = sentence.toLowerCase().split("\\W+");

        // 2. Count word frequencies
        Map<String, Integer> frequencies = new HashMap<>();
        for (String w : words) {
            if (!w.isEmpty()) {
                frequencies.put(w, frequencies.getOrDefault(w, 0) + 1);
            }
        }

        // 3. Find extreme boundaries for Frequency and Length
        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        int minLen = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            int freq = entry.getValue();
            int len = entry.getKey().length();

            if (freq > maxFreq) maxFreq = freq;
            if (freq < minFreq) minFreq = freq;
            if (len > maxLen)   maxLen = len;
            if (len < minLen)   minLen = len;
        }

        // 4. Collect all items that match those boundary values to handle ties
        List<String> mostFrequentWords = new ArrayList<>();
        List<String> leastFrequentWords = new ArrayList<>();
        List<String> longestWords = new ArrayList<>();
        List<String> shortestWords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            String word = entry.getKey();
            int freq = entry.getValue();
            int len = word.length();

            if (freq == maxFreq) mostFrequentWords.add(word);
            if (freq == minFreq) leastFrequentWords.add(word);
            if (len == maxLen)   longestWords.add(word);
            if (len == minLen)   shortestWords.add(word);
        }

        // 5. Print out the formal analysis report
        System.out.println("=== SENTENCE STATISTICS REPORT ===");
        System.out.println("Most Frequent " + mostFrequentWords + " | Count: " + maxFreq);
        System.out.println("Least Frequent " + leastFrequentWords + " | Count: " + minFreq);
        System.out.println("Longest Word(s) " + longestWords + " | Length: " + maxLen);
        System.out.println("Shortest Word(s) " + shortestWords + " | Length: " + minLen);
    }
}
