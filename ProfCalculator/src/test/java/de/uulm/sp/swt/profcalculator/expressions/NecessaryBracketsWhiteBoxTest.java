package de.uulm.sp.swt.profcalculator.expressions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NecessaryBracketsWhiteBoxTest {

    @Test
    void testAdditionWithinMultiplication() {
        Expression child = new Addition(new Value(1), new Value(2));
        Expression brackets = new NecessaryBrackets(child);
        Expression parent = new Multiplication(brackets, new Value(3));
        String result = brackets.toString(parent, ChildType.LEFT);
        assertEquals("(" + child + ")", result);
    }

    @Test
    void testMultiplicationWithinAddition() {
        Expression child = new Multiplication(new Value(1), new Value(2));
        Expression brackets = new NecessaryBrackets(child);
        Expression parent = new Addition(brackets, new Value(3));
        String result = brackets.toString(parent, ChildType.LEFT);
        assertEquals(child.toString(), result);
    }

    @Test
    void testMultiplicationWithinMultiplication() {
        Expression child = new Multiplication(new Value(1), new Value(2));
        Expression brackets = new NecessaryBrackets(child);
        Expression parent = new Multiplication(brackets, new Value(3));
        String result = brackets.toString(parent, ChildType.LEFT);
        assertEquals(child.toString(), result);
    }

    @Test
    void testRightNegativeValue() {
        Expression rChild = new NecessaryBrackets(new Value(-1));
        Expression lChild = new NecessaryBrackets(new Value(1));
        Expression parent = new NecessaryBrackets(new Multiplication(lChild, rChild));
        String result = parent.toString();
        assertEquals(lChild + " * (" + rChild + ")", result);
    }

    @Test
    void testLeftNegativeValue() {
        Expression rChild = new NecessaryBrackets(new Value(1));
        Expression lChild = new NecessaryBrackets(new Value(-1));
        Expression parent = new NecessaryBrackets(new Multiplication(lChild, rChild));
        String result = parent.toString();
        assertEquals(lChild + " * " + rChild, result);
    }



    @Test
    void testMultiplicationWithinDivision() {
        Expression child = new Multiplication(new Value(1), new Value(2));
        Expression brackets = new NecessaryBrackets(child);
        Expression parent = new Division(new Value(3), brackets);
        String result = brackets.toString(parent, ChildType.RIGHT);
        assertEquals("(" + child + ")", result);
    }

    @Test
    void testMultiplicationLeftWithinDivision() {
        Expression child = new Multiplication(new Value(1), new Value(2));
        Expression brackets = new NecessaryBrackets(child);
        Expression parent = new Division(brackets, new Value(3));
        String result = brackets.toString(parent, ChildType.LEFT);
        assertEquals(child.toString(), result);
    }

    @Test
    void testValueWithinDivision() {
        Expression child = new Value(1);
        Expression brackets = new NecessaryBrackets(child);
        Expression parent = new Division(new Value(3), brackets);
        String result = brackets.toString(parent, ChildType.RIGHT);
        assertEquals(child.toString(), result);
    }

    @Test
    void testDivisionWithinDivision() {
        Expression child = new Division(new Value(1), new Value(2));
        Expression brackets = new NecessaryBrackets(child);
        Expression parent = new Division(new Value(3), brackets);
        String result = brackets.toString(parent, ChildType.RIGHT);
        assertEquals("(" + child + ")", result);
    }

    @Test
    void testDivisionLeftWithinDivision() {
        Expression child = new Division(new Value(1), new Value(2));
        Expression brackets = new NecessaryBrackets(child);
        Expression parent = new Division(brackets, new Value(3));
        String result = brackets.toString(parent, ChildType.LEFT);
        assertEquals(child.toString(), result);
    }
}