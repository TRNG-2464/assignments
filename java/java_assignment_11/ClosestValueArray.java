import java.util.Scanner;

public class ClosestValueArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter integer array: ");
        String intString = sc.nextLine();
        System.out.print("Enter target number: ");
        int target = sc.nextInt();

        int[] nums; 
        
        if (!intString.startsWith("[") || !intString.endsWith("]")) { 
            System.out.println("Invalid input. Array must start with [ and end with ]."); 
            sc.close(); 
            return; 
        } 

        String contents = intString.substring(1, intString.length() - 1).trim(); 

        if (contents.isEmpty()) { 
            nums = new int[0]; 
        } else { 
            String[] values = contents.split(","); 
            nums = new int[values.length]; 
            for (int i = 0; i < values.length; i++) { 
                nums[i] = Integer.parseInt(values[i].trim()); 
            } 
        }

        System.out.println(findClosestValue(nums, target));
        
        sc.close();
    }

    public static int findClosestValue(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int closest = array[0];
        int smallestDifference = Math.abs(array[0] - target);

        for (int i = 1; i < array.length; i++) {
            int currentDifference = Math.abs(array[i] - target);

            if (currentDifference < smallestDifference) {
                closest = array[i];
                smallestDifference = currentDifference;
            } else if (currentDifference == smallestDifference && array[i] < closest) {
                closest = array[i];
            }
        }

        return closest;
    }
}
