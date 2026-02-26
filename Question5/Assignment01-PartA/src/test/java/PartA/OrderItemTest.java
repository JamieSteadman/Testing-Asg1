package PartA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    @Test
    void testTotalPrice() {
        OrderItem item = new OrderItem("Book", 2, 10.0);
        assertEquals(20.0, item.getTotalPrice());
    }

    @Test
    void testGetQuantity() {
        OrderItem item = new OrderItem("Pen", 5, 1.5);
        assertEquals(5, item.getQuantity());
    }

    @Test
    void testInvalidQuantity() {
        assertThrows(IllegalArgumentException.class, () ->
                new OrderItem("Item", 0, 5)
        );
    }

    @Test
    void testNegativeUnitPrice() {
        assertThrows(IllegalArgumentException.class, () ->
                new OrderItem("Item", 1, -1)
        );
    }
}
