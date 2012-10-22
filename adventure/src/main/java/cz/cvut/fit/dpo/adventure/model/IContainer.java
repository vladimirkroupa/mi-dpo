package cz.cvut.fit.dpo.adventure.model;

import java.util.List;

public interface IContainer {

	void spawn(GameObject item);
	
	void transferItemTo(GameObject item, IContainer otherContainer);
	
	void destroy(GameObject item);
	
	List<GameObject> content();
	
}
