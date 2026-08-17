public class ClosestValue {

    public static void main(String[] args) {
        System.out.println(closestValue(new int[]{4, 9, 1, 15, 8}, 10));
        System.out.println(closestValue(new int[]{4, 9, 1, 15, 8}, 2));
        System.out.println(closestValue(new int[]{5, 15}, 10));
        System.out.println(closestValue(new int[]{}, 10));
    }

    public static int closestValue(int[] numbers, int target) {
        if (numbers.length == 0) {
            return -1;
        }

        int closest = numbers[0];
        int closestDiff = Math.abs(numbers[0] - target);

        for (int i = 1; i < numbers.length; i++) {
            int diff = Math.abs(numbers[i] - target);

            if (diff < closestDiff || (diff == closestDiff && numbers[i] < closest)) {
                closest = numbers[i];
                closestDiff = diff;
            }
        }

        return closest;
    }
}
