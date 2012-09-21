package cz.cvut.fit.dpo.adventure.domain.delegates;

import cz.cvut.fit.dpo.adventure.util.ReflectionObject;

public class Label extends ReflectionObject {

	private final String name;
	
	public Label( String name ) {
		this.name = name;
	}

	public String name() {
		return name;
	}
	
}
