package model.element.tile;

import model.Assets;

public class TreeTile extends Tile{
	public TreeTile() {
		super(Assets.tree);
	}

	@Override
	public boolean isSolid() {	
		return true;
	}
}
