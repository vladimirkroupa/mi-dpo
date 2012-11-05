package cz.cvut.fit.dpo.adventure.world1.location;

import cz.cvut.fit.dpo.adventure.model.Location;

public class Cave extends Location {

	private static final String NAME = "cave";
	private static final String DESCRIPTION = "You stand in a dark cave. A little light shines through a hole above you.";
	
	public Cave() {
		super(NAME, DESCRIPTION);
	}
	
}
