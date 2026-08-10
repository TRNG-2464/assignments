import java.util.Scanner;

public class Main {

    public static String compress(String text) {

        if (text.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        int count = 1;

        for (int i = 1; i < text.length(); i++) {

            if (Character.toLowerCase(text.charAt(i))
                    == Character.toLowerCase(text.charAt(i - 1))) {

                count++;

            } else {

                result.append(text.charAt(i - 1));
                result.append(count);

                count = 1;
            }
        }

        // Add the last character and its count
        result.append(text.charAt(text.length() - 1));
        result.append(count);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        String output = compress(input);

        System.out.println("Output: " + output);

        scanner.close();
    }
}