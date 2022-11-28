package de.uulm.sp.swt.profcalculator.expressions;

public class NecessaryBrackets extends Expression {

	private Expression expression;

	public NecessaryBrackets(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public String toString(Expression parent, ChildType type) {
		String childString = expression.toString(parent, type);
		if (expression instanceof Value && parent instanceof BinaryOperation && expression.evaluate() < 0 && type==ChildType.RIGHT) {
			childString = "(" + childString + ")";
		}
		if (parent instanceof Multiplication && expression instanceof Addition) {
			childString = "(" + childString + ")";
		}
		return childString;
	}

	@Override
	public int evaluate() {
		return expression.evaluate();
	}

}
