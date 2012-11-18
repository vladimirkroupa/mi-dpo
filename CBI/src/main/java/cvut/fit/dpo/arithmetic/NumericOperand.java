package cvut.fit.dpo.arithmetic;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.iterator.ExpressionElementIterator;

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
	public ExpressionElement getExpressionElement() {
		return new cvut.fit.dpo.arithmetic.elements.Number(evaluate());
	}
	
	@Override
	public Iterator<ExpressionElement> getInOrderIterator() {
		return new SingleElementIterator();
	}

	@Override
	public Iterator<ExpressionElement> getPostOrderIterator() {
		return new SingleElementIterator();
	}
	
	class SingleElementIterator extends ExpressionElementIterator {

		private boolean done = false;
		
		@Override
		public boolean hasNext() {
			return !done;
		}

		@Override
		protected ExpressionElement safeNext() {
			this.done = true;
			return NumericOperand.this.getExpressionElement();
		}
		
	}
}
