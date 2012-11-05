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
		ImmutableNode<String> root = ImmutableNode.builder( "1" )
				.addChild( ImmutableNode.builder( "2" )
						.addChild( ImmutableNode.builder( "3" )
								.addChild( ImmutableNode.builder( "4" ) )
						)
				)		
				.addChild( ImmutableNode.builder( "5" ) )
				.build();
		Tree<String> tree = new ImmutableTree<String>( root, new DepthFirstTreeWalkStrategy() );
		Assert.assertEquals( "1 2 3 4 5", testObject.asString( tree ) ); 
	}
	
	
	/**
	 *   1
	 *  2 5
	 * 3   6 
	 *  4
	 */
	@Test
	public void bfsPrint() {
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
		Assert.assertEquals( "1 2 5 3 6 4", testObject.asString( tree ) ); 
	}
	
	@Test
	public void onlyRootPrint() {
		ImmutableNode<String> root = ImmutableNode.builder( "A" ).build();
		Tree<String> tree = new ImmutableTree<String>( root, new BreadthFirstTreeWalkStrategy() );
		String actual = testObject.asString( tree );
		Assert.assertEquals( "A", actual );
		
		tree.treeWalkStrategy( new DepthFirstTreeWalkStrategy() );
		Assert.assertEquals( "A", testObject.asString( tree ) );
	}
	
	/**
	 *      A
	 * 	   B
	 *    C
	 *   D
	 *  E   
	 * F 
	 */
	@Test
	public void unbalancedTreePrint() {
		ImmutableNode<String> root = ImmutableNode.builder( "A" )
				.addChild( ImmutableNode.builder( "B" ) )
				.addChild( ImmutableNode.builder( "C" ) )
				.addChild( ImmutableNode.builder( "D" ) )
				.addChild( ImmutableNode.builder( "E" ) )
				.addChild( ImmutableNode.builder( "F" ) )
				.build();
		Tree<String> tree = new ImmutableTree<String>( root, new BreadthFirstTreeWalkStrategy() );
		Assert.assertEquals( "A B C D E F", testObject.asString( tree ) );
		
		tree.treeWalkStrategy( new DepthFirstTreeWalkStrategy() );
		Assert.assertEquals( "A B C D E F", testObject.asString( tree ) );
	}
	
	/**
	 *           A1
	 *   B1      B2     B3 
	 * C1  C2  C3  C4  C5
	 *    D1      D2
	 *    		 E1  
	 */
	@Test
	public void ternaryTreePrint() {
		ImmutableNode<String> root = ImmutableNode.builder( "A1" )
				.addChild( ImmutableNode.builder( "B1" )
						.addChild( ImmutableNode.builder( "C1" ) )
						.addChild( ImmutableNode.builder( "C2" )
							.addChild( ImmutableNode.builder( "D1" ) )
						)
				)		
				.addChild( ImmutableNode.builder( "B2" )
					.addChild( ImmutableNode.builder( "C3" ) )
					.addChild( ImmutableNode.builder( "C4" )
						.addChild( ImmutableNode.builder( "D2" )
							.addChild( ImmutableNode.builder( "E1" ) )
						)
					)
				)
				.addChild( ImmutableNode.builder( "B3" )
					.addChild( ImmutableNode.builder( "C5" ) )
				)
				.build();
		Tree<String> tree = new ImmutableTree<String>( root, new BreadthFirstTreeWalkStrategy() );
		Assert.assertEquals( "A1 B1 B2 B3 C1 C2 C3 C4 C5 D1 D2 E1", testObject.asString( tree ) );
		
		tree.treeWalkStrategy( new DepthFirstTreeWalkStrategy() );
		Assert.assertEquals( "A1 B1 C1 C2 D1 B2 C3 C4 D2 E1 B3 C5", testObject.asString( tree ) );
	}
	
	
}
