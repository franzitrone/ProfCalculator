package de.uulm.sp.swt.profcalculator.expressions;

// Composite (Branch) of Composite Pattern
public class Multiplication extends Expression {
    public Expression l, r;
    public Multiplication(Expression l, Expression r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public int evaluate() {
        return l.evaluate() * r.evaluate();
    }

    public String toString(Expression parent, boolean isRightChild) {
        return l.toString(this, false) + " * " + r.toString(this, true);
    }

}
