package model.element.tile;

import model.Assets;

public class TreeTile extends Tile{
	public TreeTile() {
		super(Assets.tree,2);
	}

	@Override
	public boolean isSolid() {	
		return false;
	}
}
