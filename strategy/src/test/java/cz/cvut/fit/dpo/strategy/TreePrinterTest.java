package cz.cvut.fit.dpo.strategy;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import cz.cvut.fit.dpo.strategy.tree.BreadthFirstTreeWalkStrategy;
import cz.cvut.fit.dpo.strategy.tree.DepthFirstTreeWalkStrategy;
import cz.cvut.fit.dpo.strategy.tree.ImmutableTree;
import cz.cvut.fit.dpo.strategy.tree.Tree;
import cz.cvut.fit.dpo.strategy.tree.node.ImmutableNode;

public class TreePrinterTest {

	private TreePrinter testObject;
	
	@Before
	public void init() {
		testObject = new TreePrinter();
	}
	
	/**
	 *   1
	 *  2 5
	 * 3 
	 *  4
	 */
	@Test
	public void dfsPrint() {
		String expected = "1 2 3 4 5";
		
		ImmutableNode<String> root = ImmutableNode.builder( "1" )
				.addChild( ImmutableNode.builder( "2" )
						.addChild( ImmutableNode.builder( "3" )
								.addChild( ImmutableNode.builder( "4" ) )
						)
				)		
				.addChild( ImmutableNode.builder( "5" ) )
				.build();
		Tree<String> tree = new ImmutableTree<String>( root, new DepthFirstTreeWalkStrategy() );
		String actual = testObject.asString( tree );
		
		Assert.assertEquals( expected, actual ); 
	}
	
	
	/**
	 *   1
	 *  2 5
	 * 3   6 
	 *  4
	 */
	@Test
	public void bfsPrint() {
		String expected = "1 2 5 3 6 4";
		
		ImmutableNode<String> root = ImmutableNode.builder( "1" )
				.addChild( ImmutableNode.builder( "2" )
						.addChild( ImmutableNode.builder( "3" )
								.addChild( ImmutableNode.builder( "4" ) )
						)
				)		
				.addChild( ImmutableNode.builder( "5" )
					.addChild( ImmutableNode.builder( "6" ) )
				)
				.build();
		Tree<String> tree = new ImmutableTree<String>( root, new BreadthFirstTreeWalkStrategy() );
		String actual = testObject.asString( tree );
		
		Assert.assertEquals( expected, actual ); 
	}
	
	
}
