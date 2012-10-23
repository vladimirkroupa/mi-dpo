package cz.cvut.fit.dpo.adventure.model.strategy.useon;

import cz.cvut.fit.dpo.adventure.model.IGameObject;

public class ItemPair {

	private final IGameObject item1;
	private final IGameObject item2;
	
	public ItemPair(IGameObject item1, IGameObject item2) {
		this.item1 = item1;
		this.item2 = item2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item1 == null) ? 0 : item1.hashCode());
		result = prime * result + ((item2 == null) ? 0 : item2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPair other = (ItemPair) obj;
		if (item1 == null || item2 == null) {
			return false;
		}
		if (this.item1.isSame(other.item1) && this.item2.isSame(other.item2))
			return true;
		if (this.item1.isSame(other.item2) && this.item2.isSame(other.item1))
			return true;
		return false;
	}
	
	
}
