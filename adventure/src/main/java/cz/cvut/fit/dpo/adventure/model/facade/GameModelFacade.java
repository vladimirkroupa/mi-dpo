package cz.cvut.fit.dpo.adventure.model.facade;

import cz.cvut.fit.dpo.adventure.model.GameObject;
import cz.cvut.fit.dpo.adventure.model.ILocation;
import cz.cvut.fit.dpo.adventure.model.command.IGameCommand;


public interface GameModelFacade {

	void acceptCommand(IGameCommand command);
	
	GameObject findGameObject(String name);
	
	ILocation findExit(String name);

}

