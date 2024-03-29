package cz.cvut.fit.dpo.adventure.world1;

import cz.cvut.fit.dpo.adventure.model.GameState;
import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.manipulation.ItemInteraction;

public class ThrowStickAtTree implements ItemInteraction {

	@Override
	public void useOn(IGameObject target, IGameObject object, GameState game) {
		game.removeFromInventory(object);
		IGameObject apple = World1Definition.getInstance().findItem("apple");
		game.currentLocation().spawn(apple);
	}

	@Override
	public String description() {
		return "You threw the stick into the branches. An apple fell down.";
	}

}
