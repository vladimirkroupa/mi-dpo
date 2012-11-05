package cz.cvut.fit.dpo.adventure.model;


public abstract class AbstractGameObject implements IGameObject {

	private final String name;
	
	public AbstractGameObject(String name) {
		this.name = name;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public boolean isSame(IGameObject item) {
		return (this.name().equals(item.name()));
	}
	
}
