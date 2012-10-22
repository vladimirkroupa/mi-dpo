package cz.cvut.fit.dpo.adventure.model.command;

import cz.cvut.fit.dpo.adventure.model.GameObject;
import cz.cvut.fit.dpo.adventure.model.GameState;

public class DropCommand implements IGameCommand {

	private final GameState game;
	private final GameObject toDrop;
	
	public DropCommand(GameState game, GameObject toDrop) {
		this.game = game;
		this.toDrop = toDrop;
	}

	@Override
	public void execute() {
		game.drop(toDrop);
	}

}
