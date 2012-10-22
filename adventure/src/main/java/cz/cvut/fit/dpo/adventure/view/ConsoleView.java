package cz.cvut.fit.dpo.adventure.view;

import java.io.PrintStream;

import cz.cvut.fit.dpo.adventure.model.GameObject;
import cz.cvut.fit.dpo.adventure.model.ILocation;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelFacade;
import cz.cvut.fit.dpo.adventure.model.observer.IGameEvent;

public class ConsoleView implements GameView {

	private GameModelFacade model;
	
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
	public void gameEventOccured(IGameEvent event) {
		out.println(event.decsription());
		out.println();
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
		for (ILocation exit : model.currentLocation().exits()) {
			out.print(exit.name());
			out.print(", ");
		}
		out.println();
	}
	
}
