package cz.cvut.fit.dpo.adventure.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Container implements IContainer {

	private final List<GameObject> items;
	
	public Container() {
		items = new ArrayList<>();
	}

	@Override
	public void spawn(GameObject item) {
		items.add(item);
	}

	@Override
	public void transferItemTo(GameObject item, IContainer otherContainer) {
		otherContainer.spawn(item);
		this.destroy(item);
	}

	@Override
	public void destroy(GameObject item) {
		items.remove(item);
	}

	@Override
	public List<GameObject> content() {
		return Collections.unmodifiableList(items);
	}

}
