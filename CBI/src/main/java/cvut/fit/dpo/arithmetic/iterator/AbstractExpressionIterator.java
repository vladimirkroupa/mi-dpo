package cvut.fit.dpo.arithmetic.iterator;

import java.util.Iterator;
import java.util.Map;

import cvut.fit.dpo.arithmetic.ArithmeticExpression;
import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.elements.CloseBracketOperation;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.elements.OpenBracketOperation;

public abstract class AbstractExpressionIterator extends NoRemoveIterator<ExpressionElement> {

	private IteratorState state;
	private final BinaryOperator binaryOperator;
	private final StateSequence transitions;
	private final Iterator<ExpressionElement> leftOperandIterator;
	private final Iterator<ExpressionElement> rightOperandIterator;
	
	public AbstractExpressionIterator(BinaryOperator iterated) {
		this.binaryOperator = iterated;
		this.transitions = createStateTransitions();
		this.state = transitions.first();
		this.leftOperandIterator = getNestedIterator(binaryOperator.getLeftOperand());
		this.rightOperandIterator = getNestedIterator(binaryOperator.getRightOperand());
	}

	@Override
	public boolean hasNext() {
		switch (this.state) {
			case LEFT_OPERAND: return this.leftOperandIterator.hasNext();
			case RIGHT_OPERAND: return this.rightOperandIterator.hasNext();
			default: return ! state.equals(this.transitions.last());
		}
	}

	@Override
	protected ExpressionElement safeNext() {
		switch (this.state) {
			case OPENING_BRACKET: {
				transition(); 
				return new OpenBracketOperation(); 
			}
			case LEFT_OPERAND: {
				ExpressionElement result = this.leftOperandIterator.next();
				if (! this.leftOperandIterator.hasNext()) {
					transition();
				}
				return result;
			}
			case SELF: {
				transition();
				return this.binaryOperator.getExpressionElement();
			}
			case RIGHT_OPERAND: {
				ExpressionElement result = this.rightOperandIterator.next();
				if (! this.rightOperandIterator.hasNext()) {
					transition();
				}
				return result;
			}
			case CLOSING_BRACKET: {
				transition();
				return new CloseBracketOperation();
			}
			default: throw new IllegalStateException("Unreachable state.");
		}
	}
	
	private void transition() {
		this.state = this.transitions.next(this.state);
	}
	
	protected abstract Iterator<ExpressionElement> getNestedIterator(ArithmeticExpression iteratorSource);
	
	protected abstract StateSequence createStateTransitions();
	
}

abstract class StateSequence {
	
	private final Map<IteratorState, IteratorState> nextMap;
	
	public StateSequence(Map<IteratorState, IteratorState> nextMap) {
		this.nextMap = nextMap;
	}

	public abstract IteratorState first();
	
	public abstract IteratorState last();

	public IteratorState next(IteratorState from) {
		IteratorState next = nextMap.get(from);
		if (next == null) {
			throw new IllegalStateException("Uncovered transition for state " + from); 
		}
		return next;
	}
	
}
	
enum IteratorState {
	OPENING_BRACKET, LEFT_OPERAND, SELF, RIGHT_OPERAND, CLOSING_BRACKET, EXHAUSTED;
}
