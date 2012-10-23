package cz.cvut.fit.dpo.adventure.world1;

import cz.cvut.fit.dpo.adventure.model.AbstractGameObject;
import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelSpiFacade;
import cz.cvut.fit.dpo.adventure.model.strategy.DescriptionExamineStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.ExamineStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.pickup.ImmovablePickupStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.pickup.PickablePickupStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.pickup.PickupStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.useon.MapUseOnStrategy;

public class Stick extends AbstractGameObject {

private static final String DESCRIPTION = "You see an old apple tree. There are some apples high in the branches.";
	
	private final PickupStrategy pickup = new PickablePickupStrategy();
	private final ExamineStrategy examine = new DescriptionExamineStrategy(DESCRIPTION);
	private final MapUseOnStrategy useOn = new MapUseOnStrategy();
	
	@Override
	public void examine(GameModelSpiFacade game) {
		examine.examine(this, game);
	}
	
	@Override
	public boolean pickUp(GameModelSpiFacade game) {
		pickup.pickUp(this, game);
	}
	
	@Override
	public void manipulate(GameModelSpiFacade game) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void useOn(IGameObject what, GameModelSpiFacade game) {
		// TODO Auto-generated method stub
		
	}
	
	
}
