package model.element.tile;

import java.awt.Point;
import java.awt.image.BufferedImage;

import model.Assets;

public class PathTile extends Tile{
	public PathTile(Point p) {
		
		super(Assets.path,p);

			}


	@Override
	public boolean isSolid() {
		return false;
	}
}
