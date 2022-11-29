package de.uulm.sp.swt.profcalculator.expressions;

public class Multiplication extends Expression {

	public Expression left;
	public Expression right;

	public Multiplication(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	public String toString(Expression parent) {
		return left.toString(this) + " * " + right.toString(this);	// Die Parent Expression der left und right Childern ist this
	}

	public int evaluate() {
		return left.evaluate() * right.evaluate();
	}
	
}
