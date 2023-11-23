package de.uulm.sp.swt.profcalculator.expressions;

// Decorator
public class NecessaryBrackets extends Expression {

    private Expression expression;

    public NecessaryBrackets(Expression expression) {
        this.expression = expression;
    }
    @Override
    public int evaluate() {
        return expression.evaluate();
    }

    @Override
    public String toString(Expression parent) {
        String childString = expression.toString(parent);
        if (parent instanceof Multiplication && expression instanceof Addition) {
            childString = "(" + childString + ")";
        }
        return childString;
    }
}
