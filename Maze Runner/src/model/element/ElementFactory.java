package model.element;

import model.element.tile.PathTile;
import model.element.tile.StoneTile;
import model.element.tile.Tile;
import model.element.tile.TreeTile;

public class ElementFactory {

	public static Element getElement(int type) {

		if (type == 0)
			return new PathTile();
		if (type == 1)
			return new StoneTile();
		if (type == 2)
			return new TreeTile();

		return new PathTile(); // default tile

	}

}
