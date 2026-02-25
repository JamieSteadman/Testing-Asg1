public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void testDivideTwoPositiveNumbers() {
        assertEquals(5.0, calc.divide(10, 2), 0.0001);
    }

    @Test
    void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });
    }

    // New test: return simplified fraction for exact divisions
    @Test
    void testDivideReturnsSimplifiedFraction() {
        String result = calc.divideAsFraction(1, 2);

        assertEquals("1/2", result);
    }

    // New test: simplify reducible fractions
    @Test
    void testDivideSimplifiesReducibleFraction() {
        String result = calc.divideAsFraction(2, 4);

        assertEquals("1/2", result);
    }
}