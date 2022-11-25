package de.uulm.sp.swt.profcalculator.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NecessaryBracketsTest {

    @Test
    void testAdditionWithinMultiplication() {
        Expression child = new Addition(new Value(1), new Value(2));
        Expression brackets = new NecessaryBrackets(child);
        Expression parent = new Multiplication(brackets, new Value(3));
        String result = brackets.toString(parent);
        assertEquals("(" + child + ")", result);
    }
}