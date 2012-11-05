package cz.cvut.fit.dpo.adventure.world1.items;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.builder.WorldDefinition;
import cz.cvut.fit.dpo.adventure.model.item.DelegatingGameObject;
import cz.cvut.fit.dpo.adventure.model.strategy.DescriptionExamineStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.NoOpManipulationStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.pickup.ImmovablePickupStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.useon.MapUseOnStrategy;

public class Tree extends DelegatingGameObject {

	private static final String DESCRIPTION = "You see an old apple tree. There are some apples high in the branches.";

	public Tree(WorldDefinition world) {
		super("tree");
		setPickupStrategy(new ImmovablePickupStrategy("It is firmly rooted to the ground."));
		setExamineStrategy(new DescriptionExamineStrategy(DESCRIPTION));
		setUseOnStrategy(new MapUseOnStrategy(world));
		setManipulateStrategy(new NoOpManipulationStrategy() {
			@Override
			protected String createNoOpActionDescription(IGameObject item) {
				return "You try to get the apples, but they are too high to reach.";
			}
		});
	}
}
