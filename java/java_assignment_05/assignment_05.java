//package java.java_assignment_05;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedHashMap;

public class assignment_05 {
    public static String uniqueWordCount(String sentence){
        sentence = sentence.toLowerCase();
        String[] words = sentence.split("\\s+");
        
        Map<String, Integer> wordCountMap = new LinkedHashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        List<String> output = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            output.add(entry.getKey() + " - " + entry.getValue());
        }

        return String.join(", ", output);
    }

    public static void main(String[] args) {
        System.out.println(uniqueWordCount("The time I went to the store I bought a watermelon"));
        System.out.println(uniqueWordCount("Every word here is unique"));
        System.out.println(uniqueWordCount("One fish two fish red fish blue fish"));
        System.out.println(uniqueWordCount("The quick brown fox jumps over the lazy dog"));
        System.out.println(uniqueWordCount("To be or not to be, that is the question"));
    }
}
