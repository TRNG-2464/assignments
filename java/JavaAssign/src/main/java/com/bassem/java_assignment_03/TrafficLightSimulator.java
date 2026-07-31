package com.bassem.java_assignment_03;

public class TrafficLightSimulator {
    public static String simulateTraffic(String startColor,int ticks){

        // check negative

        if(ticks < 0){
                   return " Invalid input";
               }
        // check if the color valid.
                if(!startColor.equals(("Green"))&&
                        !startColor.equals(("Yellow"))&&
                        !startColor.equals(("Red"))){
                    return "invalid input: '" +startColor
                            + "' is not a recognized light color";

                }
                // reduce ticks cycle
           int steps = ticks % 3;

                // move up
        String currentColor = startColor;
        for(int i =0; i < steps; i++ ){

            currentColor = switch (currentColor) {
                case "Green" -> "Yellow";
                case "Yellow" -> "Red";
                case "Red" -> "Green";
                default -> throw new IllegalStateException("Unexpected value: " + currentColor);
            };
        }
        return  currentColor;

    }
}