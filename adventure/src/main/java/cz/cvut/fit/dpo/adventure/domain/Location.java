package cz.cvut.fit.dpo.adventure.domain;

import java.util.Set;

public interface Location extends Container, Entity {
	
	Set<Location> reachableLocations();

}