package com.mycompany.app;

public class TrafficLightSimulator {

    public static void main(String[] args) {
         // ===== Basic transitions =====
    System.out.println(trafficLightSimulator("Green", 0));
    // Expected: Green

    System.out.println(trafficLightSimulator("Green", 1));
    // Expected: Yellow

    System.out.println(trafficLightSimulator("Green", 2));
    // Expected: Red

    System.out.println(trafficLightSimulator("Green", 3));
    // Expected: Green

    // ===== Starting from Yellow =====
    System.out.println(trafficLightSimulator("Yellow", 0));
    // Expected: Yellow

    System.out.println(trafficLightSimulator("Yellow", 1));
    // Expected: Red

    System.out.println(trafficLightSimulator("Yellow", 2));
    // Expected: Green

    System.out.println(trafficLightSimulator("Yellow", 3));
    // Expected: Yellow

    // ===== Starting from Red =====
    System.out.println(trafficLightSimulator("Red", 0));
    // Expected: Red

    System.out.println(trafficLightSimulator("Red", 1));
    // Expected: Green

    System.out.println(trafficLightSimulator("Red", 2));
    // Expected: Yellow

    System.out.println(trafficLightSimulator("Red", 3));
    // Expected: Red

    // ===== Large tick counts =====
    System.out.println(trafficLightSimulator("Green", 4));
    // Expected: Yellow

    System.out.println(trafficLightSimulator("Green", 5));
    // Expected: Red

    System.out.println(trafficLightSimulator("Green", 6));
    // Expected: Green

    System.out.println(trafficLightSimulator("Red", 10));
    // Expected: Yellow

    System.out.println(trafficLightSimulator("Yellow", 100));
    // Expected: Green

    System.out.println(trafficLightSimulator("Green", 1000));
    // Expected: Yellow

    // ===== Invalid colors =====
    System.out.println(trafficLightSimulator("Purple", 2));
    // Expected: Invalid input

    System.out.println(trafficLightSimulator("Blue", 5));
    // Expected: Invalid input

    System.out.println(trafficLightSimulator("", 1));
    // Expected: Invalid input

    System.out.println(trafficLightSimulator("green", 1));
    // Expected: Invalid input (case-sensitive)

    System.out.println(trafficLightSimulator("GREEN", 1));
    // Expected: Invalid input

    // ===== Negative ticks =====
    System.out.println(trafficLightSimulator("Green", -1));
    // Expected: Invalid input

    System.out.println(trafficLightSimulator("Yellow", -10));
    // Expected: Invalid input

    System.out.println(trafficLightSimulator("Red", -100));
    // Expected: Invalid input

    // ===== Both inputs invalid =====
    System.out.println(trafficLightSimulator("Purple", -5));
    // Expected: Invalid input
    }

    public static String trafficLightSimulator(String starting_light, int ticks) {
        // Handle negative ticks
        if(ticks < 0){
            return "Invalid input: tick count cannot be negative";
        }
        // Get initial tick
        // int starting_pos = -1;
        // for (int i = 0; i < lights.length; i++) {
        //     if (starting_light.equals(lights[i])) {
        //         starting_pos = i;
        //     }
        // }

        // // Handle invalid light input
        // if (starting_pos < 0) {
        //     return String.format("Invalid input: %s is not a recognized color", starting_light);
        // }

        int starting_pos = 0;
        switch (starting_light) {
            case "Green":
                starting_pos = 0;
                break;
            case "Yellow":
                starting_pos = 1;
                break;
            case "Red":
                starting_pos = 2;
                break;
            default:
                return String.format("Invalid input: %s is not a recognized color", starting_light);
        }

        String[] lights = {"Green", "Yellow", "Red"};

        // Return the advanced light by tick
        return lights[(starting_pos+ticks) % 3];

    }
}