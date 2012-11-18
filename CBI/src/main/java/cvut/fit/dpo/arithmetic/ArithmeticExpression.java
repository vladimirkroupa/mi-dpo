package cvut.fit.dpo.arithmetic;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

public interface ArithmeticExpression {
	
	public Integer evaluate();

	/**
	 * Should be implemented.
	 * 
	 * @return
	 */
	Iterator<ExpressionElement> getInOrderIterator();

	/**
	 * Should be implemented
	 * 
	 * TODO
	 * 
	 * @return
	 */
	Iterator<ExpressionElement> getPostOrderIterator();

}
