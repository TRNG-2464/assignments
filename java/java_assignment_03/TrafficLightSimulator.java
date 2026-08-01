import java.util.Scanner;

public class TrafficLightSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        
        System.out.print("Enter starting color: ");
        String startColor = sc.nextLine().toLowerCase().trim();

        System.out.print("Enter tick number: ");
        int ticks = sc.nextInt();

        System.out.println();
        System.out.println("Input: startColor = \"" + startColor + "\", ticks = " + ticks);

        changeLightColor(startColor, ticks);

        sc.close();
        System.out.println();
    }

    public static void changeLightColor(String color, int tickNum) {
        if (tickNum < 0) {
            System.out.println("Invalid input: tick count cannot be negative!");
            System.exit(0);
        }
        switch(color) {
            case "green":
                if (tickNum > 0) {
                    color = "yellow";
                    tickNum--;
                    System.out.println("Currently at green");
                    changeLightColor(color, tickNum);
                } else {
                    System.out.println("Output: " + color);
                }
                break;
            case "yellow":
                if (tickNum > 0) {
                    color = "red";
                    tickNum--;
                    System.out.println("Currently at yellow");
                    changeLightColor(color, tickNum);
                } else {
                    System.out.println("Output: " + color);
                }
                break;
            case "red":
                if (tickNum > 0) {
                    color = "green";
                    tickNum--;
                    System.out.println("Currently at red");
                    changeLightColor(color, tickNum);
                } else {
                    System.out.println("Output: " + color);
                }
                break;
            default:
                System.out.println("Invalid input: '" + color + "' is not a recognized light color.");
                break;
        }
    }
}
