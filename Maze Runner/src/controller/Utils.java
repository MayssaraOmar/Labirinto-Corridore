package controller;

import java.awt.Point;

import model.Maze;
import model.element.tile.Tile;

public class Utils {
	
	public static Point toIso(int x, int y) {

		int i = (x - y) * Tile.TILEWIDTH / 2;
		int j = (x + y) * Tile.TILEHEIGHT / 4;

		// 925 and 50 are temporary offsets I apply to center the map.

		i += Maze.offsetX;
		j += Maze.offsetY;

		return new Point(i, j);

	}
	public static Point toGrid(int x, int y){

	    x-=Maze.offsetX;
	    y-=Maze.offsetY;
	    int i = ( x / ( Tile.TILEWIDTH / 2 ) + y / ( Tile.TILEHEIGHT / 4 )) / 2;
	    int j = ( y / ( Tile.TILEHEIGHT / 4 ) - ( x / ( Tile.TILEWIDTH / 2 ))) / 2;
	    return new Point(i,j);
	  }


}
