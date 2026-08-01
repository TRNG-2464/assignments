import java.util.HashMap;

public class DuplicateWordsSentence {

    public static void main(String[] args) {

        // 1. Basic duplicate words
        duplicateWordsSentence("hello world hello");

        // 2. Multiple duplicated words
        duplicateWordsSentence("the quick brown fox jumps over the quick brown fox");

        // 3. Case-insensitive test
        duplicateWordsSentence("Hello hello HELLO");

        // 4. No duplicates
        duplicateWordsSentence("java python cplusplus");

        // 5. One word repeated many times
        duplicateWordsSentence("test test test test");

        // 6. Multiple words with different frequencies
        duplicateWordsSentence("apple banana apple orange banana apple");

        // 7. Empty string
        duplicateWordsSentence("");

        // 8. Single word
        duplicateWordsSentence("hello");

        // 9. Repeated common words
        duplicateWordsSentence("the cat and the dog and the cat");

    }

    public static void duplicateWordsSentence(String str) {
        String[] str_arr = str.toLowerCase().split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String key : str_arr) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        System.err.print("\n");
        for (String key : map.keySet()) {
            System.out.print(" " + key + " - " + map.get(key) + ",");
        }
    }
}
