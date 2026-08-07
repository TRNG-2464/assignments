public class main {

    static int getClosest(int[] nums, int target) {
        int closest = -1;
        int closestDiff = Integer.MAX_VALUE;
        for (int num : nums) {
            int diff = Math.abs(num - target);
            if (diff < closestDiff) {
                closest = num;
                closestDiff = diff;
            } else if (diff == closestDiff) {
                closest = Math.min(closest, num);
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 9, 1, 15, 8};
        int[] nums2 =  {};
        int target = 10;
        System.out.println(getClosest(nums2, target));
    }
}
