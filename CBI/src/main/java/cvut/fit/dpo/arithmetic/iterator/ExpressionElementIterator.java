package cvut.fit.dpo.arithmetic.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

public abstract class ExpressionElementIterator implements Iterator<ExpressionElement> {

	@Override
	public ExpressionElement next() {
		if (! hasNext()) {
			throw new NoSuchElementException();
		}
		return safeNext();
	}
	
	protected abstract ExpressionElement safeNext();

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Removal not supported.");
	}
	
}
