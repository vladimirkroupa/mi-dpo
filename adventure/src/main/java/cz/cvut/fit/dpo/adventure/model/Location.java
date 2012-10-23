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
	
	public void addItem(IGameObject item) {
		container.spawn(item);
	}
	
	public void addExit(ILocation exit) {
		adjacentLocations.add(exit);
	}

	
	@Override
	public String name() {
		return descriptions.name();
	}

	@Override
	public String describe() {
		return descriptions.describe();
	}
	
	@Override
	public boolean contains(String itemName) {
		return container.contains(itemName);
	}

	@Override
	public List<IGameObject> objectsHere() {
		return Collections.unmodifiableList(container.content());
	}

	@Override
	public List<ILocation> exits() {
		return Collections.unmodifiableList(adjacentLocations);
	}

	@Override
	public void spawn(IGameObject item) {
		container.spawn(item);
	}

	@Override
	public void transferItemTo(IGameObject item, IContainer otherContainer) {
		container.transferItemTo(item, otherContainer);
	}

	@Override
	public void destroy(IGameObject item) {
		container.destroy(item);
	}

	@Override
	public List<IGameObject> content() {
		return container.content();
	}

}
