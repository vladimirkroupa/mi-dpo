package cz.cvut.fit.dpo.adventure.model;

import java.util.List;

public interface Location extends HasName, HasDescription {

	List<GameObject> objectsHere();
	
	List<Location> exitBy();

}
