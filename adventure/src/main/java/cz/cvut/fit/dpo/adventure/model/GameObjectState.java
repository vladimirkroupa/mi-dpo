package cz.cvut.fit.dpo.adventure.model;

public interface GameObjectState {

	void examine();
	
	void pickUp();
	
	void manipulate();
	
	void useOn(GameObject item);
}
