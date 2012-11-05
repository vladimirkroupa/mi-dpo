package cz.cvut.fit.dpo.strategy.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cz.cvut.fit.dpo.strategy.tree.node.Node;

/**
 * Iterator using BFS for iterating immutable trees consisting of {@link Node}s. 
 * The structure of the tree must not change during the lifetime of this iterator. 
 * 
 * @param <T> type of node content
 * 
 * @author kroupvla
 */
public class BFSTreeIterator<T> implements Iterator<Node<T>> {

	private Deque<Node<T>> queue;
	
	/**
	 * Constructor.
	 * @param nodesToVisit list of nodes in order which they should be visited 
	 */
	BFSTreeIterator(Node<T> root ) {
		this.queue = new ArrayDeque<Node<T>>();
		queue.offer( root );
	}

	@Override
	public boolean hasNext() {
		return ! queue.isEmpty();
	}

	@Override
	public Node<T> next() {
		if ( ! hasNext() ) {
			throw new NoSuchElementException();
		}
		Node<T> node = queue.pollFirst();
		for ( int i = 0; i < node.childCount(); i++ ) {
			Node<T> child = node.child( i );
			queue.offer( child );
		}
		return node;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException( "Node removal not supported!" );
	}

}
