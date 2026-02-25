package PartD;

// Part E
public class Calculator {

    // Existing functionality
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return a / b;
    }

    // New functionality: return simplified fraction
    public String divideAsFraction(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        int gcd = findGCD(a, b);

        int numerator = a / gcd;
        int denominator = b / gcd;

        return numerator + "/" + denominator;
    }

    // Helper method to find Greatest Common Divisor
    private int findGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}