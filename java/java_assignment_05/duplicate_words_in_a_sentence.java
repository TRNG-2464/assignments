import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class duplicate_words_in_a_sentence {

	public static void main(String[] args) {
		
		duplicate_words_in_a_sentence dup = new duplicate_words_in_a_sentence();
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a sentence:");
		String sentence = sc.nextLine();
		System.out.println("Duplicate words: " + dup.findDuplicateWords(sentence));

		sc.close();
	}

	public String findDuplicateWords(String sentence) {
		
		// Regex expression: Splits the sentence into words while splitting on whitespace characters
		String[] words = sentence.toLowerCase().trim().split("\\s+");

		Map<String, Integer> wordCountMap = new HashMap<>();
		for (String word : words) {
			wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
		}
		return wordCountMap.toString();
	}
}
