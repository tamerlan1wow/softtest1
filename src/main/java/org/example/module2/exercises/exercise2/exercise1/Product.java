package org.example.module2.exercises.exercise2.exercise1;

public class Product {
    private int id;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(int id, String name, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void reduceStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Reduction amount must be positive");
        }
        if (quantity > stockQuantity) {
            throw new IllegalArgumentException("Cannot reduce stockQuantity below 0");
        }
        stockQuantity -= quantity;
    }

    public void increaseStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Increasing amount must be positive");
        }
        if (quantity >= 100) {
            throw new IllegalArgumentException("Increasing amount must not be more than 100");
        }
        stockQuantity += quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock quantity=" + stockQuantity +
                '}';
    }
}

