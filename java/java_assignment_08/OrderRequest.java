// Stretch Goal 2: simple holder for a simulated order's inputs, used when
// processing a batch of orders at once.
public class OrderRequest {

    private final String item;
    private final int requestedQuantity;
    private final int availableStock;
    private final double paymentAmount;
    private final double orderCost;
    private final boolean expired;

    public OrderRequest(String item, int requestedQuantity, int availableStock, double paymentAmount, double orderCost, boolean expired) {
        this.item = item;
        this.requestedQuantity = requestedQuantity;
        this.availableStock = availableStock;
        this.paymentAmount = paymentAmount;
        this.orderCost = orderCost;
        this.expired = expired;
    }

    public String getItem() {
        return item;
    }

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public double getOrderCost() {
        return orderCost;
    }

    public boolean isExpired() {
        return expired;
    }
}
