import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateWordsInSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nInput: ");
        String sentence = sc.nextLine();

        checkDupe(sentence);

        System.out.println();
        sc.close();
    }

    public static void checkDupe(String sent) {
        String[] split = sent.toLowerCase().split(" ");
        LinkedHashMap<String, Integer> check = new LinkedHashMap<>();

        for (String s : split) {
            if (check.containsKey(s)) {
                // already in map
                int val = check.get(s);
                check.put(s, val + 1);
            } else {
                check.put(s, 1);
            }
        }

        System.out.println("\nOutput: ");

        Map.Entry<String,Integer> last = check.lastEntry();
        for (Map.Entry<String, Integer> entry : check.entrySet()) {
            boolean isLast = entry.getKey().equals(last.getKey());
            if (isLast) {
                System.out.print(entry.getKey() + " - " + entry.getValue() + "\n");
            } else {
                System.out.print(entry.getKey() + " - " + entry.getValue() + ", ");
            }
        }
    }
}
