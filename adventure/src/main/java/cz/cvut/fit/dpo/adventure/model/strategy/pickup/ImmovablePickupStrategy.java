package cz.cvut.fit.dpo.adventure.model.strategy.pickup;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelSpiFacade;

public class ImmovablePickupStrategy implements PickupStrategy {

	private String reasonForImmovability;
	
	public ImmovablePickupStrategy() {
		this.reasonForImmovability = "cannot be picked up";
	}

	public ImmovablePickupStrategy(String reasonForImmovability) {
		this.reasonForImmovability = reasonForImmovability;
	}

	@Override
	public boolean pickUp(IGameObject object, GameModelSpiFacade game) {
		String message = object.name() + " " + reasonForImmovability + ".";
		game.createSimpleEvent(message);
		return false;
	}
	
}
