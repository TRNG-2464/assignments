public class StringIterator {
    public static String repeatedCharOccurence(String input){
        if (input.length() == 0){
            return "";
        }
        int count = 1;
        String result = "";

        for (int i = 1; i < input.length(); i++){
            if (input.charAt(i) != input.charAt(i-1)){
                result += input.charAt(i-1);
                result += count;
                count = 1;
            } else{
                count++;
            }
        }

        // if (input.charAt(input.length()-1) == input.charAt(input.length()-2)){
        //     result += input.charAt(input.length()-1);
        //     result += count;
        // } 

        result += input.charAt(input.length()-1);
        result += count;

        return result;
    }
    public static void main(String[] args) {
        System.out.println(repeatedCharOccurence("a"));
        System.out.println(repeatedCharOccurence("aaabbbccd"));
        System.out.println(repeatedCharOccurence("abcc"));
    }
}
