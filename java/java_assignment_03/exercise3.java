import java.util.*;
public class exercise3 {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Green", 5);
        hm.put("Yellow", 2);
        hm.put("Red", 3);
        System.out.println(trafficLight("Red", 5));
    }
    public static String trafficLight(String start_color, int ticks) {
        if (ticks < 0) {
            throw new IllegalArgumentException("Ticks must be positive");
        }
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Red");
        switch (start_color) {
            case "Red":
                return colors.get((2 + ticks) % 3);
            case "Yellow":
                return colors.get((1 + ticks) % 3);
            case "Green":
                return colors.get(ticks % 3);
            default:
                return "The color must be yellow, green, or red.";
        }
    }
    public static String[] stretchGoal1(String start_color, int ticks) {
        if (ticks < 0) {
            throw new IllegalArgumentException("Ticks cannot be zero.");
        }
        String[] ret = new String[ticks];
        String[] colors = {"Green", "Yellow", "Red"};
        switch (start_color) {
            case "Red":
                for (int i = 0; i < ticks; i++) {
                    ret[i] = colors[i % 3];
                }
                return ret;
            case "Yellow":
                for (int i = 0; i < ticks; i++) {
                    ret[i] = colors[(2 + i) % 3];
                }
                return ret;
            case "Green":
                for (int i = 0; i < ticks; i++) {
                    ret[i] = colors[(1 + i) % 3];
                }
                return ret;
            default:
                throw new IllegalArgumentException("Your starting color must be red, green, or yellow");
        }
    }
    public static String stretchGoal2(HashMap<String, Integer> colorToDuration, String start_color, int ticks) {
        if (ticks < 0) {
            throw new IllegalArgumentException("Ticks must be positive");
        }
        ArrayList<String> colors = new ArrayList<>();
        for (int i = 0; i < colorToDuration.get("Green"); i++) {
            colors.add("Green");
        }
        for (int i = 0; i < colorToDuration.get("Yellow"); i++) {
            colors.add("Yellow");
        }
        for (int i = 0; i < colorToDuration.get("Red"); i++) {
            colors.add("Red");
        }
        switch (start_color) {
            case "Red":
                return colors.get((colorToDuration.get("Yellow") + ticks) % 3);
            case "Yellow":
                return colors.get((colorToDuration.get("Green") + ticks) % 3);
            case "Green":
                return colors.get((colorToDuration.get("Red") + ticks) % 3);
            default:
                return "The color must be yellow, green, or red.";
        }
    }
    public static String stretchGoal3(String start_color, int ticks) {
        if (ticks < 0) {
            throw new ArithmeticException("Ticks must be positive");
        }
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Red");
        switch (start_color) {
            case "Red":
                return colors.get((2 + ticks) % 3);
            case "Yellow":
                return colors.get((1 + ticks) % 3);
            case "Green":
                return colors.get(ticks % 3);
            default:
                throw new IllegalArgumentException("Color must be Red, Green, or Yellow.");
        }
    }
}
