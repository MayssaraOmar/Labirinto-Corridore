package model.element.tile;

import java.awt.Point;

import model.Assets;

public class TreeTile extends Tile{
	public TreeTile(Point p) {
		super(Assets.tree,p);
	}

	@Override
	public boolean isSolid() {	
		return true;
	}
}
