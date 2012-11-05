package cz.cvut.fit.dpo.strategy.tree;

import java.util.Iterator;

import cz.cvut.fit.dpo.strategy.tree.node.Node;

public class DepthFirstTreeWalkStrategy implements TreeWalkStrategy {

	@Override
	public <T> Iterator<Node<T>> iterator( Node<T> root ) {
		return new DFSTreeIterator<T>( root );
	}

}
