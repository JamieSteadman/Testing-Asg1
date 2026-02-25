package PartA;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Does not run
public class CalculatorTest {
    @Test
    void testDivideTwoPositiveNumbers() {
        Calculator calc = new Calculator();
        double result = calc.divide(10, 2);
        assertEquals(5.0, result, 0.0001);
    }

    @Test
    void testDivideByZeroThrowsException() {
        Calculator calc = new Calculator();
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });
    }
}