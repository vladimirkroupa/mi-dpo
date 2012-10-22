package cz.cvut.fit.dpo.adventure.model.observer;

public interface Observable {

	void registerObserver(GameEventObserver observer);
	
	void removeObserver(GameEventObserver observer);

}
