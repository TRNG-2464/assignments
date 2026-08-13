public class Solution {
    public static void main(String[] args) {
        // String result = compressConsecutiveCharacters("");
        // System.out.println(result);

        String result = decompress("a20");
        System.out.println(result);
    }

    public static String compressConsecutiveCharacters(String s) {
        if (s.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        char letter = s.charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // if same letter,
            if (letter == Character.toLowerCase(s.charAt(i))) {
                count += 1;
            } else {
                // add letter + count to string builder
                sb.append(letter);
                sb.append(count);
                letter = s.charAt(i);
                count = 1;
            }
        }

        // add last character
        sb.append(letter);
        sb.append(count);

        return sb.toString();
    }

    // Stretch goal - Only Compress When Shorter 
    public static String onlyCompressWhenShorter(String s) {
        String compressed = compressConsecutiveCharacters(s);
        return compressed.length() < s.length() ? compressed : s;
    }

    public static String decompress(String s) {
        if (s.length() == 0) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        StringBuilder numString = new StringBuilder();
        int i = 0;

        char letter = s.charAt(0);
        i += 1;

        while (i < s.length()) {
            // if s.getChar(i) is digit
            if (isNumeric(String.valueOf(s.charAt(i)))) {
                // add to numString
                numString.append(s.charAt(i));
            } else {
                // convert numString to number
                int n = Integer.valueOf(numString.toString());
                // append letter n times
                for (int j = 0; j < n; j++) {
                    res.append(letter);
                }
                letter = s.charAt(i);
                numString.setLength(0);
            }
            i += 1;
        }

        // Add remaining letters
        int n = Integer.valueOf(numString.toString());
        // append letter n times
        for (int j = 0; j < n; j++) {
            res.append(letter);
        }

        return res.toString();
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}