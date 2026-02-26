package PartA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testAddItemWhenCreated() {
        Order order = new Order();
        OrderItem item = new OrderItem("Book", 1, 10);

        order.addItem(item);

        assertEquals(1, order.getItems().size());
    }

    @Test
    void testInitialStatus() {
        Order order = new Order();
        assertEquals(OrderStatus.CREATED, order.getStatus());
    }

    @Test
    void testAddItemAfterProcessingThrowsException() {
        Order order = new Order();
        order.setStatus(OrderStatus.PAID);

        OrderItem item = new OrderItem("Book", 1, 10);

        assertThrows(IllegalStateException.class, () ->
                order.addItem(item)
        );
    }
}
