package cz.cvut.fit.dpo.strategy.tree;

import cz.cvut.fit.dpo.strategy.tree.node.Node;

/**
 * N-ary tree with changeable tree walk strategy.
 * 
 * @param <T> type of content held by tree nodes.
 * 
 * @author kroupvla
 */
public interface Tree<T> extends Iterable<Node<T>> {

	/**
	 * Sets the tree walking strategy.
	 * @param walker tree walking strategy
	 */
	void treeWalkStrategy( TreeWalkStrategy walker );
	
}
