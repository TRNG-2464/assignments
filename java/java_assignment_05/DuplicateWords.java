import java.util.ArrayList;
import java.util.HashMap;

public class DuplicateWords {
    public void getWordCount(String sentence) {
        HashMap<String, Integer> freq = new HashMap<>();
        ArrayList<String> order = new ArrayList<>();

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            // New word
            if (!freq.containsKey(word)) {
                freq.put(word, 0);
                order.add(word);
            }

            freq.put(word, freq.get(word) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.size(); i++) {
            String word = order.get(i);
            sb.append(String.format("%s - %d, ", word, freq.get(word)));
        }
        System.out.println(sb.toString());
    }

    public void getUniqueWords(String sentence) {
        HashMap<String, Integer> freq = new HashMap<>();
        ArrayList<String> order = new ArrayList<>();

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            // New word
            if (!freq.containsKey(word)) {
                freq.put(word, 0);
                order.add(word);
            }

            freq.put(word, freq.get(word) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.size(); i++) {
            String word = order.get(i);
            if (freq.get(word) > 1) {}
            sb.append(String.format("%s - %d, ", word, freq.get(word)));
        }
        System.out.println(sb.toString());
    }

    public void getSentenceStatistics(String sentence) {
        HashMap<String, Integer> freq = new HashMap<>();
        ArrayList<String> mostFreqList = new ArrayList<>();
        ArrayList<String> leastFreqList = new ArrayList<>();
        ArrayList<String> longestLengthList = new ArrayList<>();
        ArrayList<String> shortestLengthList = new ArrayList<>();

        int mostFreqCount = 0;
        int leastFreqCount = Integer.MAX_VALUE;
        int longestWordLength = 0;
        int shortestWordLength = Integer.MAX_VALUE;

        // Count frequency
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            // New word
            if (!freq.containsKey(word)) {
                freq.put(word, 0);
            }

            freq.put(word, freq.get(word) + 1);

            mostFreqCount = Math.max(mostFreqCount, freq.get(word));
            leastFreqCount = Math.min(leastFreqCount, freq.get(word));
            longestWordLength = Math.max(longestWordLength, word.length());
            shortestWordLength = Math.min(shortestWordLength, word.length());
        }

        for (HashMap.Entry<String, Integer> entry : freq.entrySet()) {
            String word = entry.getKey();
            Integer count = entry.getValue();
            if (count == mostFreqCount) {
                mostFreqList.add(word);
            }
            if (count == leastFreqCount) {
                leastFreqList.add(word);
            }
            if (word.length() == longestWordLength) {
                longestLengthList.add(word);
            }
            if (word.length() == shortestWordLength) {
                shortestLengthList.add(word);
            }
        }

        System.out.println(String.format("Most frequent words: %s", String.join(", ", mostFreqList)));
        System.out.println(String.format("Least frequent words: %s", String.join(", ", leastFreqList)));
        System.out.println(String.format("Longest words: %s", String.join(", ", longestLengthList)));
        System.out.println(String.format("Shortest words: %s", String.join(", ", shortestLengthList)));
    }
}