package cz.cvut.fit.dpo.adventure.model.item;

import cz.cvut.fit.dpo.adventure.model.AbstractGameObject;
import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelSpiFacade;
import cz.cvut.fit.dpo.adventure.model.strategy.ExamineStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.ManipulationStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.pickup.PickupStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.useon.UseOnStrategy;

public abstract class DelegatingGameObject extends AbstractGameObject {

	private PickupStrategy pickUpStrategy;
	private ExamineStrategy examineStrategy;
	private UseOnStrategy useOnStrategy;
	private ManipulationStrategy manipulateStrategy;

	public DelegatingGameObject(String name) {
		super(name);
	}
	
	public void setPickupStrategy(PickupStrategy pickup) {
		this.pickUpStrategy = pickup;
	}

	public void setExamineStrategy(ExamineStrategy examine) {
		this.examineStrategy = examine;
	}

	public void setUseOnStrategy(UseOnStrategy useOn) {
		this.useOnStrategy = useOn;
	}

	public void setManipulateStrategy(ManipulationStrategy manipulate) {
		this.manipulateStrategy = manipulate;
	}

	@Override
	public void examine(GameModelSpiFacade game) {
		examineStrategy.examine(this, game);
	}

	@Override
	public boolean pickUp(GameModelSpiFacade game) {
		return pickUpStrategy.pickUp(this, game);
	}

	@Override
	public void manipulate(GameModelSpiFacade game) {
		manipulateStrategy.manipulate(this, game);
	}

	@Override
	public void useOn(IGameObject what, GameModelSpiFacade game) {
		useOnStrategy.useOn(what, this, game);
	}
	
}
