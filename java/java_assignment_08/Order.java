public class Order {
    String item;
    int requestedQty;
    int availableStock;
    double paymentAmount;
    double orderCost;
    boolean isExpired;

    public Order(String item, int requestedQty, int availableStock, double paymentAmount, double orderCost, boolean isExpired) {
        this.item = item;
        this.requestedQty = requestedQty;
        this.availableStock = availableStock;
        this.paymentAmount = paymentAmount;
        this.orderCost = orderCost;
        this.isExpired = isExpired;
    }
}
