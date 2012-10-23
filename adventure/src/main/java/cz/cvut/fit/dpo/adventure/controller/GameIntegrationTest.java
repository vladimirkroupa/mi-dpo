package cz.cvut.fit.dpo.adventure.controller;

import junit.framework.Assert;

import org.junit.Test;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.ILocation;
import cz.cvut.fit.dpo.adventure.model.command.DropCommand;
import cz.cvut.fit.dpo.adventure.model.command.MoveToLocationCommand;
import cz.cvut.fit.dpo.adventure.model.command.PickUpCommand;
import cz.cvut.fit.dpo.adventure.model.command.UseOnCommand;
import cz.cvut.fit.dpo.adventure.model.facade.GameFacadePojo;
import cz.cvut.fit.dpo.adventure.view.ConsoleView;
import cz.cvut.fit.dpo.adventure.world1.World1Definition;

public class GameIntegrationTest {

	@Test
	public void test() {
		GameFacadePojo model = new GameFacadePojo(World1Definition.getInstance());
		ConsoleView view = new ConsoleView(model, null);
		
		IGameObject stick = model.findGameObject("stick");
		model.acceptCommand(new PickUpCommand(model.getGameState(), stick));
		
		IGameObject tree = model.findGameObject("tree");
		model.acceptCommand(new UseOnCommand(model.getGameState(), stick, tree));
		
		IGameObject apple = model.findGameObject("apple");
		model.acceptCommand(new PickUpCommand(model.getGameState(), apple));
		
		ILocation cave = model.findExit("cave"); 
		model.acceptCommand(new MoveToLocationCommand(model.getGameState(), cave));
		
		model.acceptCommand(new DropCommand(model.getGameState(), apple));
		
		Assert.assertTrue(model.checkWinningState());
	}
	
	
}
