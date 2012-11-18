package cvut.fit.dpo.arithmetic.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cvut.fit.dpo.arithmetic.ArithmeticExpression;
import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

public class PostOrderExpressionIterator extends AbstractExpressionIterator {

	public PostOrderExpressionIterator(BinaryOperator iterated) {
		super(iterated);
	}

	@Override
	public Iterator<ExpressionElement> getNestedIterator(ArithmeticExpression iteratorSource) {
		return iteratorSource.getPostOrderIterator();
	}

	@Override
	protected StateSequence createStateTransitions() {
		return new PostOrderStateSequence();
	}
	
}

class PostOrderStateSequence extends StateSequence {
	
	static Map<IteratorState, IteratorState> nextMap;

	static {
		nextMap = new HashMap<>();
		nextMap.put(IteratorState.LEFT_OPERAND, IteratorState.RIGHT_OPERAND);
		nextMap.put(IteratorState.RIGHT_OPERAND, IteratorState.SELF);
		nextMap.put(IteratorState.SELF, IteratorState.EXHAUSTED);
		nextMap.put(IteratorState.EXHAUSTED, IteratorState.EXHAUSTED);
	}

	public PostOrderStateSequence() {
		super(nextMap);
	}

	@Override
	public IteratorState first() {
		return IteratorState.LEFT_OPERAND;
	}

	@Override
	public IteratorState last() {
		return IteratorState.EXHAUSTED;
	}
	
}