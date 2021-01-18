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
	 * @param a dividend
	 * @param b divisor != 0
	 * @return remainder r with 0 <= r < b
	 */
	public static int modulo(int a, int b) {
		int m = a % b;
		return m < 0 ? m + b : m;
	}
	
}
