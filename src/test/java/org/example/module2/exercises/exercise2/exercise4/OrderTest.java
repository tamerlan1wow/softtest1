package org.example.module2.exercises.exercise2.exercise4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void testOrderInitialization(){
        Order order = new Order("1", 100.0);
        assertEquals("NEW", order.getStatus());
        assertEquals(100.0, order.getAmount());
    }

    @Test
    void testOrderWithZeroAmountThrows(){
        assertThrows(IllegalArgumentException.class, () -> new Order("2", 0));

    }

    @Test
    void testOrderWithNegativeAmountThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Order("3", -50));
    }

    @Test
    void testMarkPaid() {
        Order order = new Order("4", 50);
        order.markPaid();
        assertEquals("PAID", order.getStatus());
    }

    @Test
    void testMarkFailed() {
        Order order = new Order("5", 50);
        order.markFailed();
        assertEquals("FAILED", order.getStatus());
    }
}