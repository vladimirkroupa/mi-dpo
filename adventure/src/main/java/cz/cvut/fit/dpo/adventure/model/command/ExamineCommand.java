package cz.cvut.fit.dpo.adventure.model.command;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.GameState;

public class ExamineCommand implements IGameCommand {

	private final GameState game;
	private final IGameObject toExamine;
	
	public ExamineCommand(GameState game, IGameObject toExamine) {
		this.game = game;
		this.toExamine = toExamine;
	}

	@Override
	public void execute() {
		game.examine(toExamine);
	}

}
