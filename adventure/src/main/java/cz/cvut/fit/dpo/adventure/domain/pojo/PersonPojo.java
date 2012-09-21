package cz.cvut.fit.dpo.adventure.domain.pojo;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Set;

import com.google.common.base.Preconditions;

import cz.cvut.fit.dpo.adventure.action.ActionResult;
import cz.cvut.fit.dpo.adventure.domain.Container;
import cz.cvut.fit.dpo.adventure.domain.Location;
import cz.cvut.fit.dpo.adventure.domain.Person;
import cz.cvut.fit.dpo.adventure.domain.PhysicalEntity;
import cz.cvut.fit.dpo.adventure.domain.delegates.EntityHolder;
import cz.cvut.fit.dpo.adventure.domain.delegates.Label;
import cz.cvut.fit.dpo.adventure.domain.delegates.Narrator;
import cz.cvut.fit.dpo.adventure.domain.delegates.StaticNarrator;
import cz.cvut.fit.dpo.adventure.util.ReflectionObject;

public class PersonPojo extends ReflectionObject implements Person {

	private final int baseWeight;
	private final Location location;
	
	// delegates
	private final Label label;
	private final Narrator narrator;
	private final Container pockets;
	
	public PersonPojo( Builder builder ) {
		label = new Label( checkNotNull( builder.name ) );
		narrator = new StaticNarrator( checkNotNull( builder.description ), checkNotNull( builder.longDescription ) );
		pockets = new EntityHolder();
		
		baseWeight = checkNotNull( builder.weight );
		location = checkNotNull( builder.startingLocation );
		Preconditions.checkState( location.entitiesPresent().contains( this ), "The starting location does not contain this Person." );
	}
	
	@Override
	public void put( PhysicalEntity item ) {
		pockets.put( item );
	}

	@Override
	public void moveFromHereTo( PhysicalEntity item, Container destination ) {
		pockets.moveFromHereTo( item, destination );
	}

	@Override
	public Set<PhysicalEntity> entitiesPresent() {
		return pockets.entitiesPresent();
	}
	
	@Override
	public String name() {
		return label.name();
	}
	
	@Override
	public Integer weight() {
		return baseWeight + carriedWeight();
	}
	
	private Integer carriedWeight() {
		int itemWeight = 0;
		for ( PhysicalEntity item : entitiesPresent() ) {
			itemWeight += item.weight();
		}
		return itemWeight;
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
	public ActionResult goTo( Location destination ) {
		location.moveFromHereTo( this, destination );
		throw new UnsupportedOperationException( "TODO" );
	}
	
	@Override
	public Location location() {
		return location;
	}
	
	public static class Builder {
		
		private String name;
		private String description;
		private String longDescription;
		private Integer weight;
		private Location startingLocation;

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

		public Builder withWeight( Integer weight ) {
			this.weight = weight;
			return this;
		}

		public Builder withStartingLocation( Location startingLocation ) {
			this.startingLocation = startingLocation;
			return this;
		}
		
	}

}
