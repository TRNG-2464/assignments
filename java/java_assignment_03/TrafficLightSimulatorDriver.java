import java.util.Arrays;

public class TrafficLightSimulatorDriver {
    public static void main(String[] args) {
        TrafficLightSimulator t = new TrafficLightSimulator();
        System.out.println(t.getTrafficLight("Green", 1));
        System.out.println(t.getTrafficLight("Green", 3));
        System.out.println(t.getTrafficLight("Red", 5));
        System.out.println(t.getTrafficLight("Green", 0));
        System.out.println(t.getTrafficLight("Purple", 2));
        System.out.println(t.getTrafficLight("Green", -3));
        System.out.println(Arrays.toString(t.getFullCycleLog("Green", 4)));
        System.out.println(t.getVariableDurationTrafficLight("Green", 3));
        System.out.println(t.getVariableDurationTrafficLight("Yellow", 1));

        try {
            // System.out.println(t.getThrowableTrafficLight("Purple", 4));
            System.out.println(t.getThrowableTrafficLight("Green", -1));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Some Exception: " + e.getMessage());
        }
    }
}
