package cz.cvut.fit.dpo.strategy.util;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Object subclass using commons-lang's reflection builder to implement equals, hashCode and toString methods.
 * 
 */
public abstract class ReflectionObject {

	private static final Logger log = LoggerFactory.getLogger( ReflectionObject.class );
	
	@Override
	public int hashCode() {
		//log.debug( "Invoked reflection-based implementation of hashCode()." );
		return HashCodeBuilder.reflectionHashCode( this );
	}

	@Override
	public boolean equals( Object obj ) {
		//log.debug( "Invoked reflection-based implementation of equals() ." );
		return EqualsBuilder.reflectionEquals( this, obj );
	}

	@Override
	public String toString() {
		//log.debug( "Invoked reflection-based implementation of toString()." );
		return ToStringBuilder.reflectionToString( this );
	}
	
}
