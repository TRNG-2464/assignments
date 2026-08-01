public class asgn_01 {
    public static void main(String[] args) {
        double price = Double.parseDouble(args[0]);
        double amountInserted = Double.parseDouble(args[1]);
        vending(price, amountInserted);
    }

    public static void vending(double price, double amountInserted) {

        if(price < 0){
            System.out.println( "Invalid input: item price cannot be negative.");
        }
        else if(amountInserted < 0){
            System.out.println("Invalid input: amount inserted cannot be negative.");
        }
        else if(price==amountInserted){
            System.out.println("Purchase successful. Change due: $0.00");
        }
        else if(amountInserted < price){
            double needed = price - amountInserted;
            System.out.println(String.format("Insufficient funds. Please insert $%.2f more.", needed));
        }
        else{
            double change = amountInserted - price;
            System.out.println(String.format("Purchase successful. Change due: $%.2f", change));
        }

    }
}
