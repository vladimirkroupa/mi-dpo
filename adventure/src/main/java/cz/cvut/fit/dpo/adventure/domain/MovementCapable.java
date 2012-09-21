package cz.cvut.fit.dpo.adventure.domain;

import cz.cvut.fit.dpo.adventure.action.ActionResult;

public interface MovementCapable {

	ActionResult goTo( Location destination );
	
}
