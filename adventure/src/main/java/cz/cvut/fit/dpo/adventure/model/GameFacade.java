package cz.cvut.fit.dpo.adventure.model;

import cz.cvut.fit.dpo.adventure.model.command.IGameCommand;

public interface GameFacade {

	ILocation currentLocation();
	
	void acceptCommand(IGameCommand command);
	
	void createEvent(String description);
	
	GameObject findGameObject(String name);
	
	Location findExit(String name);
	
	GameState gameState();
	
}
