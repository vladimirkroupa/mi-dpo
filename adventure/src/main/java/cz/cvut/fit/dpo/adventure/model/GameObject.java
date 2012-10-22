package cz.cvut.fit.dpo.adventure.model;


public interface GameObject extends GameObjectState, HasName, HasDescription {

	ILocation location();
	
}
