package cz.cvut.fit.dpo.adventure.world1;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.Location;
import cz.cvut.fit.dpo.adventure.model.builder.WorldDefinition;
import cz.cvut.fit.dpo.adventure.model.manipulation.ItemInteraction;
import cz.cvut.fit.dpo.adventure.model.strategy.useon.ItemPair;
import cz.cvut.fit.dpo.adventure.world1.location.Cave;
import cz.cvut.fit.dpo.adventure.world1.location.Hill;
import cz.cvut.fit.dpo.adventure.world1.tree.ThrowStickAtTree;

public class World1Definition implements WorldDefinition {

	private Location initial;
	
	private final Map<ItemPair, ItemInteraction> itemInteractions; 
	
	private Stick stick;
	private Tree tree;
	
	
	public World1Definition() {
		itemInteractions = new HashMap<>();
		initItems();
		initLocations();
		initInteractions();
	}
	
	private void initItems() {
		tree = new Tree(this);
		stick = new Stick(this);
	}

	private void initLocations() {
		Location hill = new Hill();
		Location cave = new Cave();

		hill.addExit(cave);
		cave.addExit(hill);

		hill.addItem(tree);
		hill.addItem(stick);
		
		initial = hill;
	}
	
	private void initInteractions() {
		itemInteractions.put(new ItemPair(tree, stick), new ThrowStickAtTree());
	}
	
	@Override
	public Location initialLocation() {
		return null;
	}

	@Override
	public List<IGameObject> initialInventory() {
		return Collections.emptyList();
	}

	@Override
	public ItemInteraction findInteraction(IGameObject item1, IGameObject item2) {
		return itemInteractions.get(new ItemPair(item1, item2));
	}


}
