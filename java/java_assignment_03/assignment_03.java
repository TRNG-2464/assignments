//package java.java_assignment_03;

public class assignment_03 {
    public static String trafficSim(String startColor, int ticks){
        if(ticks < 0){
            return "Invalid input: tick count cannot be negative.";
        }
        if(startColor == null || (!startColor.equalsIgnoreCase("red") && !startColor.equalsIgnoreCase("yellow") && !startColor.equalsIgnoreCase("green"))){
            return "Invalid input: '%s' is not a recognized light color.".formatted(startColor);
        }
        String color = "";
        switch(startColor.toLowerCase()){
            case "red":
                if(ticks % 3 == 0){
                    color = "Red";
                    break;
                } else if(ticks % 3 == 1){
                    color = "Green";
                    break;
                } else {
                    color = "Yellow";
                    break;
                }
            case "green":
                if(ticks % 3 == 0){
                    color = "Green";
                    break;
                } else if(ticks % 3 == 1){
                    color = "Yellow";
                    break;
                } else {
                    color = "Red";
                    break;
                }
            case "yellow":
                if(ticks % 3 == 0){
                    color = "Yellow";
                    break;
                } else if(ticks % 3 == 1){
                    color = "Red";
                    break;
                } else {
                    color = "Green";
                    break;
                }
        }
        return color;
    }

    public static void main(String[] args) {
        System.out.println(trafficSim("red", 0)); // red
        System.out.println(trafficSim("red", 1)); // green
        System.out.println(trafficSim("red", 2)); // yellow
        System.out.println(trafficSim("green", 0)); // green
        System.out.println(trafficSim("green", 1)); // yellow
        System.out.println(trafficSim("green", 2)); // red
        System.out.println(trafficSim("yellow", 0)); // yellow
        System.out.println(trafficSim("yellow", 1)); // red
        System.out.println(trafficSim("yellow", 2)); // green
        System.out.println(trafficSim("blue", 1)); // Invalid input: 'blue' is not a recognized light color.
        System.out.println(trafficSim("red", -1)); // Invalid input: tick count cannot be negative.
    }
}
