package PartA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private final OrderService orderService = new OrderService();

    private Order createSampleOrder() {
        Order order = new Order();
        order.addItem(new OrderItem("Book", 2, 10));
        order.addItem(new OrderItem("Pen", 1, 5));
        return order;
    }

    @Test
    void testProcessOrderSuccessful() {
        Order order = createSampleOrder();

        double total = orderService.processOrder(order, "STUDENT10", "card");

        // Subtotal = 25
        // Discount = 10% -> 22.5
        // Tax = 20% -> 4.5
        // Total = 27
        assertEquals(27.0, total, 0.001);
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    void testProcessOrderInvalidPayment() {
        Order order = createSampleOrder();

        double total = orderService.processOrder(order, null, "crypto");

        assertEquals(0, total);
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
    }

    @Test
    void testProcessOrderNoDiscount() {
        Order order = createSampleOrder();

        double total = orderService.processOrder(order, null, "paypal");

        // Subtotal = 25
        // Tax = 5
        assertEquals(30.0, total, 0.001);
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    void testProcessOrderUnknownPaymentThrowsException() {
        Order order = createSampleOrder();

        assertThrows(UnsupportedOperationException.class, () ->
                orderService.processOrder(order, null, "cash")
        );
    }
}
