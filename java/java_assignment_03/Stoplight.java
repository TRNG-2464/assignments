import java.util.Arrays;
import java.util.NoSuchElementException;

public class Stoplight {

    public String transitionAtLight(String color, int ticks) {
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        int startingColor;

        switch (color) {
            case "Green":
                startingColor = 0;
                break;
            case "Yellow":
                startingColor = 1;
                break;
            case "Red":
                startingColor = 2;
                break;
            default:
                return "Invalid input: '" + color + "' is not a recognized light color.";
        }

        switch ((startingColor + ticks) % 3) {
            case 0:
                return "Green";
            case 1:
                return "Yellow";
            case 2:
                return "Red";
            default:
                return "Unexpected error.";
        }
    }

    // Stretch Goal 1: return every color reached after each tick.
    public String[] transitionAtLightArray(String color, int ticks) {
        if (ticks < 0) {
            return new String[]{"Invalid input: tick count cannot be negative."};
        }

        int startingColor;

        switch (color) {
            case "Green":
                startingColor = 0;
                break;
            case "Yellow":
                startingColor = 1;
                break;
            case "Red":
                startingColor = 2;
                break;
            default:
                return new String[]{"Invalid input: '" + color + "' is not a recognized light color."};
        }

        String[] answer = new String[ticks];

        for (int i = 0; i < ticks; i++) {
            int nextColorIndex = (startingColor + i + 1) % 3;

            switch (nextColorIndex) {
                case 0:
                    answer[i] = "Green";
                    break;
                case 1:
                    answer[i] = "Yellow";
                    break;
                case 2:
                    answer[i] = "Red";
                    break;
                default:
                    answer[i] = "Unexpected error.";
            }
        }

        return answer;
    }

    // Stretch Goal 2: Green lasts 3 ticks, Yellow 1 tick, and Red 2 ticks.
    public String diffLightDurations(String color, int ticks) {
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        int startingPosition;

        switch (color) {
            case "Green":
                startingPosition = 0;
                break;
            case "Yellow":
                startingPosition = 3;
                break;
            case "Red":
                startingPosition = 4;
                break;
            default:
                return "Invalid input: '" + color + "' is not a recognized light color.";
        }

        switch ((startingPosition + ticks) % 6) {
            case 0:
            case 1:
            case 2:
                return "Green";
            case 3:
                return "Yellow";
            case 4:
            case 5:
                return "Red";
            default:
                return "Unexpected error.";
        }
    }

    // Stretch Goal 3: invalid inputs throw two different exception types.
    public String transitionAtLightWithExceptions(String color, int ticks) {
        if (ticks < 0) {
            throw new IllegalArgumentException("Tick count cannot be negative.");
        }

        int startingColor;

        switch (color) {
            case "Green":
                startingColor = 0;
                break;
            case "Yellow":
                startingColor = 1;
                break;
            case "Red":
                startingColor = 2;
                break;
            default:
                throw new NoSuchElementException("'" + color + "' is not a recognized light color.");
        }

        switch ((startingColor + ticks) % 3) {
            case 0:
                return "Green";
            case 1:
                return "Yellow";
            case 2:
                return "Red";
            default:
                throw new IllegalStateException("Unexpected transition state.");
        }
    }

    public static void main(String[] args) {
        Stoplight stoplight = new Stoplight();

        System.out.println("Base requirements:");
        System.out.println(stoplight.transitionAtLight("Green", 1));
        System.out.println(stoplight.transitionAtLight("Green", 3));
        System.out.println(stoplight.transitionAtLight("Red", 5));
        System.out.println(stoplight.transitionAtLight("Green", 0));
        System.out.println(stoplight.transitionAtLight("Purple", 2));
        System.out.println(stoplight.transitionAtLight("Green", -3));

        System.out.println("\nStretch Goal 1:");
        System.out.println(Arrays.toString(
                stoplight.transitionAtLightArray("Green", 4)
        ));
        System.out.println(Arrays.toString(
                stoplight.transitionAtLightArray("Purple", 2)
        ));
        System.out.println(Arrays.toString(
                stoplight.transitionAtLightArray("Green", -2)
        ));

        System.out.println("\nStretch Goal 2:");
        System.out.println(stoplight.diffLightDurations("Green", 0));
        System.out.println(stoplight.diffLightDurations("Green", 3));
        System.out.println(stoplight.diffLightDurations("Yellow", 1));
        System.out.println(stoplight.diffLightDurations("Red", 2));

        System.out.println("\nStretch Goal 3:");

        try {
            System.out.println(
                    stoplight.transitionAtLightWithExceptions("Purple", 2)
            );
        } catch (NoSuchElementException e) {
            System.out.println("Color error: " + e.getMessage());
        }

        try {
            System.out.println(
                    stoplight.transitionAtLightWithExceptions("Green", -1)
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Tick error: " + e.getMessage());
        }
    }
}
