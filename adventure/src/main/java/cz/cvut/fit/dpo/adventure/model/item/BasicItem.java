package cz.cvut.fit.dpo.adventure.model.item;

import java.util.HashMap;
import java.util.Map;

import cz.cvut.fit.dpo.adventure.model.BasicGameObject;
import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.facade.GameModelSpiFacade;
import cz.cvut.fit.dpo.adventure.model.manipulation.ItemInteraction;


public class BasicItem implements IGameObject {

	private BasicGameObject descriptions;
	
	
	public BasicItem(String name, String description) {
		this.descriptions = new BasicGameObject(name, description);
	}


	@Override
	public void examine(GameModelSpiFacade game) {
		
	}

	@Override
	public boolean pickUp(GameModelSpiFacade game) {

	}

	@Override
	public void manipulate(GameModelSpiFacade game) {
		// od nothing
	}

	@Override
	public String name() {
		return descriptions.name();
	}

}
