package model.element.tile;

import model.Assets;

public class TreeTile extends Tile{
	public TreeTile() {
		super(Assets.tree);
		ID = 2;
	}

	@Override
	public boolean isSolid() {	
		return true;
	}
	public boolean isDestroyable() {
		return true;
	}
	
}
