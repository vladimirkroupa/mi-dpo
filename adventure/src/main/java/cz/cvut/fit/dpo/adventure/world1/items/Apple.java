package cz.cvut.fit.dpo.adventure.world1.items;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.builder.WorldDefinition;
import cz.cvut.fit.dpo.adventure.model.item.DelegatingGameObject;
import cz.cvut.fit.dpo.adventure.model.strategy.DescriptionExamineStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.NoOpManipulationStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.pickup.PickablePickupStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.useon.MapUseOnStrategy;

public class Apple extends DelegatingGameObject {
	
	private static final String DESCRIPTION = "You see a bright red apple.";
	
	public Apple(WorldDefinition world) {
		super("apple");
		setPickupStrategy(new PickablePickupStrategy());
		setExamineStrategy(new DescriptionExamineStrategy(DESCRIPTION));
		setUseOnStrategy(new MapUseOnStrategy(world));
		setManipulateStrategy(new NoOpManipulationStrategy() {
			@Override
			protected String createNoOpActionDescription(IGameObject item) {
				return "You eat the apple.";
			}
		});
	}
	
}
