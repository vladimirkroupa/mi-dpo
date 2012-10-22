package cz.cvut.fit.dpo.adventure.model;

import java.util.List;

public interface ILocation extends HasName, HasDescription {

	List<GameObject> objectsHere();
	
	List<ILocation> exits();

}
