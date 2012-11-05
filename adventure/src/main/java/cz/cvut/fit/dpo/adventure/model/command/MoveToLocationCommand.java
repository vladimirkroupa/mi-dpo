package cz.cvut.fit.dpo.adventure.model.command;

import cz.cvut.fit.dpo.adventure.model.GameState;
import cz.cvut.fit.dpo.adventure.model.ILocation;

public class MoveToLocationCommand implements IGameCommand {

	private final GameState game;
	private final ILocation newLocation;
	
	public MoveToLocationCommand(GameState game, ILocation newLocation) {
		this.game = game;
		this.newLocation = newLocation;
	}

	@Override
	public void execute() {
		game.exitTo(newLocation);
	}
	
}
