package cvut.fit.dpo.arithmetic;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

/**
 * Represents - operation
 * 
 * @author Jan Kurš
 */
public class SubstractOperator extends BinaryOperator {

	public SubstractOperator(ArithmeticExpression leftOperand, ArithmeticExpression rightOperand) {
		super(leftOperand, rightOperand);
	}

	@Override
	protected Integer evaluate(ArithmeticExpression leftOperand, ArithmeticExpression rightOperand) {
		return leftOperand.evaluate() - rightOperand.evaluate();
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
