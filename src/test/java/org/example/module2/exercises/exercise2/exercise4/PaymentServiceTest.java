package org.example.module2.exercises.exercise2.exercise4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PaymentServiceTest {

    PaymentService service = new PaymentService();


    @Test
    void testValidPaymentMarksPaid() {
        Order order = new Order("1", 100);
        service.processPayment(order, 100);
        assertEquals("PAID", order.getStatus());
    }

    @Test
    void testPaymentLessThanAmountMarksFailed() {
        Order order = new Order("2", 100);
        service.processPayment(order, 50);
        assertEquals("FAILED", order.getStatus());
    }

    @Test
    void testZeroPaymentThrows() {
        Order order = new Order("3", 100);
        assertThrows(IllegalArgumentException.class, () -> service.processPayment(order, 0));
    }

    @Test
    void testNegativePaymentThrows() {
        Order order = new Order("4", 100);
        assertThrows(IllegalArgumentException.class, () -> service.processPayment(order, -10));
    }
}
