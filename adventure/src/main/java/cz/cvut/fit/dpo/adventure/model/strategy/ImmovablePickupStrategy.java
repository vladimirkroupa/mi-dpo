package cz.cvut.fit.dpo.adventure.model.strategy;

import cz.cvut.fit.dpo.adventure.model.GameObject;

public class ImmovablePickupStrategy implements PickupStrategy {

	private String reasonForImmovability;
	
	public ImmovablePickupStrategy() {
		this.reasonForImmovability = "";
	}

	public ImmovablePickupStrategy(String reasonForImmovability) {
		this.reasonForImmovability = reasonForImmovability;
	}

	@Override
	public void pickUp(GameObject object) {
		String message = object.name() + " cannot be picked up. ";
		message += reasonForImmovability;
		Game.getInstance().createEvent(message);
	}
	
}
