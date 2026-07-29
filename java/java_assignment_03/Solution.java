import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Solution {
    /**
     * Main assignment method. uses % 3 to take advantage of the property that if 1 = Yellow, 4, 7, 10, 13, etc. will all also equal Yellow because a full rotation is 3 ticks.
     * @param lightColor the starting color
     * @param ticks the number of ticks to simulate
     */
    static String simulateLight(String lightColor, int ticks){
        if (!lightColor.equals("Green") && !lightColor.equals("Yellow") && !lightColor.equals("Red")){
            return "Color " + lightColor + " is not recognized";
        }
        else if (ticks < 0){
            return "Invalid: negative ticks not allowed";
        }

        ticks = ticks % 3;
        String currentColor = lightColor;
        for (int i = 0; i < ticks; i++){
            switch(currentColor){
                case "Green": currentColor = "Yellow"; break;
                case "Yellow": currentColor = "Red"; break;
                default: currentColor = "Green";
            }
        }
        return currentColor;
    }

    /**
     * Stretch Goal 1: return an ArrayList with all cumulative light changes.
     * @param lightColor the starting color
     * @param ticks the number of ticks to simulate
     */

    static ArrayList<String> createCycleLog(String lightColor, int ticks){

        ArrayList<String> tickHist = new ArrayList<String>();

        if (!lightColor.equals("Green") && !lightColor.equals("Yellow") && !lightColor.equals("Red")){
            tickHist.add("Color " + lightColor + " is not recognized");
            return tickHist;
        }
        else if (ticks < 0){
            tickHist.add("Invalid: negative ticks not allowed");
            return tickHist;
        }
        // We don't bother with the modulo trick here because we have to append all intermediate steps to the array anyways, so it doesn't save any time.

        String currentColor = lightColor;
        for (int i = 0; i < ticks; i++){
            switch(currentColor){
                case "Green": currentColor = "Yellow"; break;
                case "Yellow": currentColor = "Red"; break;
                default: currentColor = "Green";
            }
            tickHist.add(currentColor);
        }
        return tickHist;
    }


    /**
     * Stretch Goal 2. The lights last for differing tick lengths now, however we can still skip most of the work.
     * @param lightColor the starting color
     * @param ticks the number of ticks to simulate
     */
    static String simulateLightVar(String lightColor, int ticks){

        // Assume Green lasts 3 ticks, Yellow lasts 1 tick, and Red lasts 2 ticks. It's not mentioned that it should be a parameter, so I'm just hardcoding the example values;

        if (!lightColor.equals("Green") && !lightColor.equals("Yellow") && !lightColor.equals("Red")){
            return "Color " + lightColor + " is not recognized";
        }
        else if (ticks < 0){
            return "Invalid: negative ticks not allowed";
        }

        // Why 6?
        // In our current scheme, a cycle is now 6 ticks long - 3 green, 1 yellow, 2 red. Thus a light that changes to red at tick 1 will change to red at ticks 7, 13, etc.
        ticks = ticks % 6;

        String currentColor = lightColor;
        int i = 0;
        while (true){

            // one difference between this and previous implementations: we move up the tick count per light before we check whether the change would happen after the alloted number of ticks
            switch(currentColor){
                case "Green": i += 3; break;
                case "Yellow": i++; break;
                default: i += 2;
            }

            if (i > ticks){
                break;
            }

            switch(currentColor){
                case "Green": currentColor = "Yellow"; break;
                case "Yellow": currentColor = "Red"; break;
                default: currentColor = "Green";
            }

        }

        return currentColor;
    }

    /**
     * Stretch Goal 3. Throw exceptions instead of returning failure strings
     * @param lightColor the starting color
     * @param ticks the number of ticks to simulate
     */
    static String simulateLightWithException(String lightColor, int ticks) throws InputMismatchException, IllegalArgumentException{
        if (!lightColor.equals("Green") && !lightColor.equals("Yellow") && !lightColor.equals("Red")){
            // This maybe should be an illegal argument exception, but since we're supposed to throw two different exceptions InputMismatch is the 2nd best.
            throw new InputMismatchException();
        }
        else if (ticks < 0){
            // Java standard exception for when the argument passed is of the right type but wrong value
            throw new IllegalArgumentException();
        }

        ticks = ticks % 3;
        String currentColor = lightColor;
        for (int i = 0; i < ticks; i++){
            switch(currentColor){
                case "Green": currentColor = "Yellow"; break;
                case "Yellow": currentColor = "Red"; break;
                default: currentColor = "Green";
            }
        }
        return currentColor;
    }

    public static void main(String[] args){
        System.out.println(simulateLight("Green", 3)); // Output: Green
        System.out.println(simulateLight("Yellow", 5)); // Output: Green
        System.out.println(simulateLight("Purple", 1)); // Output: Color Purple is not recognized
        System.out.println(simulateLight("Red", 0)); // Output: Red
        System.out.println(simulateLight("Yellow", -1)); // Output: Invalid: negative ticks not allowed
        System.out.println(simulateLight("Green", 10000)); // Output: Yellow
    }
}
