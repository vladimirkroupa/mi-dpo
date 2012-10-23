package cz.cvut.fit.dpo.adventure.model.strategy.pickup;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelSpiFacade;

public interface PickupStrategy {

	boolean pickUp(IGameObject object, GameModelSpiFacade game);
	
}
