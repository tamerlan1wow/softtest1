package org.example.module2.exercises.exercise2.exercise2;
//package cc.ku.st.module2;

public class Order {

    private int orderId;
    private double totalAmount;
    private double taxRate;
    private double price;

    public Order(int orderId, double totalAmount, double taxRate, double price) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.taxRate = taxRate;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getTaxRate() { return taxRate; }

    public double getPrice() { return price; }

    public void applyDiscount(double discount) {
        if (discount <= 0) {
            throw new IllegalArgumentException("Discount must be positive");
        }
        if (discount > totalAmount) {
            throw new IllegalArgumentException("Discount cannot exceed total amount");
        }
        totalAmount -= discount;
    }

    public void applyTax(double taxRate) {
        if (taxRate <= 0) {
            throw new IllegalArgumentException("Tax Rate must be positive");
        }
        if (taxRate > totalAmount) {
            throw new IllegalArgumentException("Tax Rate cannot exceed total amount");
        }
        totalAmount *= 0.9;
    }

    public void addItem(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        if (price > totalAmount) {
            throw new IllegalArgumentException("Price cannot exceed total amount");
        }
        totalAmount += price;
    }

    public void removeItem(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        if (price > totalAmount) {
            throw new IllegalArgumentException("Price cannot exceed total amount");
        }
        totalAmount -= price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", total amount=" + totalAmount +
                '}';
    }
}
