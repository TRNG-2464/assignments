public class TrafficLightSimulator {
    // Method to find the light color after a certain number of ticks
    public static String trafficLight(String startColor, int ticks) {
        // Checkimng for negative ticks
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }
        // this is to makesure the starting color is valid
        if (!startColor.equals("Green") &&
            !startColor.equals("Yellow") &&
            !startColor.equals("Red")) {

            return "Invalid input: '" + startColor + "' is not a recognized light color.";
        }

        // Only need the leftover ticks because the pattern repeats every 3
        int moves = ticks % 3;

        String currentColor = startColor;

        // Move through the cycle one step at a time
        for (int i = 0; i < moves; i++) {

            switch (currentColor) {
                case "Green":
                    currentColor = "Yellow";
                    break;

                case "Yellow":
                    currentColor = "Red";
                    break;

                case "Red":
                    currentColor = "Green";
                    break;
            }
        }

        return currentColor;
    }

    public static void main(String[] args) {
        System.out.println(trafficLight("Green", 1));   // Yellow
        System.out.println(trafficLight("Green", 3));   // Green
        System.out.println(trafficLight("Red", 5));     // Yellow
        System.out.println(trafficLight("Green", 0));   // Green
        System.out.println(trafficLight("Purple", 2));  // Invalid color
        System.out.println(trafficLight("Green", -3));  // Invalid ticks
    }
}