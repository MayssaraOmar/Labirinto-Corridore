package model.tiles;

import model.Assets;

public class TreeTile extends Tile{
	public TreeTile() {
		super(Assets.tree);
	}

	@Override
	public boolean isSolid() {	
		return false;
	}
}
