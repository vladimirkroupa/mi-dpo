package cz.cvut.fit.dpo.adventure.domain.delegates;

import java.util.Collections;
import java.util.Set;

import com.google.common.collect.Sets;

import cz.cvut.fit.dpo.adventure.domain.PhysicalEntity;
import cz.cvut.fit.dpo.adventure.domain.Container;
import cz.cvut.fit.dpo.adventure.util.ReflectionObject;

public class EntityHolder extends ReflectionObject implements Container {

	private final Set<PhysicalEntity> entitiesPresent;
	
	public EntityHolder() {
		entitiesPresent = Sets.newHashSet();
	}

	@Override
	public Set<PhysicalEntity> entitiesPresent() {
		return Collections.unmodifiableSet( entitiesPresent );
	}

	@Override
	public synchronized void moveFromHereTo( PhysicalEntity entity, Container destination ) { // TODO sync on object's monitor?
		remove( entity );
		destination.put( entity );
	}

	@Override
	public void put( PhysicalEntity entity ) {
		entitiesPresent.add( entity );
	}

	private void remove( PhysicalEntity entity ) {
		if ( ! entitiesPresent.contains( entity ) ) {
			throw new IllegalArgumentException( entity.name() + "is not present, cannot be removed!" );
		}
		entitiesPresent.remove( entity );		
	}
	
}
