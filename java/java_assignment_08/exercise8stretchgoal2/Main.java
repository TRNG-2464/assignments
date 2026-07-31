package exercise8stretch2.exercise8;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        ArrayList<String[]> orders = new ArrayList<>();
        orders.add(new String[]{"Widget", "2", "10", "600", "600", "false"});
        orders.add(new String[]{"cup", "-1", "10", "500", "500", "false"});
        orders.add(new String[]{"board", "20", "5", "1000", "800", "false"});
        orders.add(new String[]{"chair", "1", "10", "50", "50", "true"});
        orders.add(new String[]{"TV", "1", "10", "100", "300", "false"});
        orders.add(new String[]{"Cake", "3", "50", "90", "90", "false"});
        orders.add(new String[]{"Game", "0", "20", "200", "200", "false"});
        orders.add(new String[]{"Camera", "15", "5", "2000", "2000", "false"});

        order_stream(orders);
    }
    public static void order(String name, int quantity, int available_stock, double payment, double cost, boolean payment_expired) throws InvalidQuantityException, OutOfStockException, PaymentExpiredException, PaymentDeclinedException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be greater than 0.");
        }
        else if (quantity > available_stock) {
            throw new OutOfStockException("Quantity exceeds available stock.");
        }
        else if (payment_expired) {
            throw new PaymentExpiredException("Your payment has expired.");
        }
        else if (payment < cost) {
            throw new PaymentDeclinedException("You need to pay more.");
        } else {
            //System.out.println("Order successful! " + quantity + " x " + name + " confirmed.");
        }
    }
    public static void order_stream(ArrayList<String[]> orders) {
        int total_successes = 0;
        int total_failures = 0;
        int payment_declined = 0;
        int payment_expired = 0;
        int out_of_stock = 0;
        int invalid_quantity = 0;
        for (String[] ord : orders) {
            try {
                order(ord[0], Integer.parseInt(ord[1]), Integer.parseInt(ord[2]), Double.parseDouble(ord[3]), Double.parseDouble(ord[4]), Boolean.parseBoolean(ord[5]));
                total_successes += 1;
            }
            catch (InvalidQuantityException e) {
                total_failures += 1;
                invalid_quantity += 1;
                //System.out.println("Invalid quantity: " + e.getMessage());
            }
            catch (OutOfStockException e) {
                total_failures += 1;
                out_of_stock += 1;
                //System.out.println("Stock error: " + e.getMessage());
            }
            catch (PaymentExpiredException e) {
                total_failures += 1;
                payment_expired += 1;
                //System.out.println("Payment error: " + e.getMessage());
            }
            catch (PaymentDeclinedException e) {
                total_failures += 1;
                payment_declined += 1;
                //System.out.println("Payment error: " + e.getMessage());
            }
        }
        System.out.println("Total successes: " + total_successes + "\n Total failures: " + total_failures + "\n Payment declined: " + payment_declined + "\n Payment expired: " + payment_expired + "\n Invalid quantity: " + invalid_quantity + "\n Out of stock: " + out_of_stock);
    }
}
