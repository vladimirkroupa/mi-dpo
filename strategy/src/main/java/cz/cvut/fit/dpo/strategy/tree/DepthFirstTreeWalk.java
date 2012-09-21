package cz.cvut.fit.dpo.strategy.tree;

import java.util.List;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import cz.cvut.fit.dpo.strategy.tree.node.INode;

public class DepthFirstTreeWalk implements TreeWalkStrategy {

	private Set<INode<?>> visited;

	@Override
	public <T> List<INode<T>> prepareNodesForVisit( INode<T> root ) {
		Preconditions.checkNotNull( root );
		initVisited();

		final List<INode<T>> nodes = Lists.newArrayList();
		collectPreOrder( nodes, root );
		
		discardVisited();
		return nodes;
	}

	private <T> void collectPreOrder( List<INode<T>> list, INode<T> actual ) {
		assert( actual != null );
		
		if ( detectCycle( actual ) ) {
			throw new IllegalStateException( "Cycle detected during tree traversal. Node " + actual + " has already been visited." );
		}
		list.add( actual );
		for ( int i = 0; i < actual.childCount(); i++ ) {
			if ( actual.hasChild( i ) ) {
				collectPreOrder( list, actual.child( i ) );
			}
		}
	}
	
	private void initVisited() {
		this.visited = Sets.newHashSet();
	}
	
	private void discardVisited() {
		this.visited = null;
	}
	
	private <T> boolean detectCycle( INode<T> node ) {
		if ( visited.contains( node ) ) {
			return true;
		}
		visited.add( node );
		return false;
	}
	
}
