//package java.java_assignment_01;

public class assignment_01 {

    public static String changeMaker(double price, double paid) {
        if( price < 0 || paid < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }
        else if (paid < price) {
            return "Insufficient funds. Please insert %.2f more.".formatted(price - paid);
        }
        else{
            return "Purchase successful. Change due: %.2f".formatted(paid - price);
        }
    }

    public static void main(String[] args) {
        System.out.println(changeMaker(10.0, 5.0));
        System.out.println(changeMaker(10.0, 15.0));
        System.out.println(changeMaker(10.0, 10.0));
        System.out.println(changeMaker(-10.0, 5.0));
    }
}