package model.element;

import java.awt.Point;

import model.element.entity.Runner;
import model.element.tile.PathTile;
import model.element.tile.StoneTile;
import model.element.tile.TreeTile;

public class ElementFactory {

	public static Element getElement(int type,Point p) {

		if (type == 0)
			return new PathTile(p);
		if (type == 1)
			return new StoneTile(p);
		if (type == 2)
			return new TreeTile(p);
		if (type == 3)
			return Runner.getRunner(p);

		return new PathTile(p); // default tile

	}

}
