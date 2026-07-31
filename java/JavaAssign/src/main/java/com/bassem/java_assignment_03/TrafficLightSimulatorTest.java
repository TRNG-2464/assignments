
package com.bassem.java_assignment_03;
public class TrafficLightSimulatorTest {
    public static void main(String[] args) {

        System.out.println("Single tick :");
        String light = TrafficLightSimulator.simulateTraffic("Green", 1);
        System.out.println(light);

        System.out.println("Full cycle returns to same color:");

        light = TrafficLightSimulator.simulateTraffic("Green", 3);

        System.out.println(light);

        System.out.println("Multiple cycles plus remainder:");

        light = TrafficLightSimulator.simulateTraffic("Red", 5);

        System.out.println(light);

        System.out.println("Zero ticks:");

        light = TrafficLightSimulator.simulateTraffic("Green", 0);

        System.out.println(light);

        System.out.println("Invalid color:");

        light = TrafficLightSimulator.simulateTraffic("Purple", 2);

        System.out.println(light);

        System.out.println("Negative ticks:");

        light = TrafficLightSimulator.simulateTraffic("Green", -3);

        System.out.println(light);




    }
}
