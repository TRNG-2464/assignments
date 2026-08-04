import java.util.Scanner;

public class TrafficLightSimulator {

    public static String getLightColor(String startColor, int ticks) {

        // Check for a negative tick count
        if (ticks < 0) {
            return "Invalid input: tick count cannot be negative.";
        }

        // Check whether the starting color is valid
        switch (startColor) {
            case "Green":
            case "Yellow":
            case "Red":
                break;

            default:
                return "Invalid input: '" + startColor
                        + "' is not a recognized light color.";
        }

        // Only the remainder matters because the cycle has 3 colors
        int remainingTicks = ticks % 3;

        String currentColor = startColor;

        // Advance through the cycle
        for (int i = 0; i < remainingTicks; i++) {

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

        Scanner scanner = new Scanner(System.in);

        System.out.print(
                "Enter the starting light color (Green, Yellow, or Red): "
        );

        String startColor = scanner.nextLine();

        System.out.print("Enter the number of ticks: ");
        int ticks = scanner.nextInt();

        System.out.println();
        System.out.println(
                "Light color after " + ticks + " tick(s): "
                        + getLightColor(startColor, ticks)
        );

        scanner.close();
    }
}
