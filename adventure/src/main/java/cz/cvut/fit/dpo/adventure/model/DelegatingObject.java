package cz.cvut.fit.dpo.adventure.model;

import cz.cvut.fit.dpo.adventure.model.strategy.ExamineStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.ManipulateStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.PickupStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.UseOnStrategy;

public class DelegatingObject implements GameObject {

	private PickupStrategy pickupStrategy;
	private ExamineStrategy examineStrategy;
	private ManipulateStrategy manipulateStrategy;
	private UseOnStrategy useOnStrategy;
	
	public DelegatingObject(PickupStrategy pickupStrategy, ExamineStrategy examineStrategy,
			ManipulateStrategy manipulateStrategy, UseOnStrategy useOnStrategy) {
		this.pickupStrategy = pickupStrategy;
		this.examineStrategy = examineStrategy;
		this.manipulateStrategy = manipulateStrategy;
		this.useOnStrategy = useOnStrategy;
	}

	@Override
	public void examine() {
		examineStrategy.examine(this);
	}
	
	@Override
	public void pickUp() {
		pickupStrategy.pickUp(this);
	}
	
	@Override
	public void manipulate() {
		manipulateStrategy.manipulate(this);
	}
	
	@Override
	public void useOn(GameObject item) {
		useOnStrategy.use(item, this);
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String describe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location location() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
