package de.uulm.sp.swt.profcalculator.expressions;

public class NecessaryBrackets extends Expression {

	private Expression expression;

	public NecessaryBrackets(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public String toString(Expression parent) {
		String childString = expression.toString(parent);
		if (parent instanceof Multiplication && expression instanceof Addition) {	// Klammern müssen gesetzt werden, wenn eine Addition in einer Multiplikation liegt
			childString = "(" + childString + ")";
		}
		return childString;
	}

	@Override
	public int evaluate() {
		return expression.evaluate();
	}

}
