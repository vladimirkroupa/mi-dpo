package cvut.fit.dpo.arithmetic;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.elements.SubtractOperation;

/**
 * Represents - operation
 * 
 * @author Jan Kurš
 */
public class SubtractOperator extends BinaryOperator {

	public SubtractOperator(ArithmeticExpression leftOperand, ArithmeticExpression rightOperand) {
		super(leftOperand, rightOperand);
	}

	@Override
	protected Integer evaluate(ArithmeticExpression leftOperand, ArithmeticExpression rightOperand) {
		return leftOperand.evaluate() - rightOperand.evaluate();
	}
	
	@Override
	public ExpressionElement getExpressionElement() {
		return new SubtractOperation();
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
