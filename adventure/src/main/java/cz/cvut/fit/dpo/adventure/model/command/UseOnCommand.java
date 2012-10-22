package cz.cvut.fit.dpo.adventure.model.command;

import cz.cvut.fit.dpo.adventure.model.GameObject;
import cz.cvut.fit.dpo.adventure.model.GameState;

public class UseOnCommand implements IGameCommand {

	private final GameState game;
	private final GameObject target;
	private final GameObject object;
	
	public UseOnCommand(GameState game, GameObject object, GameObject target) {
		this.game = game;
		this.target = target;
		this.object = object;
	}

	@Override
	public void execute() {
		game.useOn(object, target);
	}

}
