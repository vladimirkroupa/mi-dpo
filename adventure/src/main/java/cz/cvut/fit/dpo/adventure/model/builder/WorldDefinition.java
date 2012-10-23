package cz.cvut.fit.dpo.adventure.model.builder;

import java.util.List;

import cz.cvut.fit.dpo.adventure.model.GameState;
import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.Location;
import cz.cvut.fit.dpo.adventure.model.strategy.useon.InteractionRepository;

public interface WorldDefinition extends InteractionRepository {

	Location initialLocation();
	
	List<IGameObject> initialInventory();
	
	IGameObject findItem(String name);
	
	boolean checkWinningState(GameState gameState);
	
}
