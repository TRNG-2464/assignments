package java_assignment_11;
public class ClosestValue {

    public static int findClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int closest = numbers[0];
        int bestDistance = Math.abs(numbers[0] - target);

        for (int i = 1; i < numbers.length; i++) {
            int distance = Math.abs(numbers[i] - target);
            if (distance < bestDistance || (distance == bestDistance && numbers[i] < closest)) {
                closest = numbers[i];
                bestDistance = distance;
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        System.out.println(findClosest(new int[]{4, 9, 1, 15, 8}, 10)); 
        System.out.println(findClosest(new int[]{4, 9, 1, 15, 8}, 2));  
        System.out.println(findClosest(new int[]{5, 15}, 10));          
        System.out.println(findClosest(new int[]{}, 10));             
    }
}