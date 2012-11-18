package cvut.fit.dpo.arithmetic.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cvut.fit.dpo.arithmetic.ArithmeticExpression;
import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

public class InOrderExpressionIterator extends AbstractExpressionIterator {

	public InOrderExpressionIterator(BinaryOperator iterated) {
		super(iterated);
	}

	@Override
	public Iterator<ExpressionElement> getNestedIterator(ArithmeticExpression iteratorSource) {
		return iteratorSource.getInOrderIterator();
	}

	@Override
	protected StateSequence createStateTransitions() {
		return new InOrderStateSequence();
	}
	
}

class InOrderStateSequence extends StateSequence {
	
	static Map<IteratorState, IteratorState> nextMap;

	static {
		nextMap = new HashMap<>();
		nextMap.put(IteratorState.OPENING_BRACKET, IteratorState.LEFT_OPERAND);
		nextMap.put(IteratorState.LEFT_OPERAND, IteratorState.SELF);
		nextMap.put(IteratorState.SELF, IteratorState.RIGHT_OPERAND);
		nextMap.put(IteratorState.RIGHT_OPERAND, IteratorState.CLOSING_BRACKET);
		nextMap.put(IteratorState.CLOSING_BRACKET, IteratorState.EXHAUSTED);
		nextMap.put(IteratorState.EXHAUSTED, IteratorState.EXHAUSTED);
	}
	
	public InOrderStateSequence() {
		super(nextMap);
	}
	
	@Override
	public IteratorState first() {
		return IteratorState.OPENING_BRACKET;
	}
	
	@Override
	public IteratorState last() {
		return IteratorState.EXHAUSTED;
	}

}