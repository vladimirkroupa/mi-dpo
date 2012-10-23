package cz.cvut.fit.dpo.adventure.model.observer;

public class GameEvent implements IGameEvent {

	private final String eventDescription;
	private final boolean updateLocation;
	
	public static GameEvent minorEvent(String description) {
		return new GameEvent(description, false);
	}
	
	public static GameEvent majorEvent(String description) {
		return new GameEvent(description, true);
	}
	
	public static GameEvent updateLocationEvent() {
		return new GameEvent("", true);
	}
	
	private GameEvent(String eventDescription, boolean refreshLocation) {
		this.eventDescription = eventDescription;
		this.updateLocation = refreshLocation;
	}

	@Override
	public String description() {
		return eventDescription;
	}
	
	@Override
	public boolean shouldUpdateState() {
		return updateLocation;
	}
	
}
