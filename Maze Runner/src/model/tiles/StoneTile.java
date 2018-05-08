package model.tiles;

import model.Assets;

public class StoneTile extends Tile {

	public StoneTile() {
		super(Assets.stone);
	}

	@Override
	public boolean isSolid() {
		
		return true;
	}

}
