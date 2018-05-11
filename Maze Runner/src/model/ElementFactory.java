package model;

import java.awt.Point;

import model.element.tile.PathTile;
import model.element.tile.StoneTile;
import model.element.tile.TreeTile;

public class ElementFactory {

	public Element getElement(int type, Point p) {

		if (type == 0)
			return (Element) new PathTile();
		else if (type == 1)
			return (Element) new StoneTile();
		else if (type == 2)
			return (Element) new TreeTile();
		
		else
			return (Element) new PathTile(); // default tile

	}

}