package de.uulm.sp.swt.profcalculator.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NecessaryBracketsBlackBoxTest {
    Expression value = new NecessaryBrackets(new Value(1));

    Expression add = new NecessaryBrackets(new Addition(value, value));

    Expression mult = new NecessaryBrackets(new Multiplication(value, value));

    Expression div = new NecessaryBrackets(new Division(value, value));

    @Test
    void testNoBrackets() {
        assertEquals("1 + 1 * 1", new Addition(value, mult).toString());
        assertEquals("1 + 1 / 1", new Addition(value, div).toString());
    }

    @Test
    void testBracketsLeft() {
        assertEquals("(1 + 1) * 1", new Multiplication(add, value).toString());
        assertEquals("(1 + 1) / 1", new Division(add, value).toString());
    }

    @Test
    void testBracketsRight() {
        assertEquals("1 * 1 * (1 + 1)", new Multiplication(mult, add).toString());
        assertEquals("1 / 1 / (1 + 1)", new Division(div, add).toString());
    }

    @Test
    void testBracketsLeftAndRight() {
        assertEquals("(1 + 1) * (1 + 1)", new Multiplication(add, add).toString());
        assertEquals("(1 + 1) / (1 + 1)", new Division(add, add).toString());
    }

    // An Operation as the right Operand of Division must be in brackets

    @Test
    void testBracketsDivisionAsRightOperandOfDivision() {
        assertEquals("1 / (1 / 1)", new Division(value, div).toString());
    }

    @Test
    void testBracketsMultiplicationAsRightOperandOfDivision() {
        assertEquals("1 / (1 * 1)", new Division(value, mult).toString());
    }

    @Test
    void testBracketsAdditionAsRightOperandOfDivision() {
        assertEquals("1 / (1 + 1)", new Division(value, add).toString());
    }

    @Test
    void testNoBracketsValueAsRightOperandOfDivision() {
        assertEquals("1 / 1", new Division(value, value).toString());
    }

    @Test
    void testNoBracketsForLeftOperandOfDivision() {
        assertEquals("1 / 1 / 1", new Division(div, value).toString());
        assertEquals("1 * 1 / 1", new Division(mult, value).toString());
    }
}
