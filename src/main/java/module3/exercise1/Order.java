package module3.exercise1;

public class Order {
    private int orderId;
    private double totalAmount;

    public Order(int orderId, double totalAmount) {
        if (totalAmount < 0) {
            throw new IllegalArgumentException("Total amount must be non-negative");
        }
        this.orderId = orderId;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void applyDiscount(int discount) {
        if (discount < 0 || discount > totalAmount) {
            throw new IllegalArgumentException("Discount cannot exceed total amount or be negative");
        }
        totalAmount -= discount;
    }

    public void applyTax(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("Tax rate cannot be negative");
        }
        totalAmount += totalAmount * rate;
    }
}