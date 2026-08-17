public class CompressConsecutive {

    public static void main(String[] args) {
        System.out.println(compress("aaabbbccd"));
        System.out.println(compress("abcd"));
        System.out.println(compress("aaaaaa"));
        System.out.println(compress("aAaA"));
        System.out.println(compress(""));
    }

    public static String compress(String input) {
        if (input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        char runChar = input.charAt(0);
        int runCount = 1;

        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);

            if (Character.toLowerCase(current) == Character.toLowerCase(runChar)) {
                runCount++;
            } else {
                result.append(runChar).append(runCount);
                runChar = current;
                runCount = 1;
            }
        }

        result.append(runChar).append(runCount);
        return result.toString();
    }
}
