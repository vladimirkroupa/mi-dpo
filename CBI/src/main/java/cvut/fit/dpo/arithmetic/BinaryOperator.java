package cvut.fit.dpo.arithmetic;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.iterator.InOrderExpressionIterator;
import cvut.fit.dpo.arithmetic.iterator.PostOrderExpressionIterator;



/**
 * Represents the Binary operations like + - etc.
 * 
 * @author Jan Kurš
 * 
 */
public abstract class BinaryOperator implements ArithmeticExpression {
	
	private final ArithmeticExpression leftOperand;
	private final ArithmeticExpression rightOperand;

	public BinaryOperator(ArithmeticExpression leftOperand, ArithmeticExpression rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	@Override
	public Integer evaluate() {
		return evaluate(leftOperand, rightOperand);
	}

	protected abstract Integer evaluate(ArithmeticExpression leftOperand, ArithmeticExpression rightOperand);
	
	@Override
	public Iterator<ExpressionElement> getInOrderIterator() {
		return new InOrderExpressionIterator(this);
	}

	@Override
	public Iterator<ExpressionElement> getPostOrderIterator() {
		return new PostOrderExpressionIterator(this);
	}

	public ArithmeticExpression getLeftOperand() {
		return leftOperand;
	}

	public ArithmeticExpression getRightOperand() {
		return rightOperand;
	}

}
