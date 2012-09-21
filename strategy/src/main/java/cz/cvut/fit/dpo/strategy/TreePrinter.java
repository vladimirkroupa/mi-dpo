package cz.cvut.fit.dpo.strategy;

import java.util.Iterator;

import cz.cvut.fit.dpo.strategy.tree.node.Node;
import cz.cvut.fit.dpo.strategy.tree.node.Tree;

public class TreePrinter {
	
	public <T> String asString( Tree<T> tree ) {
		StringBuilder sb = new StringBuilder();
		Iterator<Node<T>> iterator = tree.iterator();
		while ( iterator.hasNext() ) {
			Node<T> node = iterator.next();
			appendNodeContent( node, sb, iterator.hasNext() );
		}
		return sb.toString();
	}
	
	private <T> void appendNodeContent( Node<T> currentNode, StringBuilder sb, boolean hasNext ) {
		String nodeContent = currentNode.content().toString();
		sb.append( nodeContent );
		if ( hasNext ) {
			sb.append( " " );
		}
	}

}
