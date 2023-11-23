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
    public String toString(Expression parent, boolean isRightChild) {
        String childString = expression.toString(parent);
        boolean brackets = false;

        if (hasHighPrecedence(parent) && expression instanceof Addition) {
            // z.B. (1 + 2) * 3
            brackets = true;
        } else if (parent instanceof Division && !(expression instanceof Value) && isRightChild) {
            // z.B. 8 / 4 / 2 = 1, aber 8 / (4 / 2) = 4
            brackets = true;
        }
        if (brackets) {
            childString = "(" + childString + ")";
        }
        return childString;
    }

    private boolean hasHighPrecedence(Expression expression) {
        return expression instanceof Multiplication || expression instanceof Division;
    }
}
