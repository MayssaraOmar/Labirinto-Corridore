package model.element.tile;

import java.awt.image.BufferedImage;

import model.Assets;

public class PathTile extends Tile{
	public PathTile() {
		
		super(Assets.path,0);
		
		//System.out.println(Assets.path+" path");

	}

	@Override
	public boolean isSolid() {
		return false;
	}
}
