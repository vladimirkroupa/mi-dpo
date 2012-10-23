package cz.cvut.fit.dpo.adventure.model;

import java.util.List;

public interface ILocation extends HasName, HasDescription, IContainer {

	List<IGameObject> objectsHere();
	
	List<ILocation> exits();

}
