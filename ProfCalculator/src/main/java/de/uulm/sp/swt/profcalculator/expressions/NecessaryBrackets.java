package de.uulm.sp.swt.profcalculator.expressions;

public class NecessaryBrackets extends Expression {

	private Expression expression;

	public NecessaryBrackets(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public String toString(Expression parent, ChildType type) {
		String childString = expression.toString(parent, type);
		boolean brackets = false;
		if (expression instanceof Value && parent instanceof BinaryOperation && expression.evaluate() < 0 && type==ChildType.RIGHT) {
			brackets = true;
		}
		if (hasHighPrecedence(parent) && expression instanceof Addition) {
			brackets = true;
		}
		if (hasHighPrecedence(parent) && expression instanceof Division && type==ChildType.RIGHT) {
			brackets = true;
		}
		if (parent instanceof Division && hasHighPrecedence(expression) && type==ChildType.RIGHT) {
			brackets = true;
		}
		if (brackets) {
			childString = "(" + childString + ")";
		}
		return childString;
	}

	@Override
	public int evaluate() {
		return expression.evaluate();
	}

	private boolean hasHighPrecedence(Expression e) {
		return e instanceof Multiplication || e instanceof Division;
	}

}
