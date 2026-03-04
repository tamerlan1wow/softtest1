package org.example.module2.exercises.exercise2.exercise3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    
    @ParameterizedTest
    @CsvSource({
            "1, 1000.0",
            "2, 0.0"
    })
    void constructor_validInput_initializesCorrectly(int orderId, double totalAmount) {
        Order order = new Order(orderId, totalAmount);

        assertAll("Valid order initialization",
                () -> assertEquals(orderId, order.getOrderId(),
                        "Order ID should be initialized correctly"),
                () -> assertEquals(totalAmount, order.getTotalAmount(), 0.001,
                        "Total Amount should be initialized correctly")
        );
    }

    @ParameterizedTest
    @CsvSource({
            "1, -1",
            "2, -100"
    })
    void constructor_negativeAmount_throwsException(int orderId, double totalAmount) {
        assertThrows(IllegalArgumentException.class,
                () -> new Order(orderId, totalAmount),
                "Total amount must be non-negative");
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1000.0, 200.0",
            "2, 500.0, 100.0"
    })
    void applyDiscount_validDiscount_reducesAmount(int orderId, double totalAmount, double discount) {
        Order order = new Order(orderId, totalAmount);

        order.applyDiscount(discount);

        assertEquals(totalAmount - discount, order.getTotalAmount(), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 500.0, 600.0",
            "2, 100.0, 200.0"
    })
    void applyDiscount_exceedsAmount_throwsException(int orderId, double totalAmount, double discount) {
        Order order = new Order(orderId, totalAmount);

        assertThrows(IllegalArgumentException.class,
                () -> order.applyDiscount(discount));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1000.0, 0.1",
            "2, 500.0, 0.2"
    })
    void applyTax_validRate_increasesAmount(int orderId, double totalAmount,double taxRate) {
        Order order = new Order(orderId, totalAmount);

        order.applyTax(taxRate);

        assertEquals(totalAmount * ( 1+ taxRate), order.getTotalAmount(), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 500.0, 200.0",
            "2, 0.0, 100.0"
    })
    void addItem_validPrice_increasesAmount(int orderId, double totalAmount, double price) {
        Order order = new Order(orderId, totalAmount);

        order.addItem(price);

        assertEquals(totalAmount + price, order.getTotalAmount(), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 500.0, 200.0",
            "2, 300.0, 100.0"
    })
    void removeItem_validPrice_decreasesAmount(int orderId, double totalAmount, double price) {
        Order order = new Order(orderId, totalAmount);

        order.removeItem(price);

        assertEquals(totalAmount - price, order.getTotalAmount(), 0.001);
    }
}