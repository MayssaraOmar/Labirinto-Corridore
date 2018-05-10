package model;

import java.awt.Point;

import model.tiles.PathTile;
import model.tiles.StoneTile;
import model.tiles.TreeTile;

public class ElementFactory {

	public Element getElement(int type, Point p) {

	/*	if (type == 0)
			return new PathTile();
		else if (type == 1)
			return new StoneTile();
		else if (type == 2)
			return new TreeTile();
		else*/ if (type == 3)
			return new HealthGift(p);
		else if (type == 4)
			return new ScoreGift(p);
		else if (type == 5)
			return new BulletGift(p);
		else if (type == 6)
			return new ArmorGift(p);
		else
			//return new PathTile(); // default tile
return null;
	}

}
