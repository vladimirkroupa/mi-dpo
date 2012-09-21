package cz.cvut.fit.dpo.strategy.tree;

import java.util.List;

import cz.cvut.fit.dpo.strategy.tree.node.Node;

/**
 * Strategy for tree walking. 
 * 
 * @author kroupvla
 */
public interface TreeWalkStrategy {

	/**
	 * Creates list in the order nodes will be visited.
	 * Order is left on the strategy implementation to decide. 
	 * 
	 * @param root tree root
	 * @return list of nodes ordered using the tree walking strategy
	 */
	<T> List<Node<T>> prepareNodesForVisit( Node<T> root );

}
