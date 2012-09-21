package cz.cvut.fit.dpo.adventure;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import cz.cvut.fit.dpo.adventure.domain.Location;
import cz.cvut.fit.dpo.adventure.domain.Person;
import cz.cvut.fit.dpo.adventure.domain.PhysicalEntity;
import cz.cvut.fit.dpo.adventure.domain.pojo.LocationPojo;
import cz.cvut.fit.dpo.adventure.domain.pojo.PersonPojo;

public class BasicTest {

	private Location hallway;
	private Location mainRoom;
	private Location bathroom;
	private Location toilets;
	private Person nobody; 
	
	@Before
	public void init() {
		String longDesc = "Nevim."; // TODO: null object?
		hallway = new LocationPojo( new LocationPojo.Builder().withName( "chodba" ).withDescription( "Uzka dlouha chodba." ).withLongDescription( longDesc ) );
		mainRoom = new LocationPojo( new LocationPojo.Builder().withName( "obyvaci pokoj" ).withDescription( "Hlavni pokoj v garsonce. Je zde kuchynsky kout, postel, knihovna a stul." ).withLongDescription( longDesc ) );
		bathroom = new LocationPojo( new LocationPojo.Builder().withName( "koupelna" ).withDescription( "Koupelna." ).withLongDescription( longDesc ) );
		toilets = new LocationPojo( new LocationPojo.Builder().withName( "zachod" ).withDescription( "Zachod." ).withLongDescription( longDesc ) );
		
		nobody = new PersonPojo( new PersonPojo.Builder().withName( "pan Nikdo" ).withDescription( "Nobody steals our chicks... and lives!" ).withLongDescription( longDesc ).withWeight( 75 ).withStartingLocation( mainRoom ) );
	}
	
	@Test
	public void walkAround() {
		assertThat( (PhysicalEntity)nobody ).isIn( mainRoom.entitiesPresent() );
		assertThat( nobody.location() ).isEqualTo( mainRoom );
		
		nobody.goTo( hallway );
		assertThat( (PhysicalEntity)nobody ).isNotIn( mainRoom.entitiesPresent() );
		assertThat( (PhysicalEntity)nobody ).isIn( hallway.entitiesPresent() );
		assertThat( nobody.location() ).isEqualTo( hallway );
		
		nobody.goTo( bathroom );
		assertThat( (PhysicalEntity)nobody ).isNotIn( mainRoom.entitiesPresent() );
		assertThat( (PhysicalEntity)nobody ).isNotIn( hallway.entitiesPresent() );
		assertThat( (PhysicalEntity)nobody ).isIn( bathroom.entitiesPresent() );
		assertThat( nobody.location() ).isEqualTo( bathroom );
		
		nobody.goTo( toilets );
		assertThat( (PhysicalEntity)nobody ).isNotIn( mainRoom.entitiesPresent() );
		assertThat( (PhysicalEntity)nobody ).isNotIn( hallway.entitiesPresent() );
		assertThat( (PhysicalEntity)nobody ).isNotIn( bathroom.entitiesPresent() );
		assertThat( (PhysicalEntity)nobody ).isIn( toilets.entitiesPresent() );
		assertThat( nobody.location() ).isEqualTo( toilets );
		
		nobody.goTo( bathroom );
		assertThat( (PhysicalEntity)nobody ).isNotIn( mainRoom.entitiesPresent() );
		assertThat( (PhysicalEntity)nobody ).isNotIn( hallway.entitiesPresent() );
		assertThat( (PhysicalEntity)nobody ).isNotIn( toilets.entitiesPresent() );
		assertThat( (PhysicalEntity)nobody ).isIn( bathroom.entitiesPresent() );
		assertThat( nobody.location() ).isEqualTo( bathroom );
		
		nobody.goTo( hallway );
		assertThat( (PhysicalEntity)nobody ).isNotIn( mainRoom.entitiesPresent() );
		assertThat( (PhysicalEntity)nobody ).isNotIn( toilets.entitiesPresent() );
		assertThat( (PhysicalEntity)nobody ).isNotIn( bathroom.entitiesPresent() );
		assertThat( (PhysicalEntity)nobody ).isIn( hallway.entitiesPresent() );
		assertThat( nobody.location() ).isEqualTo( hallway );
	}
	
}
