package cz.cvut.fit.dpo.adventure.model.facade;

import java.util.List;

import com.google.common.collect.Lists;

import cz.cvut.fit.dpo.adventure.model.GameObject;
import cz.cvut.fit.dpo.adventure.model.GameState;
import cz.cvut.fit.dpo.adventure.model.ILocation;
import cz.cvut.fit.dpo.adventure.model.builder.WorldBuilder;
import cz.cvut.fit.dpo.adventure.model.command.IGameCommand;
import cz.cvut.fit.dpo.adventure.model.observer.ErrorEvent;
import cz.cvut.fit.dpo.adventure.model.observer.GameEvent;
import cz.cvut.fit.dpo.adventure.model.observer.GameEventObserver;
import cz.cvut.fit.dpo.adventure.model.observer.IGameEvent;
import cz.cvut.fit.dpo.adventure.model.observer.Observable;

public class GameFacadePojo implements GameModelFacade, GameModelSpiFacade, Observable {

	private final List<GameEventObserver> observers;
	private final GameState game;
	
	public GameFacadePojo(WorldBuilder wb) {
		observers = Lists.newArrayList();
		game = new GameState(this, wb);
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
	public void createSimpleEvent(String description) {
		IGameEvent event = GameEvent.minorEvent(description);
		notifyObservers(event);
	}

	@Override
	public void createMajorEvent() {
		IGameEvent event = GameEvent.updateLocationEvent();
		notifyObservers(event);
	}

	@Override
	public void createMajorEvent(String description) {
		IGameEvent event = GameEvent.majorEvent(description);
		notifyObservers(event);		
	}
	
	private void notifyObservers(IGameEvent event) {
		for (GameEventObserver observer : observers) {
			observer.gameEventOccured(event);
		}		
	}

	@Override
	public GameObject findGameObject(String name) {
		for (GameObject item : game.currentLocation().content()) {
			if (item.name().equals(name)) {
				return item;
			}
		}
		unknownEntity(name);
		return null;
	}

	@Override
	public ILocation findExit(String name) {
		for (ILocation location : game.currentLocation().exits()) {
			if (location.name().equals(name)) {
				return location;
			}
		}
		unknownEntity(name);
		return null;
	}
	
	private void unknownEntity(String name) {
		ErrorEvent event = new ErrorEvent("There is no " + "\"name\"" + " here.");
		notifyObservers(event);
	}
	
	@Override
	public GameState getGameState() {
		return game;
	}

	@Override
	public void acceptCommand(IGameCommand command) {
		command.execute();
	}

}
