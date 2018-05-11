package model;

import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import controller.GameState;
import model.element.Element;
import model.element.tile.PathTile;
import model.element.tile.Tile;
import model.element.ElementFactory;

public class Maze {

	private static Maze uniqueMaze = null;
	private int MAZE_WIDTH, MAZE_HEIGHT;
	public static int offsetX = 925, offsetY = 50;
	ArrayList<Element> base;
	private Comparator <Element> renderSorter = new Comparator<Element>() {
		@Override 
		public int compare(Element a, Element b) {
			
			if(a.getPoint().y < b.getPoint().y)
				return -1;
			return 1;
	}};

	public static Maze getMaze(String path) {
		if (uniqueMaze == null) {
			uniqueMaze = new Maze(path);
		}
		return uniqueMaze;
	}

	private Maze(String path) {// gets initialized and called in gamestate
		MAZE_HEIGHT = -1;
		MAZE_WIDTH = -1;
		base = new ArrayList<>();
		loadMaze(path);
	}


	public void loadMaze(String path) {

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			String line;
			int currentRow = 0;
			while ((line = bufferedReader.readLine()) != null) {
				String[] tokens = line.split("\\s");

				if (MAZE_WIDTH == -1 && MAZE_HEIGHT == -1) {
					MAZE_WIDTH = Integer.parseInt(tokens[0]);
					MAZE_HEIGHT = Integer.parseInt(tokens[1]);
				}

				else {
					for (int i = 0; i < MAZE_WIDTH; i++) {
						int type = Integer.parseInt(tokens[i]);
						Element newElement = ElementFactory.getElement(0,toIso(currentRow, i));
					//	newElement.setPoint(toIso(currentRow, i));
						base.add(newElement);

						if (type != 0) {
							Element newElement2 = ElementFactory.getElement(type,toIso(currentRow, i));
						//	newElement2.setPoint(toIso(currentRow, i));
							newElement2.getPoint().y -= Tile.TILEHEIGHT / 2;
							GameState.elements.add(newElement2);


						}

					}
					currentRow++;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public Point toIso(int x, int y) {
		 
		int i = (x - y) * Tile.TILEWIDTH / 2;
		int j = (x + y) * Tile.TILEHEIGHT / 4;

		// 925 and 50 are temporary offsets I apply to center the map.

		i += offsetX;
		j += offsetY;


		return new Point(i, j);

	}

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

	// working if there was no entity
	/*
	  public Tile getTile(int x, int y) { if (x < 0 || y < 0 || x >= MAZE_WIDTH ||
	  y >= MAZE_HEIGHT) { return new PathTile(); } 
	  Tile t = null;
	  for(int i=0;i<GameState.elements.size();i++) {
		  if(GameState.elements.get(i).getPoint().x == x && GameState.elements.get(i).getPoint().y == y ) {
			    t = (Tile) GameState.elements.get(i);
		  }
	  }	  
	
	  if (t == null) return new PathTile();
	  return t;
	  
	  }*/
	

}