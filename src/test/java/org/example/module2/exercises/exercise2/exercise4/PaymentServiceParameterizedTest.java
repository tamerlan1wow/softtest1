package org.example.module2.exercises.exercise2.exercise4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceParameterizedTest {

    PaymentService service = new PaymentService();

    @ParameterizedTest
    @CsvSource({
            "100.0, 100.0, PAID",
            "100.0, 150.0, PAID",
            "100.0, 99.99, FAILED"
    })
    void testPaymentScenarios(double orderAmount, double paymentAmount, String expectedStatus) {
        Order order = new Order("x", orderAmount);
        service.processPayment(order, paymentAmount);
        assertEquals(expectedStatus, order.getStatus());
    }

    @ParameterizedTest
    @CsvSource({
            "100.0, 0.0",
            "100.0, -10.0"
    })
    void testPaymentExceptions(double orderAmount, double paymentAmount) {
        Order order = new Order("y", orderAmount);
        assertThrows(IllegalArgumentException.class, () -> service.processPayment(order, paymentAmount));
    }
}
