package cvut.fit.dpo.arithmetic.builder;

import java.util.ArrayDeque;
import java.util.Deque;

import cvut.fit.dpo.arithmetic.AddOperator;
import cvut.fit.dpo.arithmetic.ArithmeticExpression;
import cvut.fit.dpo.arithmetic.NumericOperand;
import cvut.fit.dpo.arithmetic.SubtractOperator;

public class RPNBuilder implements ArithmeticExpressionBuilder {

	private Deque<ArithmeticExpression> workStack = new ArrayDeque<>();
	
	@Override
	public void buildNumericOperand(Integer value) {
		workStack.push(new NumericOperand(value));
	}

	@Override
	public void buildAddOperator() {
		ArithmeticExpression rightOperand = workStack.pop();
		ArithmeticExpression leftOperand = workStack.pop();
		workStack.push(new AddOperator(leftOperand, rightOperand));
	}

	@Override
	public void buildSubtractOperator() {
		ArithmeticExpression rightOperand = workStack.pop();
		ArithmeticExpression leftOperand = workStack.pop();
		workStack.push(new SubtractOperator(leftOperand, rightOperand));
	}

	@Override
	public void buildOpeningBracketOperator() {
		// ignore
	}

	@Override
	public void buildClosingBracketOperator() {
		// ignore
	}

	@Override
	public ArithmeticExpression getResult() {
		return workStack.pop();
	}
	
}
