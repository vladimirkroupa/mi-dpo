package cz.cvut.fit.dpo.adventure.world1.tree;

import cz.cvut.fit.dpo.adventure.model.GameState;
import cz.cvut.fit.dpo.adventure.model.IGameObject;
import cz.cvut.fit.dpo.adventure.model.manipulation.ItemInteraction;

public class ThrowStickAtTree implements ItemInteraction {

	private final IGameObject stick;
	private final IGameObject tree;
	
	public ThrowStickAtTree(IGameObject stick, IGameObject tree) {
		this.stick = stick;
		this.tree = tree;
	}

	@Override
	public void useOn(IGameObject target, IGameObject object, GameState game) {
		game.removeFromInventory(object);
	}

	@Override
	public String description() {
		return "You threw stick into the branches. An apple fell down.";
	}

	@Override
	public IGameObject target() {
		return tree;
	}

	@Override
	public IGameObject object() {
		return stick;
	}


}
