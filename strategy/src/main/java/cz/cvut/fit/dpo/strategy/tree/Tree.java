package cz.cvut.fit.dpo.strategy.tree;

import java.util.Iterator;
import java.util.List;

import com.google.common.base.Preconditions;

import cz.cvut.fit.dpo.strategy.tree.node.INode;
import cz.cvut.fit.dpo.strategy.tree.node.ITree;
import cz.cvut.fit.dpo.strategy.util.ReflectionObject;

public class Tree<T> extends ReflectionObject implements ITree<T> {

	private final INode<T> root;
	private TreeWalkStrategy walker;
	
	public Tree( TreeWalkStrategy walker, INode<T> root ) {
		Preconditions.checkNotNull( this.walker = walker );
		Preconditions.checkNotNull( this.root = root );
	}

	@Override
	public Iterator<INode<T>> iterator() {
		List<INode<T>> nodes = walker.prepareNodesForVisit( root );
		return new ImmutableTreeIterator<T>( nodes );
	}
	
	@Override
	public void treeWalkStrategy( TreeWalkStrategy walker ) {
		Preconditions.checkNotNull( this.walker = walker );
	}
	
}

