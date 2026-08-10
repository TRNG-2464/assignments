package exercise10;

public class exercise10 {
    public static void main(String[] args) {
        System.out.println(stretch2("h10J4"));
    }
    public static String stringCounter(String s) {
        String ret = "";
        int i = 0;
        while (i < s.length()) {
            int count = 0;
            char currChar = s.charAt(i);
            ret += currChar;
            while (i < s.length() && Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(currChar)) {
                count += 1;
                i += 1;
            }
            ret += count;
        }
        return ret;
    }
    public static String stretch1(String s) {
        String ret = "";
        int i = 0;
        while (i < s.length()) {
            int count = 0;
            char currChar = s.charAt(i);
            ret += currChar;
            while (i < s.length() && Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(currChar)) {
                count += 1;
                i += 1;
            }
            ret += count;
        }
        if (ret.length() < s.length()) {
            return ret;
        }
        return s;
    }
    public static String stretch2(String s) {
        String ret = "";
        int i = 0;
        while (i < s.length()-1) {
            char currChar = s.charAt(i);
            String num = "";
            i += 1;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num += s.charAt(i);
                i += 1;
            }
            for (int j = 0; j < Integer.parseInt(num); j++) {
                ret += currChar;
            }
        }
        return ret;
    }
}
