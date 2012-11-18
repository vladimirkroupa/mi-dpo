package cvut.fit.dpo.arithmetic;

import cvut.fit.dpo.arithmetic.elements.AddOperation;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

/**
 * Represents + operation
 * 
 * @author Jan Kurš
 * 
 */
public class AddOperator extends BinaryOperator {

	public AddOperator(ArithmeticExpression leftOperand, ArithmeticExpression rightOperand) {
		super(leftOperand, rightOperand);
	}

	@Override
	protected Integer evaluate(ArithmeticExpression leftOperand, ArithmeticExpression rightOperand) {
		return leftOperand.evaluate() + rightOperand.evaluate();
	}
	
	@Override
	public ExpressionElement getExpressionElement() {
		return new AddOperation();
	}
	
}
