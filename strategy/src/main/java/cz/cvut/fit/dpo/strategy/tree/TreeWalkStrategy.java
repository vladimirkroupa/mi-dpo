package cz.cvut.fit.dpo.strategy.tree;

import java.util.Iterator;

import cz.cvut.fit.dpo.strategy.tree.node.Node;

/**
 * Strategy for tree walking. 
 * 
 * @author kroupvla
 */
public interface TreeWalkStrategy {

	/**
	 * TODO
	 * Order is left on the strategy implementation to decide. 
	 * 
	 * @param root tree root
	 * @return TODO
	 */
	<T> Iterator<Node<T>> iterator( Node<T> root );

}
