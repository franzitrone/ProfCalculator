package de.uulm.sp.swt.profcalculator.expressions;

public class Addition extends BinaryOperation {

	public Addition(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	public String toString(Expression parent, ChildType type) {
		return left.toString(this, ChildType.LEFT) + " + " + right.toString(this, ChildType.RIGHT);
	}

	public int evaluate() {
		return left.evaluate() + right.evaluate();
	}
	
}
