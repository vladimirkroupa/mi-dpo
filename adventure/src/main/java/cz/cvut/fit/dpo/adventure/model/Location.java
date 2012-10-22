package cz.cvut.fit.dpo.adventure.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Location implements ILocation, IContainer {

	private final BasicGameObject descriptions;
	private final Container container;
	
	private final List<ILocation> adjacentLocations;
	
	public Location(String name, String description) {
		descriptions = new BasicGameObject(name, description);
		container = new Container();
		adjacentLocations = new ArrayList<>();
	}
	
	// spi methods!
	void addItem(GameObject item) {
		container.spawn(item);
	}
	
	void addExit(ILocation exit) {
		adjacentLocations.add(exit);
	}
	// end of spi methods

	
	@Override
	public String name() {
		return descriptions.name();
	}

	@Override
	public String describe() {
		return descriptions.describe();
	}

	@Override
	public List<GameObject> objectsHere() {
		return content();
	}

	@Override
	public List<ILocation> exits() {
		return Collections.unmodifiableList(adjacentLocations);
	}

	@Override
	public void spawn(GameObject item) {
		container.spawn(item);
	}

	@Override
	public void transferItemTo(GameObject item, IContainer otherContainer) {
		container.transferItemTo(item, otherContainer);
	}

	@Override
	public void destroy(GameObject item) {
		container.destroy(item);
	}

	@Override
	public List<GameObject> content() {
		return container.content();
	}

}
