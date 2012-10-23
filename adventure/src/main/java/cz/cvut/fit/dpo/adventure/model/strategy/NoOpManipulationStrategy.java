package cz.cvut.fit.dpo.adventure.model.strategy;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelSpiFacade;

public class NoOpManipulationStrategy implements ManipulationStrategy {

	private final String noOpActionDescription;
	
	public NoOpManipulationStrategy() {
		noOpActionDescription = "You touch the %s. Nothing happens.";
	}

	public NoOpManipulationStrategy(String noOpActionDescription) {
		this.noOpActionDescription = noOpActionDescription;
	}

	protected String createNoOpActionDescription(IGameObject item) {
		return String.format(noOpActionDescription, item);
	}
	
	@Override
	public void manipulate(IGameObject target, GameModelSpiFacade game) {
		String msg = createNoOpActionDescription(target);
		game.createSimpleEvent(msg);
	}

}
