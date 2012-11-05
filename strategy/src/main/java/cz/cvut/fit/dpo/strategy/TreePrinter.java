package cz.cvut.fit.dpo.strategy;

import java.util.Iterator;

import cz.cvut.fit.dpo.strategy.tree.Tree;
import cz.cvut.fit.dpo.strategy.tree.node.Node;

/**
 * Tree printer using the {@link Iterator} supplied by the tree object.
 * 
 * @author kroupvla
 */
public class TreePrinter {
	
	/**
	 * Prints {@link Tree}s as a single String using the tree's iterator. 
	 * 
	 * @param tree tree to print
	 * @return String representation of this tree
	 */
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
