package cz.cvut.fit.dpo.adventure.model.command;

import cz.cvut.fit.dpo.adventure.model.GameObject;
import cz.cvut.fit.dpo.adventure.model.GameState;

public class ExamineCommand implements IGameCommand {

	private final GameState game;
	private final GameObject toExamine;
	
	public ExamineCommand(GameState game, GameObject toExamine) {
		this.game = game;
		this.toExamine = toExamine;
	}

	@Override
	public void execute() {
		game.examine(toExamine);
	}

}
