package cz.cvut.fit.dpo.strategy;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import cz.cvut.fit.dpo.strategy.tree.DepthFirstTreeWalk;
import cz.cvut.fit.dpo.strategy.tree.Tree;
import cz.cvut.fit.dpo.strategy.tree.node.BinaryNode;
import cz.cvut.fit.dpo.strategy.tree.node.BinaryNodeToNaryAdapter;
import cz.cvut.fit.dpo.strategy.tree.node.ITree;

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
	public void asString() {
		String expected = "1 2 3 4 5";
		
		BinaryNode<String> root = BinaryNode.builder( "1" )
				.withLeft( BinaryNode.builder( "2" )
						.withLeft( BinaryNode.builder( "3" )
								.withRight( BinaryNode.builder( "4" ) )
						)
				)		
				.withRight( BinaryNode.builder( "5" ) )
				.build();
		ITree<String> tree = new Tree<String>( new DepthFirstTreeWalk(), new BinaryNodeToNaryAdapter<String>( root ) );
		String actual = testObject.asString( tree );
		
		Assert.assertEquals( expected, actual ); 
	}
	
}
