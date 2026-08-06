public class RunLengthCompressor {

    public static String compress(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        char firstChar = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            if (Character.toLowerCase(current) == Character.toLowerCase(firstChar)) {
                count++;
            } else {
                result.append(firstChar).append(count);
                firstChar = current;
                count = 1;
            }
        }
        result.append(firstChar).append(count);

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aaabbbccd"));
        System.out.println(compress("abcd"));     
        System.out.println(compress("aaaaaa"));    
        System.out.println(compress("aAaA"));   
        System.out.println(compress("Aa"));        
    }
}