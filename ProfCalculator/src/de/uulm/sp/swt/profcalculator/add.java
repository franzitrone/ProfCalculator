package de.uulm.sp.swt.profcalculator;

public class add {
    public VALUE l, r;
    public add(VALUE l, VALUE r) {
        this.l = l;
        this.r = r;
    }
    public String returnAStringRepresentationOfTheExpression() {
        return l.toString() + " + " + r.toString();
    }
    public int evaluatetheexpressiontoanintegervalue() {
        return l.getValue() + r.getValue();
    }
    public String computeAnEquationRepresentingTheExpressionAndItsValue() {
        return returnAStringRepresentationOfTheExpression() + " = " + evaluatetheexpressiontoanintegervalue();
    }
}
