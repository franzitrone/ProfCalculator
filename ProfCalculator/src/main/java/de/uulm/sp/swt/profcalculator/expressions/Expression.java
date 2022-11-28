package de.uulm.sp.swt.profcalculator.expressions;

public abstract class Expression {

	public abstract int evaluate();

	/**
	 * Recursively computes and returns a string representation of the expression.
	 *
	 * In case every expression e is decorated as new NecessaryBrackets(e) before
	 * inserted into the parent expression, brackets will be added were necessary.
	 * As both, addition and multiplication are associative, brackets are not needed
	 * in most situations. The only case where brackets are needed is if an addition
	 * is the left or right child of a multiplication, as multiplication binds
	 * stronger than addition.
	 *
	 * Example: (1 + 2) * 3 = 9 whereas 1 + 2 * 3 = 1 + (2 * 3) = 7
	 *
	 * As new Multiplication(new Addition(a,b),c).evaluate() !=
	 *    new Addition(a,new Multiplication(b,c).evaluate()
	 * we use brackets to indicate if the addition is supposed to bind stronger in a
	 * particular case.
	 *
	 * @param parent the expression containing this or null if root expression
	 * @return a string representation of the expression
	 */
	public abstract String toString(Expression parent);

	public String toString() {
		return toString(null);
	}

	public String computeEquation() {
		return toString() + " = " + evaluate();
	}

}