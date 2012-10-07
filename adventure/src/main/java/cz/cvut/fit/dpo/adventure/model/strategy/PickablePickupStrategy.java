package cz.cvut.fit.dpo.adventure.model.strategy;

import cz.cvut.fit.dpo.adventure.model.GameObject;

public class PickablePickupStrategy implements PickupStrategy {

	@Override
	public void pickUp(GameObject object) {
		object.location().remove(object);
		GameState.getInstance().inventory().add(object);
	}
	
}
