import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Solution{

    /**
     * Main assignment method.
     * Splits words into strings and counts their (case insensitive) occurrence.
     * General strategy is to use a LinkedHashMap to preserve order as well as storing the original (not lowercase) word as the value.
     * @param sentence the sentence given
    */
    static void countWords(String sentence){
        // split all words into array
        String[] splitWords = sentence.split(" ");
        LinkedHashMap<String, Integer> m = new LinkedHashMap<String, Integer>();
        for (String word: splitWords){
            // this little handy line takes the lowercase word as the key, incrementing the value by 1 if it already exists in the map
            // and setting its value to 1 if it didn't already.

            m.merge(word.toLowerCase(), 1, Integer::sum); 
        }

        int index = 0;
        // loop through the map printing
        for (Map.Entry<String, Integer> entry: m.entrySet()){
            System.out.print(entry.getKey() + " - " + entry.getValue());
            // check if the element is the last one in the map to enable neat printing
            if (index != m.size() - 1){
                 System.out.print(", ");
            }
            else{
                System.out.println("");
            }
            index++;
        }
    }

    /**
     * Stretch Goal 1: Remove all duplicate sentences, printing out the first occurrence of each word in its original casing in order.
     * @param sentence the given sentence
     */
    static void removeDuplicates(String sentence){
        String[] splitWords = sentence.split(" ");
        LinkedHashMap<String, String> m = new LinkedHashMap<String, String>();
        for (String word: splitWords){
            String lower = word.toLowerCase();
            // check if the word is already in
            if (!m.containsKey(lower)){
                m.put(lower, word);
            }
        }
        // print out
        for (Map.Entry<String, String> entry: m.entrySet()){
            System.out.print(entry.getValue() + " ");
        }
        System.out.println("");
    }

    /**
     * Stretch Goal 2: print out statistics on the most and least frequently used words, as well as the longest and shortest words.
     * This requires a good few auxillary variables.
     * @param sentence
     */
    static void sentenceStatistics(String sentence){
        String[] splitWords = sentence.split(" ");
        LinkedHashMap<String, Integer> m = new LinkedHashMap<String, Integer>();
        for (String word: splitWords){
            m.merge(word.toLowerCase(), 1, Integer::sum); 
        }

        // variables to store the max and min lengths, as well as all words of said max/min lengths
        int longest = 0, shortest = 10000000;
        List<String> longestWords = new ArrayList<>(), shortestWords = new ArrayList<>();

        // variables to store the max and min frequencies, as well as all words of said frequencies
        int mostFrequent = 0, leastFrequent = 10000000;
        List<String> mostFrequentWords = new ArrayList<>(), leastFrequentWords = new ArrayList<>();


        for (HashMap.Entry<String, Integer> entry: m.entrySet()){
            String word = entry.getKey();
            int freq = entry.getValue();

            // all these checks follow a similar pattern, so i'll just comment the first one. 
            if (freq >= mostFrequent){
                // if it's strictly more frequent than the previous best, we have to clear out all of the old elements + update best var
                if (freq > mostFrequent){
                    mostFrequent = freq;
                    mostFrequentWords.clear();
                }

                // whether we clear out the old elements or the frequency is just equal to the current best, we still append the word to the corresponding list.
                mostFrequentWords.add(word);
            }

            // same but for least frequent
            if (freq <= leastFrequent){
                if (freq < leastFrequent){
                    leastFrequent = freq;
                    leastFrequentWords.clear();
                }
                leastFrequentWords.add(word);
            }

            int length = word.length();
            // same but for longest
            if (length >= longest){
                if (length > longest){
                    longest = length;
                    longestWords.clear();
                }
                longestWords.add(word);
            }
            // same but for shortest
            if (length <= shortest){
                if (length < shortest){
                    shortest = length;
                    shortestWords.clear();
                }
                shortestWords.add(word);
            }
        }

        // print results
        System.out.println("Longest words (" + longest + " characters): " + longestWords);
        System.out.println("Shortest words (" + shortest + " characters): " + shortestWords);
        System.out.println("Most frequent words (" + mostFrequent + " occurrences): " + mostFrequentWords);
        System.out.println("Least frequent words (" + leastFrequent + " occurrences): " + leastFrequentWords);
    }


    public static void main(String[] args){
        countWords("a a a b c d e"); // Output: a - 3, b - 1, c - 1, d - 1, e - 1
        countWords("lizard lemming lecherous lettuce lettuce lizard lizard lizard"); // Output: lemming - 1, lecherous - 1, lettuce - 2, lizard - 4
        countWords("no unique words here"); // Output: here - 1, no - 1, unique - 1, words - 1
        countWords("m m m m m m m m m m m m m m m m m m m ma"); // Output: ma - 1, m - 19
    }
}