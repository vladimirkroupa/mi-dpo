package cz.cvut.fit.dpo.adventure.model;

import java.util.List;

public interface IContainer {

	void spawn(IGameObject item);
	
	void transferItemTo(IGameObject item, IContainer otherContainer);
	
	void destroy(IGameObject item);
	
	List<IGameObject> content();
	
}
