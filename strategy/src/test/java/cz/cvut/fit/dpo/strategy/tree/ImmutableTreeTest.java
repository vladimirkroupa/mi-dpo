package cz.cvut.fit.dpo.strategy.tree;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import cz.cvut.fit.dpo.strategy.tree.node.ImmutableNode;
import cz.cvut.fit.dpo.strategy.tree.node.Node;

public class ImmutableTreeTest {

	Tree<String> testObject;
	
	@Before
	public void init() {
		Node<String> treeRoot = ImmutableNode
				.builder( "O" )
					.addChild( ImmutableNode.builder( "E" )
						.addChild( ImmutableNode.builder( "A" ) )
						.addChild( ImmutableNode.builder( "B" ) )
					)
					.addChild( ImmutableNode.builder( "R" )
						.addChild( ImmutableNode.builder( "K" ) )
						.addChild( ImmutableNode.builder( "U" ) )
					)
				.build();	
					
		testObject = new ImmutableTree<String>( treeRoot, new DepthFirstTreeWalk() );
	}
	
	@Test
	public void todoName() {
		Iterator<Node<String>> iterator = testObject.iterator();
		assertThat( iterator.hasNext() ).isTrue();
		//assertThat( iterator.next() ).isEqualTo( ImmutableNode.builder( "" ) );
	}
	
}
