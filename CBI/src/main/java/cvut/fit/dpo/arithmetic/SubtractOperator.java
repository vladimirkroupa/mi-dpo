package cvut.fit.dpo.arithmetic;

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

}
