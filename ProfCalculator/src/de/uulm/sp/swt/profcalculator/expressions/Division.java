package de.uulm.sp.swt.profcalculator.expressions;

public class Division extends Expression {
    public Expression l, r;
    public Division(Expression l, Expression r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public int evaluate() {
        return l.evaluate() / r.evaluate();
    }

    public String toString(Expression parent, boolean isRightChild) {
        return l.toString(this, false) + " / " + r.toString(this, true);
    }

}