package cz.cvut.fit.dpo.adventure.model.strategy;

import cz.cvut.fit.dpo.adventure.model.GameObject;

public interface UseOnStrategy {

	void use(GameObject what, GameObject on);
	
}
