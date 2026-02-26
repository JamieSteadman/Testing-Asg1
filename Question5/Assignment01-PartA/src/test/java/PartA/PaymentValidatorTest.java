package PartA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentValidatorTest {

    private final PaymentValidator validator = new PaymentValidator();

    @Test
    void testValidCardPayment() {
        assertTrue(validator.isPaymentMethodValid("card"));
    }

    @Test
    void testValidPaypalPayment() {
        assertTrue(validator.isPaymentMethodValid("paypal"));
    }

    @Test
    void testInvalidCryptoPayment() {
        assertFalse(validator.isPaymentMethodValid("crypto"));
    }

    @Test
    void testNullPaymentMethod() {
        assertFalse(validator.isPaymentMethodValid(null));
    }

    @Test
    void testUnknownPaymentMethodThrowsException() {
        assertThrows(UnsupportedOperationException.class, () ->
                validator.isPaymentMethodValid("cash")
        );
    }
}
