package de.uulm.sp.swt.profcalculator;

public class Multiplication extends Expression {

	public Multiplication(Value left, Value right) {
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return left.toString() + " * " + right.toString();
	}

	public int evaluate() {
		return left.getValue() * right.getValue();
	}
	
}
