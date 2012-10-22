package cz.cvut.fit.dpo.adventure.controller;

import cz.cvut.fit.dpo.adventure.model.GameFacade;
import cz.cvut.fit.dpo.adventure.model.GameObject;
import cz.cvut.fit.dpo.adventure.model.Location;
import cz.cvut.fit.dpo.adventure.model.command.IGameCommand;
import cz.cvut.fit.dpo.adventure.model.command.MoveToLocationCommand;
import cz.cvut.fit.dpo.adventure.model.observer.ErrorEvent;
import cz.cvut.fit.dpo.adventure.model.observer.GameEventObserver;

public class GameController implements IGameController {

	private final GameFacade gameFacade;
	private final GameEventObserver gameView;
	
	public GameController(GameFacade gameFacade, GameEventObserver gameView) {
		this.gameFacade = gameFacade;
		this.gameView = gameView;
	}

	@Override
	public void examine(String item) {
		GameObject object = findGameObject(item);
		if (object != null) {
			object.describe();
		}
	}

	@Override
	public void exitTo(String location) {
		Location exit = findExit(location);
		if (exit != null) {
			IGameCommand moveTo = new MoveToLocationCommand(gameFacade.gameState(), exit);
			gameFacade.acceptCommand(moveTo);
		}
	}

	@Override
	public void pickUp(String item) {
		// TODO Auto-generated method stub
	}

	@Override
	public void drop(String item) {
		// TODO Auto-generated method stub
	}

	@Override
	public void useOn(String what, String on) {
		// TODO Auto-generated method stub
	}

	@Override
	public void newGame() {
		// TODO Auto-generated method stub
	}

	@Override
	public void exitGame() {
		// TODO Auto-generated method stub
	}

	private GameObject findGameObject(String name) {
		GameObject gameObject = gameFacade.findGameObject(name);
		if (gameObject == null) {
			unknownEntity(name);
		}
		return gameObject;
	}
	
	private Location findExit(String name) {
		Location location = gameFacade.findExit(name);
		if (location == null) {
			unknownEntity(name);
		}
		return location;
	}
	
	private void unknownEntity(String name) {
		ErrorEvent event = new ErrorEvent("There is no " + "\"name\"" + " here.");
		gameView.gameEventOccured(event);
	}
	
}
