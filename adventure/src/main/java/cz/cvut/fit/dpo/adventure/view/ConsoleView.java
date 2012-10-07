package cz.cvut.fit.dpo.adventure.view;

import java.io.PrintStream;

import cz.cvut.fit.dpo.adventure.model.GameFacade;
import cz.cvut.fit.dpo.adventure.model.GameObject;
import cz.cvut.fit.dpo.adventure.model.Location;
import cz.cvut.fit.dpo.adventure.model.observer.GameEvent;

public class ConsoleView implements GameView {

	private GameFacade model;
	
	private PrintStream out;
	private boolean exit;

	public void run() {
		String command;
		while (! exit) {
			command = System.console().readLine();
			parseCommand(command);
		}
	}
	
	@Override
	public void gameEventOccured(GameEvent event) {
		out.println(event.decsription());
	}

	@Override
	public void parseCommand(String command) {
		throw new UnsupportedOperationException("TODO");
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
		for (GameObject object : model.currentLocation().objectsHere()) {
			out.print(object.name());
			out.print(", ");
		}
		out.println();
	}
	
	void printExits() {
		out.print("From here, you can go to: ");
		for (Location exit : model.currentLocation().exitBy()) {
			out.print(exit.name());
			out.print(", ");
		}
		out.println();
	}
	
}
