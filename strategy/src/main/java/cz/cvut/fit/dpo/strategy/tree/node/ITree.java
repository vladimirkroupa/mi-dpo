package cz.cvut.fit.dpo.strategy.tree.node;

import cz.cvut.fit.dpo.strategy.tree.TreeWalkStrategy;

/**
 * N-ary tree.
 * 
 * @param <T> type of content held by tree nodes.
 * 
 * @author kroupvla
 */
public interface ITree<T> extends Iterable<INode<T>> {

	/**
	 * Sets the tree walking strategy.
	 * @param walker tree walking strategy
	 */
	void treeWalkStrategy( TreeWalkStrategy walker );
	
}
