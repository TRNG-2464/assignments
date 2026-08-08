
public class App {

    public static void main(String[] args) {
        // Take in an array of ints
        // Secind arg target number

        // Should return the indices of the array that sum together to that target value
      

    }

    public static int[] method(int[] numbers, int target){
        for(int i = 0; i < numbers.length; i++){
            for(int x = 0; x< numbers.length; x++){
                if(numbers[i] + numbers[x] == target){
                    int[] out = new int[2];
                    out[0] = i;
                    out[1] = x;

                    return out;
                }
            }
        }

        return null;
    }
    

}
