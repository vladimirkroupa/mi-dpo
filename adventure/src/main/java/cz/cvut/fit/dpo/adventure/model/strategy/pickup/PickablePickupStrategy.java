package cz.cvut.fit.dpo.adventure.model.strategy.pickup;

import cz.cvut.fit.dpo.adventure.model.GameObject;
import cz.cvut.fit.dpo.adventure.model.PickupStrategy;

public class PickablePickupStrategy implements PickupStrategy {

	@Override
	public void pickUp(GameObject object) {
		object.location().remove(object);
		GameState.getInstance().inventory().add(object);
	}

	
}
