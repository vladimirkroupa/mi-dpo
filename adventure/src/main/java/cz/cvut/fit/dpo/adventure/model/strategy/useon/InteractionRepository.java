package cz.cvut.fit.dpo.adventure.model.strategy.useon;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.manipulation.ItemInteraction;

public interface InteractionRepository {

	ItemInteraction findInteraction(IGameObject item1, IGameObject item2);
	
}
