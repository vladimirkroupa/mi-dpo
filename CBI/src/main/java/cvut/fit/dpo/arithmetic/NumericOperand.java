package cvut.fit.dpo.arithmetic;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

/**
 * Represents number in the arithmetic expression
 * 
 * @author Jan Kurš
 */
public class NumericOperand implements ArithmeticExpression {
	
	private final Integer value;

	public NumericOperand(Integer value) {
		this.value = value;
	}

	@Override
	public Integer evaluate() {
		return value;
	}

	@Override
	public Iterator<ExpressionElement> getInOrderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<ExpressionElement> getPostOrderIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
