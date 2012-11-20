package cvut.fit.dpo.arithmetic.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class NoRemoveIterator<T> implements Iterator<T> {

	@Override
	public T next() {
		if (! hasNext()) {
			throw new NoSuchElementException();
		}
		return safeNext();
	}
	
	protected abstract T safeNext();

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Removal not supported.");
	}
	
}
