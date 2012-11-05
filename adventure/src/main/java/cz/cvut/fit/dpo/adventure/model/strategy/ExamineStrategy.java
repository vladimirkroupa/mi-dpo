package cz.cvut.fit.dpo.adventure.model.strategy;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelSpiFacade;

public interface ExamineStrategy {

	void examine(IGameObject object, GameModelSpiFacade game);
	
}
