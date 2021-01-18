package de.uulm.sp.swt.moduloexample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Example test cases in white-box testing.
 * 
 * @author Thomas Thuem
 */
class WhiteBoxTest {

	@Test
	void testStatementCoverage() {
		// path: 1, 2, 3, 4, 5, 4, 6
		// logical test case: b < 0 and m < 0 || m >= b
		assertEquals(2, ModuloExample.modulo(5, -3));
	}

	@Test
	void testBranchCoverage() {
		testStatementCoverage();
		// path: 1, 3, 4, 6
		// logical test case: b >= 0 and m >= 0 && m < b
		assertEquals(0, ModuloExample.modulo(0, 4));
	}

	@Test
	void testTermCoverage() {
		testBranchCoverage();
		// path: 1, 3, 4, 5, 4, 6
		// logical test case: b >= 0 and m < 0
		//   as m >= b already covered in first test case
		assertEquals(3, ModuloExample.modulo(-2, 5));
	}

}
