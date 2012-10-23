package cz.cvut.fit.dpo.adventure.model.manipulation;

import cz.cvut.fit.dpo.adventure.model.GameState;
import cz.cvut.fit.dpo.adventure.model.IGameObject;

public interface ItemInteraction {

	void useOn(IGameObject target, IGameObject object, GameState game);
	
	String description();
	
	IGameObject target();
	
	IGameObject object();

}
