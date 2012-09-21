package cz.cvut.fit.dpo.adventure.domain;

import java.util.Set;

public interface Container {

	Set<PhysicalEntity> entitiesPresent();

	void moveFromHereTo( PhysicalEntity entity, Container destination ); // TODO: void?

	void put( PhysicalEntity entity ); // TODO ASK: some kind of SPI? not really needed in interface
	
}
