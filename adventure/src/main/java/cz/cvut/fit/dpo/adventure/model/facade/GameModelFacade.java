package cz.cvut.fit.dpo.adventure.model.facade;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.ILocation;
import cz.cvut.fit.dpo.adventure.model.command.IGameCommand;


public interface GameModelFacade {

	void acceptCommand(IGameCommand command);
	
	IGameObject findGameObject(String name);
	
	ILocation findExit(String name);

	ILocation currentLocation();
	
}

