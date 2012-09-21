package cz.cvut.fit.dpo.strategy;

import java.util.Iterator;

import cz.cvut.fit.dpo.strategy.tree.node.INode;
import cz.cvut.fit.dpo.strategy.tree.node.ITree;

public class TreePrinter {
	
	public <T> String asString( ITree<T> tree ) {
		StringBuilder sb = new StringBuilder();
		Iterator<INode<T>> iterator = tree.iterator();
		while ( iterator.hasNext() ) {
			INode<T> node = iterator.next();
			appendNodeContent( node, sb, iterator.hasNext() );
		}
		return sb.toString();
	}
	
	private <T> void appendNodeContent( INode<T> currentNode, StringBuilder sb, boolean hasNext ) {
		String nodeContent = currentNode.content().toString();
		sb.append( nodeContent );
		if ( hasNext ) {
			sb.append( " " );
		}
	}

}
