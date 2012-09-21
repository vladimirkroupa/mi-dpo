package cz.cvut.fit.dpo.strategy.tree.node;

import java.util.NoSuchElementException;

/**
 * N-ary tree node.
 * 
 * @param <T> type of node content
 * 
 * @author kroupvla
 */
public interface INode<T> {

	/**
	 * @return content of the node
	 */
	T content();
	
	/**
	 * Tests if node has n-th child node (zero-based). 
	 * If node has the n-th child, then it must have 0..n-1 children as well. 
	 * 
	 * @param index zero-based index of the child node in question
	 * @return true if node has children with given index, false otherwise
	 */
	boolean hasChild( int index );
	
	/**
	 * Returns n-th child node of this node.
	 * 
	 * @param index zero-base index of desired child node
	 * @return the n-th child node
	 * @throws NoSuchElementException if node doesn't contain node with the required index.
	 */
	INode<T> child( int index );

	/**
	 * @return number of child nodes.      
	 */
	int childCount();
	
}
