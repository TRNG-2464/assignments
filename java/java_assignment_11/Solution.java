import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        // int[] nums = {4, 9, 1, 15, 8};
        // int target = 10;

        // int[] nums = {4, 9, 1, 15, 8};
        // int target = 2;

        // int[] nums = {5, 15};
        // int target = 10;

        // int[] nums = {};
        // int target = 10;

        // int result = closestValue(nums, target);
        // System.out.println(result);

        // int[] nums = {4, 9, 1, 15, 8};
        // int target = 10;
        // int k = 3;

        int[] nums = {5, 15};
        int target = 10;
        int k = 1;
        int[] result = closestKValues(nums, target, k);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int closestValue(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int closest = nums[0];
        // loop through nums
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(target - nums[i]) == Math.abs(target - closest)) {
                closest = Math.min(closest, nums[i]);
            } else if (Math.abs(target - nums[i]) < Math.abs(target - closest)) {
                closest = nums[i];
            }
        }
        return closest;
    }

    // Stretch goal
    public static int[] closestKValues(int[] nums, int target, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) { // if not tie
                // Larger distance = higher priority (remove first)
                return Integer.compare(b[0], a[0]);
            } else {    // if tie, select smaller second value
                // Larger value = higher priority (remove first)
                return Integer.compare(b[1], a[1]);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            int[] pair = new int[2];
            pair[0] = Math.abs(target - nums[i]);
            pair[1] = nums[i];
            maxHeap.add(pair);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] result = new int[maxHeap.size()];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            result[i] = maxHeap.poll()[1];
            i += 1;
        }

        return result;
    }
}