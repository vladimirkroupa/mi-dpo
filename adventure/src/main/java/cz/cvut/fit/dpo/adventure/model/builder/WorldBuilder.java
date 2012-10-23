package cz.cvut.fit.dpo.adventure.model.builder;

import java.util.List;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.Location;

public interface WorldBuilder {

	Location initialLocation();
	
	List<IGameObject> initialInventory();
	
	Object itemDefinition(String name);
	
}
