package cz.cvut.fit.dpo.adventure.model.strategy.useon;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelSpiFacade;

public interface UseOnStrategy {

	void useOn(IGameObject what, IGameObject target, GameModelSpiFacade game);
	
}
