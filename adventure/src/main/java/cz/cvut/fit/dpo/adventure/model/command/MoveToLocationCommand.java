package cz.cvut.fit.dpo.adventure.model.command;

import cz.cvut.fit.dpo.adventure.model.GameState;
import cz.cvut.fit.dpo.adventure.model.Location;

public class MoveToLocationCommand implements IGameCommand {

	private final GameState game;
	private final Location newLocation;
	
	public MoveToLocationCommand(GameState game, Location newLocation) {
		this.game = game;
		this.newLocation = newLocation;
	}

	@Override
	public void execute() {
		game.changeLocation(newLocation);
	}
	
}
