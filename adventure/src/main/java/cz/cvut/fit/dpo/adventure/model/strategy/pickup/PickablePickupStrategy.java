package cz.cvut.fit.dpo.adventure.model.strategy.pickup;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelSpiFacade;

public class PickablePickupStrategy implements PickupStrategy {

	@Override
	public boolean pickUp(IGameObject object, GameModelSpiFacade game) {
		String message = "You picked up " + object.name() + ".";
		game.createSimpleEvent(message);
		return false;
	}
	
}
