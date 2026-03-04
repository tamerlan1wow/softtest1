package org.example.module2.exercises.exercise2.exercise4;

public class PaymentService {

    public void processPayment(Order order, double paymentAmount) {

        if (paymentAmount <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero.");
        }

        if (paymentAmount >= order.getAmount()) {
            order.markPaid();
        } else {
            order.markFailed();
        }
    }
}