import java.util.Scanner;

public class Main {
    public static int findClosest(int[] numbers, int target) {
        if (numbers.length == 0) {
            return -1;
        }
        int closest = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            int currentDifference = Math.abs(numbers[i] - target);
            int closestDifference = Math.abs(closest - target);
            if (currentDifference < closestDifference) {
                closest = numbers[i];
            } else if (currentDifference == closestDifference
                    && numbers[i] < closest) {
                closest = numbers[i];
            }
        }
        return closest;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {4, 9, 1, 15, 8};
        int target = 25;
        int result = findClosest(numbers, target);
        System.out.println("Closest value: " + result);
        scanner.close();
    }
}