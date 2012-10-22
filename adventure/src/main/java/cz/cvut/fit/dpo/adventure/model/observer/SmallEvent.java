package cz.cvut.fit.dpo.adventure.model.observer;

public class SmallEvent implements IGameEvent {

	private final String eventDescription;
	
	public SmallEvent(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	@Override
	public String description() {
		return eventDescription;
	}

}
