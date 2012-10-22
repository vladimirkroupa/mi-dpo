package cz.cvut.fit.dpo.adventure.model;

import java.util.List;

public class GameState {

	private final List<GameObject> inventory;
	private ILocation currentLocation;
	
	public GameState(WorldBuilder builder) {
		this.inventory = builder.initialInventory();
		this.currentLocation = builder.initialLocation();
	}

	public List<GameObject> getInventory() {
		return inventory;
	}

	public ILocation getCurrentLocation() {
		return currentLocation;
	}
	
	public void changeLocation(Location newLocation) {
		currentLocation = newLocation;
		// TODO create event
	}
	
}
