package cz.cvut.fit.dpo.adventure.domain.pojo;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collections;
import java.util.Set;

import cz.cvut.fit.dpo.adventure.domain.Container;
import cz.cvut.fit.dpo.adventure.domain.Location;
import cz.cvut.fit.dpo.adventure.domain.PhysicalEntity;
import cz.cvut.fit.dpo.adventure.domain.delegates.EntityHolder;
import cz.cvut.fit.dpo.adventure.domain.delegates.Label;
import cz.cvut.fit.dpo.adventure.domain.delegates.StaticNarrator;
import cz.cvut.fit.dpo.adventure.util.ReflectionObject;

public class LocationPojo extends ReflectionObject implements Location {

	private Set<Location> connectedLocations;
	
	// delegates
	private final Label label;
	private final StaticNarrator narrator; // TODO - supertype?
	private final Container entitiesPresent;
	
	public LocationPojo( Builder builder ) {
		label = new Label( checkNotNull( builder.name ) );
		narrator = new StaticNarrator( checkNotNull( builder.description ), checkNotNull( builder.longDescription ) );
		entitiesPresent = new EntityHolder();
	}

	@Override
	public String name() {
		return label.name();
	}
	
	@Override
	public Set<PhysicalEntity> entitiesPresent() {
		return entitiesPresent.entitiesPresent();
	}
	
	@Override
	public void moveFromHereTo( PhysicalEntity entity, Container destination ) {
		entitiesPresent.moveFromHereTo( entity, destination );
	}
	
	@Override
	public void put( PhysicalEntity entity ) {
		entitiesPresent.put( entity );
	}
	
	@Override
	public String description() {
		return narrator.description();
	}
	
	@Override
	public String longDescription() {
		return narrator.longDescription();
	}
	
	@Override
	public Set<Location> reachableLocations() {
		return Collections.unmodifiableSet( connectedLocations ); // TODO: sloziteji?
	}
	
	public static class Builder {
		
		private String name;
		private String description;
		private String longDescription;

		public Builder() {
		}

		public Builder withName( String name ) {
			this.name = name;
			return this;
		}
		
		public Builder withDescription( String description ) {
			this.description = description;
			return this;
		}
		
		public Builder withLongDescription( String longDescription ) {
			this.longDescription = longDescription;
			return this;
		}
		
	}
	
}
