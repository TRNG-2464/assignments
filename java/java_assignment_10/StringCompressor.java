import java.util.Scanner;

public class StringCompressor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        compressConsecutiveChars(str);

        sc.close();      
    }

    public static void compressConsecutiveChars(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("");
        }

        StringBuilder result = new StringBuilder();
        char firstCharOfRun = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);

            if (Character.toLowerCase(current) == Character.toLowerCase(firstCharOfRun)) {
                count++;
            } else {
                result.append(firstCharOfRun).append(count);
                firstCharOfRun = current;
                count = 1;
            }
        }

        result.append(firstCharOfRun).append(count);

        System.out.println(result.toString());
    }
}