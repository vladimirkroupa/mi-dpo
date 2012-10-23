package cz.cvut.fit.dpo.adventure.world1;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.builder.WorldBuilder;
import cz.cvut.fit.dpo.adventure.model.item.DelegatingGameObject;
import cz.cvut.fit.dpo.adventure.model.strategy.DescriptionExamineStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.NoOpManipulationStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.pickup.ImmovablePickupStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.useon.MapUseOnStrategy;
import cz.cvut.fit.dpo.adventure.world1.tree.ThrowStickAtTree;

public abstract class Tree extends DelegatingGameObject {

	private static final String DESCRIPTION = "You see an old apple tree. There are some apples high in the branches.";
	
	public Tree(WorldBuilder builder) {
		super("tree", 
				new ImmovablePickupStrategy("It is firmly rooted to the ground."),
				new DescriptionExamineStrategy(DESCRIPTION),
				new MapUseOnStrategy(new ThrowStickAtTree(builder.itemDefinition("stick"), this)),
				new NoOpManipulationStrategy() {
					@Override
					protected String createNoOpActionDescription(IGameObject item) {
						return "You try to get the apples, but they are too high to reach.";
					}
				}
		);
	}
		
}
