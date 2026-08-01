public class asgn_03 {
    public static void main(String[] args) {
        String startColor = args[0];
        int ticks = Integer.parseInt(args[1]);
        System.out.println(simulateTrafficLight(startColor, ticks));
    }

    public static String nextColor(String color) {
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

    public static String simulateTrafficLight(String startColor, int ticks) {
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        if (!startColor.equals("Green") && !startColor.equals("Yellow") && !startColor.equals("Red")) {
            return "Invalid input: '" + startColor + "' is not a recognized light color.";
        }

        String color = startColor;
        int steps = ticks % 3;
        for (int i = 0; i < steps; i++) {
            color = nextColor(color);
        }
        return color;
    }


}
