package org.example.module2.exercises.exercise2.exercise2;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    public void applyDiscount_validDiscount_updatesTotalAmountCorrectly() {

        Order order = new Order(1, 100.0, 100.0, 100.0);
        order.applyDiscount(20.0);
        assertEquals(80.0, order.getTotalAmount(),
                () -> "Total amount should be 80 after applying a discount of 20.");
    }

    @Test
    public void applyDiscount_negativeDiscount_throwsException() {
        Order order = new Order(1, 100.0, 0.0, 0.0);
        assertThrows(IllegalArgumentException.class, () -> {
            order.applyDiscount(-10.0);
        }, "An IllegalArgumentException should be thrown when an invalid discount is attempted.");
    }

    @Test
    public void applyDiscount_discountExceedsTotalAmount_throwsException() {
        Order order = new Order(1, 50.0, 0.0, 0.0);
        assertThrows(IllegalArgumentException.class,
                () -> order.applyDiscount(80.0),
                "An IllegalArgumentException should be thrown when discount exceeds total amount.");
    }

    @Test
    public void applyTax() {
        Order order = new Order(1, 100.0, 10.0, 0.0);
        order.applyTax(10.0);
        assertEquals(90.0, order.getTotalAmount(),
                () -> "Total amount should be 90 after taxes.");
    }

    @Test
    public void addItem() {
        Order order = new Order(1, 700.0, 0.0, 0.0);
        order.addItem(100.0);
        assertEquals(800.0, order.getTotalAmount(),
                () -> "Total amount should be 800 after adding 100 to 700.");
    }

    @Test
    public void removeItem() {
        Order order = new Order(1, 700.0, 0.0, 0.0);
        order.removeItem(100.0);
        assertEquals(600.0, order.getTotalAmount(),
                () -> "Total amount should be 600 after subtracting 100 from 700.");
    }
}
