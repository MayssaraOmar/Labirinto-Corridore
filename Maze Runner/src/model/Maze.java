package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import controller.GameState;
import controller.Utils;
import model.element.Element;
import model.element.tile.PathTile;
import model.element.tile.Tile;
import model.element.ElementFactory;
import model.element.entity.Runner;

public class Maze {

	private static Maze uniqueMaze = null;
	public static int MAZE_WIDTH = -1, MAZE_HEIGHT = -1, offsetX = 925, offsetY = 50;
	ArrayList<Element> base;
	private Comparator<Element> renderSorter = new Comparator<Element>() {
		@Override
		public int compare(Element a, Element b) {

			if (a.getPoint().y < b.getPoint().y)
				return -1;
			return 1;
		}
	};

	public static Maze getMaze() {
		if (uniqueMaze == null) {
			uniqueMaze = new Maze();
		}
		return uniqueMaze;
	}

	private Maze() {// gets initialized and called in gamestate
		
		base = new ArrayList<>();
		//loadMaze(elementsTypes);
	}

	public void loadMaze(int[][] elementsTypes) {

		int currentRow = 0;
		while (currentRow != MAZE_HEIGHT) {
			//System.out.println("load maze"+MAZE_HEIGHT);
			for (int i = 0; i < MAZE_WIDTH; i++) { 		

				int type = elementsTypes[currentRow][i];
				Element newElement = ElementFactory.getElement(0);
				newElement.setPoint(Utils.toIso(currentRow, i));
				base.add(newElement);

				if (type != 0) {
					Element newElement2 = ElementFactory.getElement(type);
					newElement2.setPoint(Utils.toIso(currentRow, i));
					newElement2.getPoint().y -= Tile.TILEHEIGHT / 2;
					newElement2.setPointFile(new Point(currentRow, i));
					GameState.elements.add(newElement2);

				}

			}
			currentRow++;
		}
	}

	/*
	 * public void loadMaze(String path) {
	 * 
	 * try { BufferedReader bufferedReader = new BufferedReader(new
	 * FileReader(path)); String line; int currentRow = 0; while ((line =
	 * bufferedReader.readLine()) != null) { String[] tokens = line.split("\\s");
	 * 
	 * if (MAZE_WIDTH == -1 && MAZE_HEIGHT == -1) { MAZE_WIDTH =
	 * Integer.parseInt(tokens[0]); MAZE_HEIGHT = Integer.parseInt(tokens[1]); }
	 * 
	 * else { for (int i = 0; i < MAZE_WIDTH; i++) { int type =
	 * Integer.parseInt(tokens[i]); Element newElement =
	 * ElementFactory.getElement(0); newElement.setPoint(Utils.toIso(currentRow,
	 * i)); base.add(newElement);
	 * 
	 * if (type != 0) { Element newElement2 = ElementFactory.getElement(type);
	 * newElement2.setPoint(Utils.toIso(currentRow, i)); newElement2.getPoint().y -=
	 * Tile.TILEHEIGHT / 2;
	 * 
	 * GameState.elements.add(newElement2);
	 * 
	 * }
	 * 
	 * } currentRow++; } }
	 * 
	 * } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * }
	 * 
	 */
	public void tick() {
		for (int x = 0; x < base.size(); x++) {
			base.get(x).tick();

		}
		for (int x = 0; x < GameState.elements.size(); x++) {
			GameState.elements.get(x).tick();
		}

		GameState.elements.sort(renderSorter);
	}

	public void render(Graphics g) { 
		for (int x = 0; x < base.size(); x++) {
			base.get(x).render(g);
		}

		for (int x = 0; x < GameState.elements.size(); x++) {

			GameState.elements.get(x).render(g);
		}

	}
	/*
	 * public static Point toIso(int x, int y) {
	 * 
	 * int i = (x - y) * Tile.TILEWIDTH / 2; int j = (x + y) * Tile.TILEHEIGHT / 4;
	 * 
	 * // 925 and 50 are temporary offsets I apply to center the map.
	 * 
	 * i += offsetX; j += offsetY;
	 * 
	 * return new Point(i, j);
	 * 
	 * } public static Point toGrid(int x, int y){
	 * 
	 * x-=offsetX; y-=offsetY; int i = ( x / ( Tile.TILEWIDTH / 2 ) + y / (
	 * Tile.TILEHEIGHT / 4 )) / 2; int j = ( y / ( Tile.TILEHEIGHT / 4 ) - ( x / (
	 * Tile.TILEWIDTH / 2 ))) / 2; return new Point(i,j); }
	 */
	// working if there was no entity

	/*
	 * public Tile getTile(int x, int y) { if (x < 0 || y < 0 || x >= MAZE_WIDTH ||
	 * y >= MAZE_HEIGHT) { return new PathTile(); } Tile t = (Tile);
	 * GameState.elements; if (t == null) return Tile.pathTile; return t;
	 * 
	 * }
	 */

}