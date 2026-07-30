public class TrafficLightSimulator {
    public static void main(String[] args) {
        try {
            System.out.println(trafficsLightSim("Green", 1));   // Yellow
            System.out.println(trafficsLightSim("Red", 5));      // Yellow
            System.out.println(trafficsLightSim("Purple", 2));   // throws IllegalArgumentException
        } catch (NegativeTicksException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Caught built-in exception: " + e.getMessage());
        }

        // demonstrate stretch goal 1
        String[] log = stretchGoal1("Green", 4);
        for (String color : log) {
            System.out.print(color + " ");
        }
        System.out.println();

        // demonstrate variable duration
        System.out.println(getColorWithVariableDuration("Green", 4));
    }
    public static String trafficsLightSim(String startColor, int ticks) throws NegativeTicksException {
        if (ticks < 0) {
            throw new NegativeTicksException("Invalid input: tick count cannot be negative.");
        }
        if (!startColor.equals("Green") && !startColor.equals("Yellow") && !startColor.equals("Red")) {
            throw new IllegalArgumentException("Invalid input: '" + startColor + "' is not a recognized light color.");
        }
        int effectiveTicks = ticks % 3;
        String currentColor = startColor;
        for (int i = 0; i < effectiveTicks; i++) {
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

    public static String[] stretchGoal1(String startColor, int ticks) {
        if (ticks < 0) {
            throw new IllegalArgumentException("Invalid input: tick count cannot be negative.");
        }
        if (!startColor.equals("Green") && !startColor.equals("Yellow") && !startColor.equals("Red")) {
            throw new IllegalArgumentException("Invalid input: '" + startColor + "' is not a recognized light color.");
        }

        String[] log = new String[ticks];
        String currentColor = startColor;
        for (int i = 0; i < ticks; i++) {
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
            log[i] = currentColor;
        }
        return log;
    }

    public static String getColorWithVariableDuration(String startColor, int ticks) {
        if (ticks < 0) {
            throw new IllegalArgumentException("Invalid input: tick count cannot be negative.");
        }
        if (!startColor.equals("Green") && !startColor.equals("Yellow") && !startColor.equals("Red")) {
            throw new IllegalArgumentException("Invalid input: '" + startColor + "' is not a recognized light color.");
        }

        String currentColor = startColor;
        int duration = getDuration(currentColor);
        int ticksInCurrentColor = 0;

        for (int i = 0; i < ticks; i++) {
            if (ticksInCurrentColor == duration) {
                currentColor = getNextColor(currentColor);
                duration = getDuration(currentColor);
                ticksInCurrentColor = 0;
            }
            ticksInCurrentColor++;
        }

        return currentColor;
    }

    private static int getDuration(String color) {
        switch (color) {
            case "Green":
                return 3;
            case "Yellow":
                return 1;
            case "Red":
                return 2;
            default:
                return 0;
        }
    }

    private static String getNextColor(String color) {
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
}
