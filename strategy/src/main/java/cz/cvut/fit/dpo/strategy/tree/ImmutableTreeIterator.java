package cz.cvut.fit.dpo.strategy.tree;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import cz.cvut.fit.dpo.strategy.tree.node.Node;

/**
 * {@link ImmutableTree} iterator for iterating trees. 
 * The structure of the tree must not change during the lifetime of this iterator. 
 * 
 * @param <T> type of node content
 * 
 * @author kroupvla
 */
public class ImmutableTreeIterator<T> implements Iterator<Node<T>> {

	private final List<Node<T>> nodesToVisit;
	private int nextIndex ;
	
	/**
	 * Constructor.
	 * @param nodesToVisit list of nodes in order which they should be visited 
	 */
	ImmutableTreeIterator( List<Node<T>> nodesToVisit ) {
		this.nodesToVisit = nodesToVisit;
		nextIndex = 0;
	}

	@Override
	public boolean hasNext() {
		return ( nextIndex < nodesToVisit.size() );
	}

	@Override
	public Node<T> next() {
		if ( ! hasNext() ) {
			throw new NoSuchElementException();
		}
		return nodesToVisit.get( nextIndex++ );
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException( "Node removal not supported!" );
	}

}
