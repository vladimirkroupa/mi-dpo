package cz.cvut.fit.dpo.adventure.model;


public interface IGameObject extends GameObjectState, HasName {

	boolean isSame(IGameObject item);
	
}
