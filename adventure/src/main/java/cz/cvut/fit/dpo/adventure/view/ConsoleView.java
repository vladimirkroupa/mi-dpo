package cz.cvut.fit.dpo.adventure.view;

import java.io.PrintStream;

import cz.cvut.fit.dpo.adventure.controller.IGameController;
import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.ILocation;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelFacade;
import cz.cvut.fit.dpo.adventure.model.observer.IGameEvent;

public class ConsoleView implements GameView {

	private GameModelFacade model;
	private IGameController controller;
	
	private PrintStream out;
	private boolean exit;

	public ConsoleView(GameModelFacade model, IGameController controller) {
		this.model = model;
		this.controller = controller;
		this.out = System.out;
		exit = false;
	}

	public void run() {
		String command;
		while (! exit) {
			command = System.console().readLine();
			parseCommand(command);
		}
	}
	
	@Override
	public void gameEventOccured(IGameEvent event) {
		out.println(event.description());
		out.println();
		if (event.shouldUpdateState()) {
			printCurrentState();
		}
	}

	@Override
	public void parseCommand(String command) {
		String[] words = command.split(" ");
		if (CommandParser.isNullaryCommand(command)) {
			//switch words[0]:
				
		}
		if (CommandParser.isUnaryCommand(command)) {
			String action = words[0];
			String param = words[1];
			// check argument count
			if (action.startsWith(CommandParser.EXAMINE)) {
				controller.examine(param);
			} else if (action.startsWith(CommandParser.EXIT_TO)) {
				controller.exitTo(param);
			} else if (action.startsWith(CommandParser.PICK_UP)) {
				controller.pickUp(param);
			} else if (action.startsWith(CommandParser.DROP)) {
				controller.drop(param);
			}
		}
		if (CommandParser.isBinaryCommand(command)) {
			String action = words[0];
			String param1 = words[1];
			String param2 = words[2];
			if (action.startsWith(CommandParser.USE_ON)) {
				controller.useOn(param1, param2);
			}
		}
	}
	
	void printCurrentState() {
		printLocation();
		printObjects();
		printExits();
	}
	
	void printLocation() {
		out.println("You are standing in " + model.currentLocation().name());
		out.println(model.currentLocation().describe());
		out.println();
	}
	
	void printObjects() {
		out.print("You see ");
		for (IGameObject object : model.currentLocation().objectsHere()) {
			out.print(object.name());
			out.print(", ");
		}
		out.println();
	}
	
	void printExits() {
		out.print("From here, you can go to: ");
		for (ILocation exit : model.currentLocation().exits()) {
			out.print(exit.name());
			out.print(", ");
		}
		out.println();
	}
	
}
