package de.uulm.sp.swt.profcalculator.expressions;

public class NecessaryBrackets extends Expression {

	private Expression expression;

	public NecessaryBrackets(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public String toString(Expression parent) {
		String childString = expression.toString(parent);
		if (expression instanceof Multiplication && parent instanceof Addition) {
			childString = "(" + childString + ")";
		}
		return childString;
	}

	@Override
	public int evaluate() {
		return expression.evaluate();
	}

}
