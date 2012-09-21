package cz.cvut.fit.dpo.adventure.domain.delegates;

import cz.cvut.fit.dpo.adventure.util.ReflectionObject;

/**
 * Implementation of {@link EntityWithDescription} that always returns values set during construction.
 * 
 */
public class StaticNarrator extends ReflectionObject implements Narrator {

	private final String description;
	private final String longDescription;
	
	public StaticNarrator( String description, String longDescription ) {
		this.description = description;
		this.longDescription = description;
	}
	
	@Override
	public String description() {
		return description;
	}

	@Override
	public String longDescription() {
		return longDescription;
	}
	
}
