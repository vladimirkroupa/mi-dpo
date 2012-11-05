package cz.cvut.fit.dpo.adventure.model;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import cz.cvut.fit.dpo.adventure.world1.items.Apple;
import cz.cvut.fit.dpo.adventure.world1.items.Tree;

public class ContainerTest {

	private IContainer testObject;
	
	@Before
	public void init() {
		testObject = new Location("forest", "nevim");  
	}
	
	@Test
	public void spawnItemTest() {
		IGameObject apple = new Apple(null);
		testObject.spawn(apple);
		Assert.assertTrue(testObject.contains("apple"));
		testObject.destroy(apple);
		Assert.assertFalse(testObject.contains("apple"));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void modifyContent() {
		testObject.content().add(new Apple(null));
	}
	
	@Test
	public void transferItems() {
		IContainer testObject2 = new Location("house", "nic");
		IGameObject tree = new Tree(null);
		testObject2.spawn(tree);
		testObject2.transferItemTo(tree, testObject);
		Assert.assertTrue(testObject.contains("tree"));
		Assert.assertFalse(testObject2.contains("tree"));
	}
	
}
