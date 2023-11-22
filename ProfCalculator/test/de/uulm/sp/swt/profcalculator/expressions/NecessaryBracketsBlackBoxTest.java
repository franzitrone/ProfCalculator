package de.uulm.sp.swt.profcalculator.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NecessaryBracketsBlackBoxTest {
    Expression value = new NecessaryBrackets(new Value(1));

    Expression add = new NecessaryBrackets(new Addition(value, value));

    Expression mult = new NecessaryBrackets(new Multiplication(value, value));

    @Test
    void testNoBrackets() {
        assertEquals("1 + 1 * 1", new Addition(value, mult).toString());
    }

    @Test
    void testBracketsLeft() {
        assertEquals("(1 + 1) * 1", new Multiplication(add, value).toString());
    }

    @Test
    void testBracketsRight() {
        assertEquals("1 * 1 * (1 + 1)", new Multiplication(mult, add).toString());
    }

    @Test
    void testBracketsLeftAndRight() {
        assertEquals("(1 + 1) * (1 + 1)", new Multiplication(add, add).toString());
    }
}
