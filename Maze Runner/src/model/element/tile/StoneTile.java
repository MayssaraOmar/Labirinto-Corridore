package model.element.tile;

import model.Assets;

public class StoneTile extends Tile {

	public StoneTile() {
		super(Assets.stone,1);
	}

	@Override
	public boolean isSolid() {
		
		return true;
	}

}
