import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Stoplight{
    // For stretch goals
    public static final List<String> lightColors = new ArrayList<>(List.of("Green", "Yellow", "Red"));

    public String transitionAtLight(String color, int ticks){
        if (ticks < 0) {
            return "You can't have negative ticks";
        }
        int startingColor = 0;
        switch (color){
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
                return "Input not recognized";
        }

        switch ((startingColor+ticks)%3){
            case 0:
                return "Green";
            case 1:
                return "Yellow";
            case 2:
                return "Red";
            default:
                return "You have an error";
        }
    }


    // Stretch Goal 1 
    // Errors can happen because there's no handling of negative ticks
    public String[] transitionAtLightArray(String color, int ticks){
        int startingColor = lightColors.indexOf(color);

        String [] answer = new String[ticks];

        for (int i = 0 ; i < ticks; i++){
            answer[i] = lightColors.get((startingColor + i)%3);
        }

        return answer;
    }

    // default Green 3, Yellow 1, Red 2
    public String diffLightDurations(String color, int ticks){
        if (ticks < 0) {
            return "You can't have negative ticks";
        }

        int startingColor = 0;
        switch (color){
            case "Green":
                startingColor = 0;
                break;
            case "Yellow":
                startingColor = 3;
                break;
            case "Red":
                startingColor = 4;
                break;
            default:
                return "Input not recognized";
        }

        switch ((startingColor+ticks)%6){
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
                return "You have an error";
        }
    }

    // stretch goal 3. Handling should happen at wherever the method is going to be called
     public String transitionAtLightWithExceptions(String color, int ticks){
        if (ticks < 0) {
            throw new IllegalArgumentException("Ticks cannot be negative.");
        }
        int startingColor = 0;
        switch (color){
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
                throw new NoSuchElementException("Unknown light color.");
        }

        switch ((startingColor+ticks)%3){
            case 0:
                return "Green";
            case 1:
                return "Yellow";
            case 2:
                return "Red";
            default:
                return "You have an error";
        }
    }
}