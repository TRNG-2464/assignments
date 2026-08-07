public class assignment_10 {
    public static String compressConsecString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        str = str.toLowerCase();
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i - 1));
                compressed.append(count);
                count = 1;
            }
        }
        compressed.append(str.charAt(str.length() - 1));
        compressed.append(count);
        return compressed.toString();
    }
    
    public static void main(String[] args) {
        String input = "aaabbcdddde";
        String compressedString = compressConsecString(input);
        System.out.println("Original String: " + input);
        System.out.println("Compressed String: " + compressedString);

        String input2 = "abcd";
        String compressedString2 = compressConsecString(input2);
        System.out.println("Original String: " + input2);
        System.out.println("Compressed String: " + compressedString2);

        String input3 = "aaaaaa";
        String compressedString3 = compressConsecString(input3);
        System.out.println("Original String: " + input3);
        System.out.println("Compressed String: " + compressedString3);

        String input4 = "aAaA";
        String compressedString4 = compressConsecString(input4);
        System.out.println("Original String: " + input4);
        System.out.println("Compressed String: " + compressedString4);

        String input5 = "";
        String compressedString5 = compressConsecString(input5);
        System.out.println("Original String: " + input5);
        System.out.println("Compressed String: " + compressedString5);
    }
}