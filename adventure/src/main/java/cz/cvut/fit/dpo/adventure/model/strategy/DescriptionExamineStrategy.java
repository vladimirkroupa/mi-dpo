package cz.cvut.fit.dpo.adventure.model.strategy;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelSpiFacade;

public class DescriptionExamineStrategy implements ExamineStrategy {

	private String description;
	
	public DescriptionExamineStrategy(String description) {
		this.description = description;
	}

	@Override
	public void examine(IGameObject object, GameModelSpiFacade game) {
		game.createSimpleEvent("You look at the " + object.name() + ". " + description);		
	}
	
}
