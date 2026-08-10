public class ClosestValue {
    public static int closest(int[] inputs, int comparedTo){
        if (inputs.length == 0){
            return -1;
        }
        if (inputs.length == 1){
            return inputs[0];
        }
        int closestToValue = Integer.MAX_VALUE;
        int[] closestValues = new int[2];
        closestValues[0] = inputs[0];

        for (int value: inputs){
            if (Math.abs(value-comparedTo) < closestToValue){
                closestToValue = Math.abs(value-comparedTo);
                closestValues[0] = value;
                closestValues[1] = -1;
            } else if (Math.abs(value-comparedTo) == closestToValue){
                closestValues[1] = value;
            }
        }

        int answer = closestValues[0];

        if ( closestValues[1] != -1 && answer > closestValues[1]) answer = closestValues[1];

        return answer;

    }
    public static void main(String[] args) {
        int[] inputs1 = {1,2,3,4,6,8,9};

        int closest1 = closest(inputs1, 5);

        System.out.println(closest1);

        int[] inputs2 = {};

         int closest2 = closest(inputs2, 5);

        System.out.println(closest2);
        
    }
    
}
