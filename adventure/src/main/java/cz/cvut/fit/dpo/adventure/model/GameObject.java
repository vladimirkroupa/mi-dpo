package cz.cvut.fit.dpo.adventure.model;

import cz.cvut.fit.dpo.adventure.domain.Location;

public interface GameObject extends GameObjectState, HasName, HasDescription {

	Location location();
	
}
