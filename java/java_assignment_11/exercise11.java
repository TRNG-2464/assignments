package exercise11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class exercise11 {
    public static void main(String[] args) {
        int[] input = {4, 6};
        System.out.println(stretch3(input, 5, false));
    }
    public static int closest(int[] nums, int target) {
        double smallest = Double.POSITIVE_INFINITY;;
        double smallestDiff = Double.POSITIVE_INFINITY;
        for (int i = 0; i < nums.length; i++) {
            int diff = Math.abs(nums[i] - target);
            if (diff < smallestDiff) {
                smallestDiff = diff;
                smallest = nums[i];
            } else if (diff == smallestDiff) {
                smallest = Math.min(smallest, nums[i]);
            }
        }
        if (smallest == Double.POSITIVE_INFINITY) {
            return -1;
        }
        return (int) smallest;
    }
    public static ArrayList<Integer> stretch1(int[] nums, int target, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        HashMap<Integer, PriorityQueue<Integer>> diffToInt = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int diff;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            PriorityQueue<Integer> lst = new PriorityQueue<>();
            if (diffToInt.keySet().contains(diff)) {
                lst = diffToInt.get(diff);
            }
            lst.add(nums[i]);
            diffToInt.put(diff, lst);
            pq.add(diff);
        }
        while (ret.size() < k) {
            int nxt = pq.poll();
            PriorityQueue<Integer> options = diffToInt.get(nxt);
            while (!options.isEmpty() && ret.size() < k) {
                ret.add(options.poll());
            }
        }
        return ret;
    }
    public static int stretch2(int[] nums, int target) {
        double biggest = Double.NEGATIVE_INFINITY;;
        double biggestDiff = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < nums.length; i++) {
            int diff = Math.abs(nums[i] - target);
            if (diff > biggestDiff) {
                biggestDiff = diff;
                biggest = nums[i];
            } else if (diff == biggestDiff) {
                biggest = Math.min(biggest, nums[i]);
            }
        }
        if (biggest == Double.NEGATIVE_INFINITY) {
            return -1;
        }
        return (int) biggest;
    }
    public static int stretch3(int[] nums, int target, boolean lower) {
        double smallest = Double.POSITIVE_INFINITY;;
        double smallestDiff = Double.POSITIVE_INFINITY;
        for (int i = 0; i < nums.length; i++) {
            int diff = Math.abs(nums[i] - target);
            if (diff < smallestDiff) {
                smallestDiff = diff;
                smallest = nums[i];
            } else if (diff == smallestDiff) {
                if (lower) {
                    smallest = Math.min(smallest, nums[i]);
                } else {
                    smallest = Math.max(smallest, nums[i]);
                }
            }
        }
        if (smallest == Double.POSITIVE_INFINITY) {
            return -1;
        }
        return (int) smallest;
    }
}
