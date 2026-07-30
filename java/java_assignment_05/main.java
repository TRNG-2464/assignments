import java.util.*;

public class main {

    static void duplicateWords(String string) {
        String[] tokens = string.toLowerCase().split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String token : tokens) {
            Integer found = map.get(token);
            if (found == null) {
                map.put(token, 1);
            } else {
                map.put(token, found + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " - " + entry.getValue() + ", ");
        }
        System.out.println();
    }

    static void removeDuplicates(String string) {
        String result = "";
        String[] tokens = string.split(" ");

        Set<String> set = new HashSet<>();

        for (String token : tokens) {
            if (!set.contains(token)) {
                result += token + " ";
            }
            set.add(token);
        }

        System.out.println(result);
    }

    static void sentenceStatistics(String string) {
        String[] tokens = string.toLowerCase().split(" ");

        Map<String, Integer> map = new HashMap<>();


        for (String token : tokens) {
            Integer value = map.get(token);
            if (value == null) {
                value = 0;
            }
            map.put(token, value + 1);
        }

        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;
        int minFreq = Integer.MAX_VALUE;
        int maxFreq = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String token = entry.getKey();
            Integer freq = entry.getValue();

            if (token.length() > maxLength) {
                maxLength = token.length();
            }
            if (token.length() < minLength) {
                minLength = token.length();
            }

            if (freq > maxFreq) {
                maxFreq = freq;
            }
            if (freq < minFreq) {
                minFreq = freq;
            }
        }


        System.out.print("Most frequently occuring word(s): ");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String token = entry.getKey();
            Integer freq = entry.getValue();
            if (freq == maxFreq) {
                System.out.print(token + ", ");
            }
        }
        System.out.println();

        System.out.print("Least frequently occuring word(s): ");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String token = entry.getKey();
            Integer freq = entry.getValue();
            if (freq == minFreq) {
                System.out.print(token + ", ");
            }
        }
        System.out.println();


        System.out.print("Longest word(s): ");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String token = entry.getKey();
            if (token.length() == maxLength) {
                System.out.print(token + ", ");
            }
        }
        System.out.println();

        System.out.print("Shortest word(s): ");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String token = entry.getKey();
            if (token.length() == minLength) {
                System.out.print(token + ", ");
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // duplicateWords("The time I went to the store I bought a watermelon");
        // duplicateWords("Every word here is unique");
        // removeDuplicates("The time I went to the store I bought a watermelon");
        sentenceStatistics("The time I went to the store I bought a watermelon");
    }
}
