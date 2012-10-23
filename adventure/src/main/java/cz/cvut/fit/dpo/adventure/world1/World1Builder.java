package cz.cvut.fit.dpo.adventure.world1;

import java.util.List;

import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.Location;
import cz.cvut.fit.dpo.adventure.model.builder.WorldBuilder;

public class World1Builder implements WorldBuilder {

	private final Location initial;
	
	public static final Stick STICK = new Stick();
	
	public World1Builder() {
		super();
	}

	@Override
	public Location initialLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IGameObject> initialInventory() {

	}

}
