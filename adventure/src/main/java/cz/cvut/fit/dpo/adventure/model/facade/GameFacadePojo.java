package cz.cvut.fit.dpo.adventure.model.facade;

import java.util.List;

import com.google.common.collect.Lists;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.GameState;
import cz.cvut.fit.dpo.adventure.model.ILocation;
import cz.cvut.fit.dpo.adventure.model.builder.WorldDefinition;
import cz.cvut.fit.dpo.adventure.model.command.IGameCommand;
import cz.cvut.fit.dpo.adventure.model.observer.ErrorEvent;
import cz.cvut.fit.dpo.adventure.model.observer.GameEvent;
import cz.cvut.fit.dpo.adventure.model.observer.GameEventObserver;
import cz.cvut.fit.dpo.adventure.model.observer.IGameEvent;
import cz.cvut.fit.dpo.adventure.model.observer.Observable;

public class GameFacadePojo implements GameModelFacade, GameModelSpiFacade, Observable {

	private final List<GameEventObserver> observers;
	private final GameState game;
	private final WorldDefinition world;
	
	public GameFacadePojo(WorldDefinition wb) {
		observers = Lists.newArrayList();
		game = new GameState(this, wb);
		this.world = wb;
	}
	
	@Override
	public ILocation currentLocation() {
		return game.currentLocation();
	}
	
	@Override
	public List<IGameObject> itemsCarried() {
		return game.itemsCarried();
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
	public IGameObject findGameObject(String name) {
		for (IGameObject item : game.itemsCarried()) {
			if (item.name().equals(name)) {
				return item;
			}
		}
		for (IGameObject item : game.currentLocation().content()) {
			if (item.name().equals(name)) {
				return item;
			}
		}
		unknownEntity(name, "item");
		return null;
	}

	@Override
	public ILocation findExit(String name) {
		for (ILocation location : game.currentLocation().exits()) {
			if (location.name().equals(name)) {
				return location;
			}
		}
		unknownEntity(name, "exit");
		return null;
	}
	
	private void unknownEntity(String name, String what) {
		ErrorEvent event = new ErrorEvent("There is no " + what + " " + "\"" + name + "\"" + " here.");
		notifyObservers(event);
	}
	
	@Override
	public GameState getGameState() {
		return game;
	}

	@Override
	public void acceptCommand(IGameCommand command) {
		command.execute();
		if (checkWinningState()) {
			createMajorEvent("**** You won! ***");
		}
	}
	
	public boolean checkWinningState() {
		return world.checkWinningState(game);
	}
	
}
