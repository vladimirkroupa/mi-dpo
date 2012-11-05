package cz.cvut.fit.dpo.strategy.tree;

import java.util.Iterator;

import cz.cvut.fit.dpo.strategy.tree.node.Node;

public class BreadthFirstTreeWalkStrategy implements TreeWalkStrategy {

	@Override
	public <T> Iterator<Node<T>> iterator( Node<T> root ) {
		return new BFSTreeIterator<T>( root );
	}

}
