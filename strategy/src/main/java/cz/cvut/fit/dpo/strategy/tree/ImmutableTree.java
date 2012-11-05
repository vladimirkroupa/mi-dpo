package cz.cvut.fit.dpo.strategy.tree;

import java.util.Iterator;

import com.google.common.base.Preconditions;

import cz.cvut.fit.dpo.strategy.tree.node.Node;
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
	private TreeWalkStrategy strategy;
	
	public ImmutableTree( Node<T> root ) {
		this( root, new DepthFirstTreeWalkStrategy() );
	}

	
	public ImmutableTree( Node<T> root, TreeWalkStrategy strategy ) {
		Preconditions.checkNotNull( this.root = root );
		Preconditions.checkNotNull( this.strategy = strategy );
	}

	@Override
	public Iterator<Node<T>> iterator() {
		return strategy.iterator( root );
	}
	
	@Override
	public void treeWalkStrategy( TreeWalkStrategy strategy ) {
		Preconditions.checkNotNull( this.strategy = strategy );
	}
	
}

