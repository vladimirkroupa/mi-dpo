package cz.cvut.fit.dpo.adventure.model.command;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.GameState;

public class UseOnCommand implements IGameCommand {

	private final GameState game;
	private final IGameObject target;
	private final IGameObject object;
	
	public UseOnCommand(GameState game, IGameObject object, IGameObject target) {
		this.game = game;
		this.target = target;
		this.object = object;
	}

	@Override
	public void execute() {
		game.useOn(object, target);
	}

}
