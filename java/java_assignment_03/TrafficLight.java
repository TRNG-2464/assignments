
public class TrafficLight {

    public static String getColorAfterTicks(String startColor, int ticks) {
        if (!startColor.equals("Green") && !startColor.equals("Yellow") && !startColor.equals("Red")) {
            return String.format("Invalid input: '%s' is not a recognized light color.", startColor);
        }


        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }


        int effectiveTicks = ticks % 3;

        String currentColor = startColor;
        for (int i = 0; i < effectiveTicks; i++) {
            currentColor = nextColor(currentColor);
        }

        return currentColor;
    }

    private static String nextColor(String color) {
        switch (color) {
            case "Green":
                return "Yellow";
            case "Yellow":
                return "Red";
            case "Red":
                return "Green";
            default:
                return color;
        }
    }

    public static void main(String[] args) {
        System.out.println(getColorAfterTicks("Green", 1));   
        System.out.println(getColorAfterTicks("Green", 3)); 
        System.out.println(getColorAfterTicks("Red", 5));  
        System.out.println(getColorAfterTicks("Green", 0)); 
        System.out.println(getColorAfterTicks("Purple", 2));  
        System.out.println(getColorAfterTicks("Green", -3)); 
    }
}
