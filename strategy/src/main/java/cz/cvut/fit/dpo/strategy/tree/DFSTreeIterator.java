package cz.cvut.fit.dpo.strategy.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cz.cvut.fit.dpo.strategy.tree.node.Node;

/**
 * Iterator using DFS for iterating immutable trees consisting of {@link Node}s. 
 * The structure of the tree must not change during the lifetime of this iterator. 
 * 
 * @param <T> type of node content
 * 
 * @author kroupvla
 */
public class DFSTreeIterator<T> implements Iterator<Node<T>> {

	private Deque<Node<T>> stack;
	
	/**
	 * Constructor.
	 * @param nodesToVisit list of nodes in order which they should be visited 
	 */
	DFSTreeIterator(Node<T> root ) {
		this.stack = new ArrayDeque<Node<T>>();
		stack.addFirst( root );
	}

	@Override
	public boolean hasNext() {
		return ! stack.isEmpty();
	}

	@Override
	public Node<T> next() {
		if ( ! hasNext() ) {
			throw new NoSuchElementException();
		}
		Node<T> node = stack.pop();
		for ( int i = node.childCount() - 1; i >= 0; i-- ) {
			Node<T> child = node.child( i );
			stack.addFirst( child );
		}
		return node;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException( "Node removal not supported!" );
	}

}
