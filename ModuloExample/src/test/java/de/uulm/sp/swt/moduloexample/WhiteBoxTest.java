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

    //Testfälle des SE08b-Quizzes
    @Test
    void testNoCoverage() {
        assertEquals(3, ModuloExample.modulo(3,5));
        assertEquals(2, ModuloExample.modulo(5,3));
        assertEquals(5, ModuloExample.modulo(5,7));
        assertEquals(0, ModuloExample.modulo(0,7));
        assertEquals(2, ModuloExample.modulo(-3,5));
    }

    @Test
    void testBranchingCoverage2() {
        assertEquals(2, ModuloExample.modulo(7,-5));
        assertEquals(3, ModuloExample.modulo(3,5));
    }

    @Test
    void testTermCoverage2() {
        assertEquals(2, ModuloExample.modulo(-3,-5));
        assertEquals(2, ModuloExample.modulo(5,3));
    }
}