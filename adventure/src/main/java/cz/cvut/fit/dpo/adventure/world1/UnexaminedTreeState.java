package cz.cvut.fit.dpo.adventure.world1;

import cz.cvut.fit.dpo.adventure.model.GameObjectState;
import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelSpiFacade;

public class UnexaminedTreeState implements GameObjectState {

	@Override
	public void examine(GameModelSpiFacade game) {
		
	}

	@Override
	public boolean pickUp(GameModelSpiFacade game) {
		// TODO Auto-generated method stub
		return false;
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
