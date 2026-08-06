import java.util.*;

public class ClosestValueInArray {

    public static void main(String[] args) {
        int[] arr1 = {4, 9, 1, 15, 8};

        // Examples from the prompt
        System.out.println(findClosest(arr1, 10)); // Output: 9
        System.out.println(findClosest(arr1, 2));  // Output: 1
        System.out.println(findClosest(new int[]{5, 15}, 10)); // Output: 5
        System.out.println(findClosest(new int[]{}, 10)); // Output: -1

        // Stretch Goal 1: Closest K Values
        System.out.println(Arrays.toString(findKClosest(arr1, 10, 3))); // Output: [9, 8, 15] or [9, 8, 11/4]

        // Stretch Goal 2: Find Farthest Match
        System.out.println(findFarthest(arr1, 10)); // Output: 1

        // Stretch Goal 3: Higher/Lower Flag
        System.out.println(findClosestWithFlag(new int[]{5, 15}, 10, false)); // Output: 5 (smaller)
        System.out.println(findClosestWithFlag(new int[]{5, 15}, 10, true));  // Output: 15 (larger)
    }

    /**
     * Primary Method: Finds the value in the array closest to the target.
     * Breaks ties by returning the smaller of the two tied values.
     */
    public static int findClosest(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int closest = array[0];
        int minDiff = Math.abs(array[0] - target);

        for (int i = 1; i < array.length; i++) {
            int currentVal = array[i];
            int currentDiff = Math.abs(currentVal - target);

            // Found a strictly closer value
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                closest = currentVal;
            }
            // Handle tie: if distances are equal, pick the smaller value
            else if (currentDiff == minDiff && currentVal < closest) {
                closest = currentVal;
            }
        }

        return closest;
    }

    /**
     * Stretch Goal 1: Finds the 'k' closest values in the array to the target.
     */
    public static int[] findKClosest(int[] array, int target, int k) {
        if (array == null || array.length == 0 || k <= 0) {
            return new int[0];
        }

        // Cap k at the array length if k is larger than the array size
        k = Math.min(k, array.length);

        // Convert primitive int[] to Integer[] for sorting with custom comparator
        Integer[] boxedArray = Arrays.stream(array).boxed().toArray(Integer[]::new);

        // Sort by distance to target; tie-break by smaller value
        Arrays.sort(boxedArray, (a, b) -> {
            int diffA = Math.abs(a - target);
            int diffB = Math.abs(b - target);

            if (diffA != diffB) {
                return Integer.compare(diffA, diffB);
            }
            return Integer.compare(a, b); // Smaller value wins ties
        });

        // Copy top k elements to result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = boxedArray[i];
        }

        return result;
    }

    /**
     * Stretch Goal 2: Finds the value in the array farthest from the target.
     * Applies the same tie-breaking rule (returns the smaller of two tied values).
     */
    public static int findFarthest(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int farthest = array[0];
        int maxDiff = Math.abs(array[0] - target);

        for (int i = 1; i < array.length; i++) {
            int currentVal = array[i];
            int currentDiff = Math.abs(currentVal - target);

            // Found a strictly farther value
            if (currentDiff > maxDiff) {
                maxDiff = currentDiff;
                farthest = currentVal;
            }
            // Handle tie: if distances are equal, pick the smaller value
            else if (currentDiff == maxDiff && currentVal < farthest) {
                farthest = currentVal;
            }
        }

        return farthest;
    }

    /**
     * Stretch Goal 3: Flag controls tie-breaking:
     * favorLarger = false -> return smaller of tied values
     * favorLarger = true  -> return larger of tied values
     */
    public static int findClosestWithFlag(int[] array, int target, boolean favorLarger) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int closest = array[0];
        int minDiff = Math.abs(array[0] - target);

        for (int i = 1; i < array.length; i++) {
            int currentVal = array[i];
            int currentDiff = Math.abs(currentVal - target);

            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                closest = currentVal;
            }
            else if (currentDiff == minDiff) {
                if (favorLarger && currentVal > closest) {
                    closest = currentVal;
                } else if (!favorLarger && currentVal < closest) {
                    closest = currentVal;
                }
            }
        }

        return closest;
    }
}