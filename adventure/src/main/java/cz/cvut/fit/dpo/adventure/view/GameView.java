package cz.cvut.fit.dpo.adventure.view;

import cz.cvut.fit.dpo.adventure.model.observer.GameEventObserver;

public interface GameView extends GameEventObserver {

	void parseCommand(String command);
	
}
