public static String vendingMachine(double itemPrice, double money) {
        double moreChange = itemPrice - money;
        double change = money - itemPrice;
        if (money < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }else if(itemPrice < 0){
            return "Invalid price: price cannot be negative.";
        }else if(money<itemPrice){
            return "Insufficient funds. Please insert "+ moreChange+ " more.";
        }
            return "Purchase successful. Change due: $"+change;
    }

    public static String vendingMachine2(double[]itemPrice, double money) {
        double sum = 0;
        for (double number : itemPrice) {
            if (number < 0) {
                return "Invalid input: item price cannot be negative.";
            }
            sum += number;
        }
        double moreChange = sum - money;
        double change = money - sum;
        if (money < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        } else if (money < sum) {
            return "Insufficient funds. Please insert " + moreChange + " more.";
        }
        return "Purchase successful. Change due: $" + change;
    }
    //converts the change Amount to cents by breaking them down using division and mod
    public static String breakChange(double changeAmount){
        int cents = (int) Math.round(changeAmount *100);
        int ones = cents/100;
        cents%=100;
        int quarters = cents/25;
        cents%=25;
        int dimes = cents/10;
        cents%=10;
        int nickels = cents/5;
        int pennies = cents%5;
        cents%=5;
        return " Ones:"+ ones+" Quarters:"+ quarters+ " Dimes:"+dimes+" Nickels:"
                +nickels+" Pennies:"+pennies;
    }