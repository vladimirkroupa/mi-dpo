package cz.cvut.fit.dpo.strategy.tree;

import java.util.List;

import cz.cvut.fit.dpo.strategy.tree.node.INode;

public interface TreeWalkStrategy {

	<T> List<INode<T>> prepareNodesForVisit( INode<T> root );

}
