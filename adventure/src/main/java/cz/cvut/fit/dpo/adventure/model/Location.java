package cz.cvut.fit.dpo.adventure.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Location implements ILocation {

	private final BasicGameObject delegate;
	
	private final List<GameObject> items;
	private final List<ILocation> adjacentLocations;
	
	public Location(String name, String description) {
		delegate = new BasicGameObject(name, description);
		items = new ArrayList<>();
		adjacentLocations = new ArrayList<>();
	}
	
	// spi methods!
	
	void addItem(GameObject item) {
		items.add(item);
	}
	
	void addExit(ILocation exit) {
		adjacentLocations.add(exit);
	}
	
	// end of spi methods

	
	@Override
	public String name() {
		return delegate.name();
	}

	@Override
	public String describe() {
		return delegate.describe();
	}

	@Override
	public List<GameObject> objectsHere() {
		return Collections.unmodifiableList(items);
	}

	@Override
	public List<ILocation> exits() {
		return Collections.unmodifiableList(adjacentLocations);
	}

}
