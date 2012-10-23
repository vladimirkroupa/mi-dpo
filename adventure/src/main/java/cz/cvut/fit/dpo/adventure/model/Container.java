package cz.cvut.fit.dpo.adventure.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Container implements IContainer {

	private final List<IGameObject> items;
	
	public Container() {
		items = new ArrayList<>();
	}

	@Override
	public void spawn(IGameObject item) {
		items.add(item);
	}

	@Override
	public void transferItemTo(IGameObject item, IContainer otherContainer) {
		otherContainer.spawn(item);
		this.destroy(item);
	}

	@Override
	public void destroy(IGameObject item) {
		items.remove(item);
	}

	@Override
	public List<IGameObject> content() {
		return Collections.unmodifiableList(items);
	}

}
