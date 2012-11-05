package cz.cvut.fit.dpo.adventure.model.observer;

public interface IGameEvent {

	String description();

	boolean shouldUpdateState();
	
}
