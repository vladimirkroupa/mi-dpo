package cz.cvut.fit.dpo.adventure.model.item;

import cz.cvut.fit.dpo.adventure.model.DelegatingObject;
import cz.cvut.fit.dpo.adventure.model.strategy.ExamineStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.ManipulateStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.PickupStrategy;
import cz.cvut.fit.dpo.adventure.model.strategy.UseOnStrategy;

public class Switch extends DelegatingObject {

	public Switch(PickupStrategy pickupStrategy, ExamineStrategy examineStrategy,
			ManipulateStrategy manipulateStrategy, UseOnStrategy useOnStrategy) {
		super(pickupStrategy, examineStrategy, manipulateStrategy, useOnStrategy);
	}

}
