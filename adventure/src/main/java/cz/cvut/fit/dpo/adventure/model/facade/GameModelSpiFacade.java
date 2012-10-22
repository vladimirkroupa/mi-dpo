package cz.cvut.fit.dpo.adventure.model.facade;

import cz.cvut.fit.dpo.adventure.model.GameState;

public interface GameModelSpiFacade {

	void createSimpleEvent(String description);
	
	void createMajorEvent();
	
	void createMajorEvent(String description);
	
	GameState getGameState();
	
}
