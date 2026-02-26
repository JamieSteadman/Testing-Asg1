package PartA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {

    private final DiscountService discountService = new DiscountService();

    @Test
    void testNoDiscountCode() {
        double result = discountService.applyDiscount(100, null);
        assertEquals(100, result);
    }

    @Test
    void testBlankDiscountCode() {
        double result = discountService.applyDiscount(100, " ");
        assertEquals(100, result);
    }

    @Test
    void testStudentDiscount() {
        double result = discountService.applyDiscount(100, "STUDENT10");
        assertEquals(90, result);
    }

    @Test
    void testBlackFridayDiscount() {
        double result = discountService.applyDiscount(100, "BLACKFRIDAY");
        assertEquals(70, result);
    }

    @Test
    void testCaseInsensitiveDiscount() {
        double result = discountService.applyDiscount(100, "student10");
        assertEquals(90, result);
    }

    @Test
    void testInvalidCodeThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                discountService.applyDiscount(100, "INVALID")
        );
    }

    @Test
    void testUnknownCodeNoDiscount() {
        double result = discountService.applyDiscount(100, "RANDOM");
        assertEquals(100, result);
    }
}
