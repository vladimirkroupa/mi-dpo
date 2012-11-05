package cz.cvut.fit.dpo.adventure.model;

import cz.cvut.fit.dpo.adventure.model.facade.GameModelSpiFacade;

public interface GameObjectState {

	void examine(GameModelSpiFacade game);
	
	boolean pickUp(GameModelSpiFacade game);
	
	void manipulate(GameModelSpiFacade game);
	
	void useOn(IGameObject what, GameModelSpiFacade game);
	
}
