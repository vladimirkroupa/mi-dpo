package cz.cvut.fit.dpo.adventure.controller;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.ILocation;
import cz.cvut.fit.dpo.adventure.model.command.DropCommand;
import cz.cvut.fit.dpo.adventure.model.command.ExamineCommand;
import cz.cvut.fit.dpo.adventure.model.command.IGameCommand;
import cz.cvut.fit.dpo.adventure.model.command.MoveToLocationCommand;
import cz.cvut.fit.dpo.adventure.model.command.PickUpCommand;
import cz.cvut.fit.dpo.adventure.model.command.UseOnCommand;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelFacade;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelSpiFacade;
import cz.cvut.fit.dpo.adventure.model.observer.GameEvent;
import cz.cvut.fit.dpo.adventure.view.ConsoleView;
import cz.cvut.fit.dpo.adventure.view.GameView;

public class GameController implements IGameController {

	private final GameModelFacade gameFacade;
	private final GameModelSpiFacade gameSpiFacade;
	private GameView view;
	
	public GameController(GameModelFacade gameFacade, GameModelSpiFacade gameSpiFacade) {
		this.gameFacade = gameFacade;
		this.gameSpiFacade = gameSpiFacade;
	}
	
	public void setView(GameView view) {
		this.view = view;
	}

	@Override
	public void examine(String item) {
		IGameObject object = gameFacade.findGameObject(item);
		if (object != null) {
			IGameCommand examine = new ExamineCommand(gameSpiFacade.getGameState(), object);
			gameFacade.acceptCommand(examine);
		}
	}

	@Override
	public void exitTo(String location) {
		ILocation exit = gameFacade.findExit(location);
		if (exit != null) {
			IGameCommand moveTo = new MoveToLocationCommand(gameSpiFacade.getGameState(), exit);
			gameFacade.acceptCommand(moveTo);
		}
	}

	@Override
	public void pickUp(String item) {
		IGameObject object = gameFacade.findGameObject(item);
		if (object != null) {
			IGameCommand pickup = new PickUpCommand(gameSpiFacade.getGameState(), object);
			gameFacade.acceptCommand(pickup);
		}
	}

	@Override
	public void drop(String item) {
		IGameObject object = gameFacade.findGameObject(item);
		if (object != null) {
			IGameCommand drop = new DropCommand(gameSpiFacade.getGameState(), object);
			gameFacade.acceptCommand(drop);
		}
	}

	@Override
	public void useOn(String what, String on) {
		IGameObject object = gameFacade.findGameObject(what);
		IGameObject target = gameFacade.findGameObject(on);
		if (object != null) {
			IGameCommand useOn = new UseOnCommand(gameSpiFacade.getGameState(), object, target);
			gameFacade.acceptCommand(useOn);
		}
	}

	@Override
	public void lookAround() {
		//TODO: odstranit hack
		((ConsoleView)view).gameEventOccured(GameEvent.updateLocationEvent());
	}

	@Override
	public void exitGame() {
		view.exitGame();
	}
	
}
