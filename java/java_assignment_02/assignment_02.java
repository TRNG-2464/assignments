//package java.java_assignment_02;

public class assignment_02 {
    public static String weightChecker(int limit, int[] passengers) {
        if(passengers == null || passengers.length == 0) {
            return "No passengers to check.";
        }
        int counter = 0;
        for(int i = 0; i < passengers.length; i++) {
            counter += passengers[i];
            if(counter >= limit) {
                return "Passenger %d caused an overload. Total weight at that point: %d lbs.".formatted(i + 1, counter);
            }
        }
        return "All passengers boarded safely. Total weight: %d lbs.".formatted(counter);
    }

    public static void main(String[] args) {
        int[] passengers1 = {150, 200, 180, 220};
        int[] passengers2 = {100, 120, 130};
        int[] passengers3 = {300, 400, 500};
        int[] passengers4 = {};
        int[] passengers5 = {300};

        System.out.println(weightChecker(700, passengers1));
        System.out.println(weightChecker(400, passengers2));
        System.out.println(weightChecker(1000, passengers3));
        System.out.println(weightChecker(500, passengers4));
        System.out.println(weightChecker(250, passengers5));
    }
}
