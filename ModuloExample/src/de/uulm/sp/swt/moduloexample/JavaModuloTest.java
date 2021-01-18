package de.uulm.sp.swt.moduloexample;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class JavaModuloTest {

	@Test
	void testJavasModulo() {
		for (int i = -3; i < 6; i++) {
			System.out.println(i + " % -3 = " + (i % -3));
		}
		System.out.println();
		for (int i = -3; i < 6; i++) {
			System.out.println(i + " % 3 = " + (i % 3));
		}
	}
	
	@Test
	void testJavasDivisionByZero() {
		try {
			System.out.println(5 % 0);
		}
		catch (ArithmeticException e) {
			return;
		}
		fail();
	}

}
