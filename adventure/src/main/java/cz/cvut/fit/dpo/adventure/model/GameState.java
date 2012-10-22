package cz.cvut.fit.dpo.adventure.model;

import java.util.List;

import cz.cvut.fit.dpo.adventure.model.builder.WorldBuilder;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelSpiFacade;

public class GameState {

	private final GameModelSpiFacade modelSpi;
	
	private ILocation currentLocation;
	private Container inventory;
	
	public GameState(GameModelSpiFacade modelSpi, WorldBuilder builder) {
		this.modelSpi = modelSpi;
		this.currentLocation = builder.initialLocation();
		this.inventory = new Container();
		for (GameObject item : builder.initialInventory()) {
			inventory.spawn(item);
		}
	}
	
	public void examine(GameObject item) {
		modelSpi.createSimpleEvent(item.describe());
	}

	public void exitTo(ILocation exit) {
		currentLocation = exit;
		modelSpi.createMajorEvent();
	}

	public void pickUp(GameObject item) {
		currentLocation.transferItemTo(item, inventory);
		modelSpi.createSimpleEvent("You picked up the " + item.name());
	}

	public void drop(GameObject item) {
		inventory.transferItemTo(item, currentLocation);
		modelSpi.createSimpleEvent("You dropped the " + item.name());
	}

	public void useOn(GameObject what, GameObject target) {
		target.useOn(what);
	}
	
	// asi ne
	public List<GameObject> itemsCarried() {
		return inventory.content();
	}
	
	public ILocation currentLocation() {
		return currentLocation;
	}
	
	
}
