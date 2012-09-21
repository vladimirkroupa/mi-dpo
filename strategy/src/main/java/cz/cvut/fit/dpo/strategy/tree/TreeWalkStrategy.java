package cz.cvut.fit.dpo.strategy.tree;

import java.util.List;

import cz.cvut.fit.dpo.strategy.tree.node.Node;

public interface TreeWalkStrategy {

	<T> List<Node<T>> prepareNodesForVisit( Node<T> root );

}
