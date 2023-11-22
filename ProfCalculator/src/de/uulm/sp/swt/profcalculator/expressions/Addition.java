package de.uulm.sp.swt.profcalculator.expressions;

public class Addition extends Expression {
    public Expression l, r;
    public Addition(Expression l, Expression r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public int evaluate() {
        return l.evaluate() + r.evaluate();
    }

    public String toString(Expression parent) {
        return l.toString(this) + " + " + r.toString(this);
    }

}
