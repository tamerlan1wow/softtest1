package module3.exercise1;

import static org.junit.jupiter.api.Assertions.*;

import module3.exercise1.Order;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void constructor_validInput_initializesCorrectly() {
        Order order = new Order(1, 1000);

        assertAll("Order initialization",
                () -> assertEquals(1, order.getOrderId()),
                () -> assertEquals(1000, order.getTotalAmount(), 0.001)
        );
    }

    @Test
    void constructor_negativeAmount_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Order(1, -1),
                "Total amount must be non-negative");
    }

    @Test
    void applyDiscount_validDiscount_reducesAmount() {
        Order order = new Order(1, 1000);

        order.applyDiscount(200);

        assertEquals(800, order.getTotalAmount(), 0.001);
    }

    @Test
    void applyDiscount_exceedsAmount_throwsException() {
        Order order = new Order(1, 500);

        assertThrows(IllegalArgumentException.class,
                () -> order.applyDiscount(600));
    }

    @Test
    void applyTax_validRate_increasesAmount() {
        Order order = new Order(1, 1000);

        order.applyTax(0.1);

        assertEquals(1100, order.getTotalAmount(), 0.001);
    }
}
