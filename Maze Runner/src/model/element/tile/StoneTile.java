package model.element.tile;

import java.awt.Point;

import model.Assets;

public class StoneTile extends Tile {

	public StoneTile(Point p) {
		super(Assets.stone,p);
	}

	@Override
	public boolean isSolid() {
		
		return true;
	}

}
