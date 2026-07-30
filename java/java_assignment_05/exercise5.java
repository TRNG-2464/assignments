import java.util.*;
public class exercise5 {
    public static void main(String[] args) {
        System.out.print(wordCounts("Every word here is unique"));
    }
    public static StringBuilder wordCounts(String sentence) {
        StringBuilder ret = new StringBuilder();
        HashMap<String, Integer> counts = new HashMap<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (counts.containsKey(word.toLowerCase())) {
                counts.put(word.toLowerCase(), counts.get(word.toLowerCase()) + 1);
            } else {
                counts.put(word.toLowerCase(), 1);
            }
        }
        HashSet<String> seen = new HashSet<>();
        for (String word : words) {
            if (!seen.contains(word.toLowerCase())) {
                ret.append(word.toLowerCase()).append(" - ").append(counts.get(word.toLowerCase())).append(", ");
                seen.add(word.toLowerCase());
            }
        }
        ret.deleteCharAt(ret.length() - 1);
        ret.deleteCharAt(ret.length() - 1);
        return ret;
    }
    public static StringBuilder stretchGoal1(String sentence) {
        String[] words = sentence.split(" ");
        HashSet<String> seen = new HashSet<>();
        StringBuilder ret = new StringBuilder();
        for (String word : words) {
            if (!seen.contains(word.toLowerCase())) {
                ret.append(word);
                seen.add(word.toLowerCase());
            }
        }
        return ret;
    }
}
