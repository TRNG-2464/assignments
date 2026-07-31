class Sample{

}
public class VendingMachine {

    String transaction (double itemPrice, double insertedAmount){
        if (itemPrice < 0){
            return "The item costs a negative amount, I'm not gonna pay you to take this item. Please enter a positive amount for the price of item.";
        } else if (insertedAmount < 0){
            return "The inserted amount is in negative, you can't take money out of me for free! Please enter a positive amount for the money inserted. ";
        } else if ( itemPrice > insertedAmount){
            return "You're  actually short " + (itemPrice - insertedAmount);
        } else if ( insertedAmount >= itemPrice){
            return "Purchase Successful! You're owed $" + (insertedAmount - itemPrice);
        }
        return "Gotcha, I'm actually a catch all if you have some kind of error!";
    }

    // Stretch goal 1
    String transaction(double insertedAmount, double[] itemPrices){
        double totalCost = 0;

        for (double itemPrice: itemPrices){
            totalCost += itemPrice;
        }
        if (totalCost < 0){
            return "The item costs a negative amount, I'm not gonna pay you to take this item. Please enter a positive amount for the price of item.";
        } else if (insertedAmount < 0){
            return "The inserted amount is in negative, you can't take money out of me for free! Please enter a positive amount for the money inserted. ";
        } else if ( totalCost > insertedAmount){
            return "You're  actually short " + (totalCost - insertedAmount);
        } else if ( insertedAmount >= totalCost){
            return "Purchase Successful! You're owed $" + (insertedAmount - totalCost);
        }

        return "Gotcha, I'm actually a catch all if you have some kind of error!";
    }

        // Stretch goal 2
    String transactionWithChange (double itemPrice, double insertedAmount){
        if (itemPrice < 0){
            return "The item costs a negative amount, I'm not gonna pay you to take this item. Please enter a positive amount for the price of item.";
        } else if (insertedAmount < 0){
            return "The inserted amount is in negative, you can't take money out of me for free! Please enter a positive amount for the money inserted. ";
        } else if ( itemPrice > insertedAmount){
            return "You're  actually short " + (itemPrice - insertedAmount);
        } else if ( insertedAmount >= itemPrice){
            return "Purchase Successful! You're owed $" + calculateChange(insertedAmount - itemPrice);
        }
        return "Gotcha, I'm actually a catch all if you have some kind of error!";
    }


    static String calculateChange(double change){
        int ones, quarters, dimes, nickels, pennies;

        ones = (int)(change / 1);
        change %= 1;
        quarters = (int)(change/.25);
        change %= 0.25;
        dimes = (int)(change/.10);
        change %= 0.10;
        nickels = (int)(change/.05);
        change %= 0.05;
        pennies = (int)(change/.01);
        
        return "You are owed " + ones + " dollars " + quarters + " quarters " + dimes + " dimes " + nickels + " nickels and " + pennies + " pennies";
    }
    public static void main(String[] args) {
        
    }
}
