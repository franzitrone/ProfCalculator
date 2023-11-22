package de.uulm.sp.swt.moduloexample;

/**
 * Example to illustrate unit testing.
 *
 * @author Thomas Thuem
 */
public class ModuloExample {

    /**
     * Computes the remainder of the Euclidean devision of a by b. In contrast to
     * the Java version a % b, the output will always be positive. Throws
     * ArithmeticException when b is equal to 0.
     *
     * (The goal of this example is not to create an efficient implementation, but
     * to illustrate coverage.)
     *
     * @param a dividend
     * @param b divisor != 0
     * @return remainder r with 0 <= r < b
     */
    public static int modulo(int a, int b) {
        if (b < 0) {              // 1
            b *= -1;              // 2
        }
        int m = a;                // 3
        while (m < 0 || m > b) {  // 4
            m += m < 0 ? b : -b;  // 5
        }
        return m;                 // 6
    }

}