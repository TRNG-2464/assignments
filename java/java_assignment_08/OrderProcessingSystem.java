import java.util.List;

public class OrderProcessingSystem {
    
    public static void main(String[] args) {
        Order[] orders = {
            new Order("Widget", 5, 2, 50.00, 50.00, false),
            new Order("Widget", -1, 10, 50.00, 50.00, false),
            new Order("Widget", 2, 10, 10.00, 50.00, false),
            new Order("Widget", 2, 10, 50.00, 50.00, true),
            new Order("Widget", 2, 10, 50.00, 50.00, false)
        };

        // try {
        //     simulateOrder(orders[0]);
        //     simulateOrder(orders[1]);
        //     simulateOrder(orders[2]);
        //     simulateOrder(orders[3]);
        //     simulateOrder(orders[4]);
        // } catch (OutOfStockException e) {
        //     System.out.printf(
        //         "Order failed: Out of stock. Requested %d, but only %d available.%n",
        //         e.getRequestedQty(),
        //         e.getAvailableStock()
        //     );
        // } catch (InventoryException e) {
        //     System.out.println(e.getMessage());
        // } catch (PaymentException e) {
        //     System.out.println(e.getMessage());
        // } catch (Exception e) {
        //     System.out.println("Some other error caught: " + e.getMessage());
        // }

        batchProcessingWithSummary(orders);
    }

    public static void simulateOrder(Order order) throws InventoryException, PaymentException {
        if (order.requestedQty <= 0) {
            throw new InvalidQuantityException();
        }

        if (order.requestedQty > order.availableStock) {
            throw new OutOfStockException(order.requestedQty, order.availableStock);
        }

        if (order.paymentAmount < order.orderCost) {
            throw new PaymentDeclinedException();
        }

        if (order.isExpired) {
            throw new PaymentExpiredException();
        }

        System.out.printf("Order successful! %d x %s confirmed.%n", order.requestedQty, order.item);
    }

    
    public static void batchProcessingWithSummary(Order[] orders) {
        int successCount = 0;
        int failCount;
        int outOfStockExceptionCount = 0;
        int invalidQuantityExceptionCount = 0;
        int paymentDeclinedExceptionCount = 0;
        int paymentExpiredExceptionCount = 0;

        for (int i = 0; i < orders.length; i++) {
            try {
                simulateOrder(orders[i]);
                successCount += 1;
            } catch (OutOfStockException e) {
                System.out.printf(
                    "Order failed: Out of stock. Requested %d, but only %d available.%n",
                    e.getRequestedQty(),
                    e.getAvailableStock()
                );
                outOfStockExceptionCount += 1;
            } catch (InvalidQuantityException e) {
                System.out.println(e.getMessage());
                invalidQuantityExceptionCount += 1;
            }  catch (PaymentDeclinedException e) {
                System.out.println(e.getMessage());
                paymentDeclinedExceptionCount += 1;
            } catch (PaymentExpiredException e) {
                System.out.println(e.getMessage());
                paymentExpiredExceptionCount += 1;
            } catch (InventoryException e) {
                System.out.println(e.getMessage());
            } catch (PaymentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Some other error caught: " + e.getMessage());
            }
        }

        failCount = orders.length - successCount;

        System.out.printf("Success: %d%n", successCount);
        System.out.printf("Fail count: %d%n", failCount);
        System.out.printf("OutOfStockException Count: %d%n", outOfStockExceptionCount);
        System.out.printf("InvalidQuantityExceptionCount Count: %d%n", invalidQuantityExceptionCount);
        System.out.printf("PaymentDeclinedExceptionCount Count: %d%n", paymentDeclinedExceptionCount);
        System.out.printf("PaymentExpiredExceptionCount Count: %d%n", paymentExpiredExceptionCount);
    }
}
