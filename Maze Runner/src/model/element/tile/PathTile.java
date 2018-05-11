package model.element.tile;

import java.awt.image.BufferedImage;

import model.Assets;

public class PathTile extends Tile{
	public PathTile() {
		
		super(Assets.path,0);
		
			}

	@Override
	public boolean isSolid() {
		return false;
	}
}
