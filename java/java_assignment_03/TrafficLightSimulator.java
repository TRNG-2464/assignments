public class TrafficLightSimulator {
    public String getTrafficLight(String startingColorStr, int ticks) {
        // green, yellow, red
        int colorIndex = getColorIndex(startingColorStr);

        if (colorIndex < 0) {
            return String.format("Invalid input: '%s' is not a recognized light color.", startingColorStr);
        }

        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        ticks = (colorIndex + ticks) % 3;

        switch (ticks) {
            case 0:
                return "Green";
            case 1:
                return "Yellow";
            case 2:
                return "Red";
        }

        return "Error: This shouldn't be able to reach here.";
    }

    // Full Cycle Log
    public String[] getFullCycleLog(String startingColorStr, int ticks) {
        String[] result = new String[ticks];
        int colorIndex = getColorIndex(startingColorStr);

        if (colorIndex < 0) {
            return result;
        }

        if (ticks < 0) {
            return result;
        }

        int i = (colorIndex + 1) % 3;
        int writeIndex = 0;
        while (writeIndex < ticks) {
            switch (i) {
                case 0:
                    result[writeIndex] = "Green";
                    break;
                case 1:
                    result[writeIndex] = "Yellow";
                    break;
                case 2:
                    result[writeIndex] = "Red";
                    break;
            }
            i = (i + 1) % 3;
            writeIndex += 1;
        }

        return result;
    }

    private int getColorIndex(String colorStr) {
        int colorIndex;

        switch (colorStr) {
            case "Green":
                colorIndex = 0;
                break;
            case "Yellow":
                colorIndex = 1;
                break;
            case "Red":
                colorIndex = 2;
                break;
            default:
                colorIndex = -1;
        }

        return colorIndex;
    }

    // Variable Duration Lights
    public String getVariableDurationTrafficLight(String startingColorStr, int ticks) {
        int colorIndex;
        //  0  1  2  3  4  5
        // [g, g, g, y, r, r]
        switch (startingColorStr) {
            case "Green":
                colorIndex = 0;
                break;
            case "Yellow":
                colorIndex = 3;
                break;
            case "Red":
                colorIndex = 4;
                break;
            default:
                colorIndex = -1;
        }

        if (colorIndex < 0) {
            return String.format("Invalid input: '%s' is not a recognized light color.", startingColorStr);
        }

        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        ticks = (colorIndex + ticks) % 6;

        // Cant do case 0, 1, 2: (requires Java 14+)
        switch (ticks) {
            case 0:
            case 1:
            case 2:
                return "Green";
            case 3:
                return "Yellow";
            case 4:
            case 5:
                return "Red";
        }

        return "Error: This shouldn't be able to reach here.";
    }

    // Exception Handling for Invalid Input 
    public String getThrowableTrafficLight(String startingColorStr, int ticks) throws Exception {
        // green, yellow, red
        int colorIndex = getColorIndex(startingColorStr);

        if (colorIndex < 0) {
            throw new IllegalArgumentException(String.format("Invalid input: '%s' is not a recognized light color.", startingColorStr));
        }

        if (ticks < 0) {
            throw new IllegalArgumentException("Invalid input: tick count cannot be negative.");
        }

        ticks = (colorIndex + ticks) % 3;

        switch (ticks) {
            case 0:
                return "Green";
            case 1:
                return "Yellow";
            case 2:
                return "Red";
             default:
                throw new IllegalStateException("Unexpected tick value: " + ticks);
        }
    }
}
