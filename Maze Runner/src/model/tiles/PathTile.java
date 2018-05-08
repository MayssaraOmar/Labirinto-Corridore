package model.tiles;

import model.Assets;

public class PathTile extends Tile{
	public PathTile() {
		super(Assets.stone);
	}

	@Override
	public boolean isSolid() {
		return false;
	}
}
