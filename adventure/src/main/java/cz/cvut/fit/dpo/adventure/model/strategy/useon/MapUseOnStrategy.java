package cz.cvut.fit.dpo.adventure.model.strategy.useon;

import java.util.HashMap;
import java.util.Map;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelSpiFacade;
import cz.cvut.fit.dpo.adventure.model.manipulation.ItemInteraction;

public class MapUseOnStrategy implements UseOnStrategy {

	private Map<String, ItemInteraction> itemInteractions;
	
	public MapUseOnStrategy(ItemInteraction... itemInteractions) {
		this.itemInteractions = new HashMap<>();
		for (ItemInteraction interaction : itemInteractions) {
			this.itemInteractions.put(interaction.object().name(), interaction);
		}
	}

	@Override
	public void useOn(IGameObject what, IGameObject target, GameModelSpiFacade game) {
		ItemInteraction interaction = itemInteractions.get(what.name());
		if (interaction != null) {
			interaction.useOn(target, what, game.getGameState());
			game.createSimpleEvent(interaction.description());
		} else {
			game.createSimpleEvent("You have no idea how to use " + what.name() + " on " + target.name());
		}
	}

}
