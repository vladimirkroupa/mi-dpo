package cz.cvut.fit.dpo.adventure.model;

public class BasicGameObject implements HasName, HasDescription {

	private final String name;
	private final String description;
	
	public BasicGameObject(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String describe() {
		return description;
	}

	@Override
	public String name() {
		return name;
	}
	
}
