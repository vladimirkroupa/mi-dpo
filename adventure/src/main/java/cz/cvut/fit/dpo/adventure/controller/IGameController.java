package cz.cvut.fit.dpo.adventure.controller;

public interface IGameController {

	void examine(String item);
	
	void exitTo(String location);
	
	void pickUp(String item);
	
	void drop(String item);
	
	void useOn(String what, String on);
	
	void newGame();
	
	void exitGame();
	
}
