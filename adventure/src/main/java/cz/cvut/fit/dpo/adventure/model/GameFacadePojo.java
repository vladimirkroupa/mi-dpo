package cz.cvut.fit.dpo.adventure.model;


import java.util.List;

import com.google.common.collect.Lists;

import cz.cvut.fit.dpo.adventure.model.command.IGameCommand;
import cz.cvut.fit.dpo.adventure.model.observer.GameEventObserver;
import cz.cvut.fit.dpo.adventure.model.observer.Observable;

public class GameFacadePojo implements GameFacade, Observable {

	private final List<GameEventObserver> observers;
	private final GameState game;
	
	public GameFacadePojo() {
		observers = Lists.newArrayList();
		game = new GameState();
	}

	@Override
	public ILocation currentLocation() {
		return null;
	}

	@Override
	public void acceptCommand(IGameCommand command) {
		command.execute();
	}

	@Override
	public void registerObserver(GameEventObserver observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(GameEventObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void createEvent(String description) {
		for (GameEventObserver observer : observers) {
			observer.gameEventOccured(null);
		}
	}
	
}
