package cz.cvut.fit.dpo.adventure.model.observer;

public class ErrorEvent implements IGameEvent {

	private final String description;

	public ErrorEvent(String description) {
		this.description = description;
	}

	@Override
	public String description() {
		return description;
	}

	@Override
	public boolean shouldUpdateState() {
		return false;
	}
	
}
