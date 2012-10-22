package cz.cvut.fit.dpo.adventure.model.command;

import cz.cvut.fit.dpo.adventure.model.GameObject;
import cz.cvut.fit.dpo.adventure.model.GameState;

public class PickUpCommand implements IGameCommand {

	private final GameState game;
	private final GameObject toPickUp;
	
	public PickUpCommand(GameState game, GameObject toPickUp) {
		this.game = game;
		this.toPickUp = toPickUp;
	}

	@Override
	public void execute() {
		game.pickUp(toPickUp);
	}

}
