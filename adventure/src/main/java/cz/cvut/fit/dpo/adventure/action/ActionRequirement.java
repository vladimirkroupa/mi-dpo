package cz.cvut.fit.dpo.adventure.action;

public interface ActionRequirement {

	Intent appliesTo();
	
	ActionResult check();
	
}
