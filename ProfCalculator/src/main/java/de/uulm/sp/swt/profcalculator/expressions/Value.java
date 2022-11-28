package de.uulm.sp.swt.profcalculator.expressions;

public class Value extends Expression {

	Integer value;

	public Value(int value) {
		this.value = value;
	}

	public String toString(Expression parent, ChildType type) {
		return value.toString();
	}

	@Override
	public int evaluate() {
		return value.intValue();
	}

}
