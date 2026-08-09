//package java.java_assignment_11;

public class assignment_11 {
    public static int closestToTarget(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        int closest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - target) < Math.abs(closest - target)) {
                closest = arr[i];
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int target = 6;
        int closest = closestToTarget(arr, target);
        System.out.println(closest);

        int[] arr2 = {4, 9, 1, 15, 8};
        int target2 = 9; 
        System.out.println(closestToTarget(arr2, target2));

        int[] arr3 = {4, 9, 1, 15, 8};
        int target3 = 2;
        System.out.println(closestToTarget(arr3, target3));

        int[] arr4 = {5, 15};
        int target4 = 10;
        System.out.println(closestToTarget(arr4, target4));

        int[] arr5 = {};
        int target5 = 10;
        System.out.println(closestToTarget(arr5, target5));
    }
}
