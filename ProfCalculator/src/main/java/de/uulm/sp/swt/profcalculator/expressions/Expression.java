package de.uulm.sp.swt.profcalculator.expressions;

public abstract class Expression {

	public abstract int evaluate();

	public abstract String toString(Expression parent, ChildType type);

	public String toString() {
		return toString(null, ChildType.CHILD);
	}

	public String computeEquation() {
		return toString() + " = " + evaluate();
	}

}