package cz.cvut.fit.dpo.adventure.model.command;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.GameState;

public class PickUpCommand implements IGameCommand {

	private final GameState game;
	private final IGameObject toPickUp;
	
	public PickUpCommand(GameState game, IGameObject toPickUp) {
		this.game = game;
		this.toPickUp = toPickUp;
	}

	@Override
	public void execute() {
		game.pickUp(toPickUp);
	}

}
