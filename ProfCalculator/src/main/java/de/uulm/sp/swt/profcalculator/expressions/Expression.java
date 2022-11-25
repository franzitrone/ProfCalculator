package de.uulm.sp.swt.profcalculator.expressions;

public abstract class Expression {

	public abstract int evaluate();

	public abstract String toString(Expression parent);

	public String toString() {
		return toString(null);
	}

	public String computeEquation() {
		return toString() + " = " + evaluate();
	}

}