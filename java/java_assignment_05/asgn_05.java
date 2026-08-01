import java.util.LinkedHashMap;
import java.util.Map;

public class asgn_05 {
    public static void main(String[] args) {
        String sentence = args[0];
        countDuplicateWords(sentence);
    }

    public static void countDuplicateWords(String sentence) {
        String[] words = sentence.toLowerCase().split(" ");
        Map<String, Integer> counts = new LinkedHashMap<>(); // linked preserves insertion order

        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        String result = "";
        boolean first = true;
        for (Map.Entry<String, Integer> currentKV : counts.entrySet()) { //Map.Entry 
            if (!first) {
                result += ", ";
            }
            result += currentKV.getKey() + " - " + currentKV.getValue();
            first = false;
        }
        System.out.println(result);
    }
}
