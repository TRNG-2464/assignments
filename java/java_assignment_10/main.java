
import java.util.*;

public class main {

    static String stringRuns(String string) {
        if (string.isEmpty()) return "";

        String result = "";
        char runChar = string.charAt(0);
        int runLength = 1;
        for (int i = 1; i < string.length(); i++) {
            char c = string.charAt(i);

            if (Character.toLowerCase(runChar) == Character.toLowerCase(c)) {
                runLength++;
            } else {
                result += runChar;
                result += runLength;
                runLength = 1;
                runChar = c;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(stringRuns("AAaAbcd"));
    }
}
