package de.uulm.sp.swt.profcalculator.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NecessaryBracketsWhiteBoxTest {

    @Test
    void testAdditionWithinMultiplication() {
        Expression child = new Addition(new Value(1), new Value(2));
        Expression brackets = new NecessaryBrackets(child);
        Expression parent = new Multiplication(brackets, new Value(3));
        String result = brackets.toString(parent, false);
        assertEquals("(" + child + ")", result);
    }

    @Test
    void testMultiplicationWithinAddition() {
        Expression child = new Multiplication(new Value(1), new Value(2));
        Expression brackets = new NecessaryBrackets(child);
        Expression parent = new Addition(brackets, new Value(3));
        String result = brackets.toString(parent, false);
        assertEquals(child.toString(), result);
    }

    @Test
    void testMultiplicationWithinMultiplication() {
        Expression child = new Multiplication(new Value(1), new Value(2));
        Expression brackets = new NecessaryBrackets(child);
        Expression parent = new Multiplication(brackets, new Value(3));
        String result = brackets.toString(parent, false);
        assertEquals(child.toString(), result);
    }

    @Test
    void testMultiplicationAsRightOperandOfDivision() {
        Expression child = new Multiplication(new Value(1), new Value(2));
        Expression brackets = new NecessaryBrackets(child);
        Expression parent = new Division(new Value(3), brackets);
        String result = brackets.toString(parent, true);
        assertEquals("(" + child +")", result);
    }

    @Test
    void testMultiplicationAsLeftOperandOfDivision() {
        Expression child = new Multiplication(new Value(1), new Value(2));
        Expression brackets = new NecessaryBrackets(child);
        Expression parent = new Division(brackets, new Value(3));
        String result = brackets.toString(parent, false);
        assertEquals(child.toString(), result);
    }

    @Test
    void testValuesWithinDivision() {
        Expression child = new Value(1);
        Expression brackets = new NecessaryBrackets(child);
        Expression parent = new Division(brackets, new Value(3));
        String result = brackets.toString(parent, false);
        assertEquals(child.toString(), result);
    }
}