package cz.cvut.fit.dpo.adventure.model.strategy.useon;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelSpiFacade;
import cz.cvut.fit.dpo.adventure.model.manipulation.ItemInteraction;

public class MapUseOnStrategy implements UseOnStrategy {

	private final InteractionRepository itemInteractions;
	
	public MapUseOnStrategy(InteractionRepository interactions) {
		this.itemInteractions = interactions;
	}

	@Override
	public void useOn(IGameObject what, IGameObject target, GameModelSpiFacade game) {
		ItemInteraction interaction = itemInteractions.findInteraction(what, target);
		if (interaction != null) {
			interaction.useOn(target, what, game.getGameState());
			game.createSimpleEvent(interaction.description());
		} else {
			game.createSimpleEvent("You have no idea how to use the " + what.name() + " on the " + target.name());
		}
	}
	
}
