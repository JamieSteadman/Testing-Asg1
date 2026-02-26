package PartA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PricingServiceTest {

    private final PricingService pricingService = new PricingService();

    @Test
    void testCalculateSubtotal() {
        Order order = new Order();

        order.addItem(new OrderItem("Book", 2, 10));
        order.addItem(new OrderItem("Pen", 3, 2));

        double subtotal = pricingService.calculateSubtotal(order);

        assertEquals(26, subtotal);
    }

    @Test
    void testCalculateTaxNormal() {
        double tax = pricingService.calculateTax(100);
        assertEquals(20, tax);
    }

    @Test
    void testCalculateTaxZero() {
        double tax = pricingService.calculateTax(0);
        assertEquals(0, tax);
    }

    @Test
    void testCalculateTaxNegativeSubtotal() {
        assertThrows(IllegalArgumentException.class, () ->
                pricingService.calculateTax(-10)
        );
    }
}
