package cz.cvut.fit.dpo.strategy.tree;

import java.util.Iterator;
import java.util.List;

import com.google.common.base.Preconditions;

import cz.cvut.fit.dpo.strategy.tree.node.Node;
import cz.cvut.fit.dpo.strategy.tree.node.Tree;
import cz.cvut.fit.dpo.strategy.util.ReflectionObject;

/**
 * Immutable tree.
 * 
 * @param <T>
 * 
 * @author kroupvla
 */
public class ImmutableTree<T> extends ReflectionObject implements Tree<T> {

	private final Node<T> root;
	private TreeWalkStrategy walker;
	
	public ImmutableTree( TreeWalkStrategy walker, Node<T> root ) {
		Preconditions.checkNotNull( this.walker = walker );
		Preconditions.checkNotNull( this.root = root );
	}

	@Override
	public Iterator<Node<T>> iterator() {
		List<Node<T>> nodes = walker.prepareNodesForVisit( root );
		return new ImmutableTreeIterator<T>( nodes );
	}
	
	@Override
	public void treeWalkStrategy( TreeWalkStrategy walker ) {
		Preconditions.checkNotNull( this.walker = walker );
	}
	
}

