package model;
import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import model.element.Element;
import model.element.tile.PathTile;
import model.element.tile.Tile;
import model.element.tile.TilesFactory;
import model.element.ElementFactory;

public class Maze {

	private static Maze uniqueMaze = null;
	private int MAZE_WIDTH, MAZE_HEIGHT;

	private Tile[][] baseTile;
	// private Tile[][] tiles;
	TilesFactory tilesFactory = new TilesFactory();
	private Element[][] elements;

	public static Maze getMaze(String path) {
		if(uniqueMaze == null) {
			uniqueMaze = new Maze(path);
		}
		return uniqueMaze;
	}
	
 	private Maze(String path) {// gets initialized and called in gamestate
 		MAZE_HEIGHT = -1;
 		MAZE_WIDTH = -1;
 		loadMaze(path);	

 	}
 
	public void loadBaseTile() {
		for (int cellY = 0; cellY < MAZE_HEIGHT; cellY++) {
			for (int cellX = 0; cellX < MAZE_WIDTH; cellX++) {
				baseTile[cellY][cellX] = tilesFactory.getTile(0);
			}
		}
		/*
		 * 
		 * for (int i = 0; i < MAZE_WIDTH; i) { for (int j = 0; j < MAZE_HEIGHT; j)
		 * { baseTile[i][j] = tilesFactory.getTile(0);
		 * 
		 * }
		 */
	}
 
 	public void loadMaze(String path) {	

 		try {
 			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
 			String line;
 			int currentRow = 0;
			TilesFactory tilesFactory = new TilesFactory();
 			while ((line = bufferedReader.readLine()) != null) {
 				String[] tokens = line.split("\\s");
 
 				if (MAZE_WIDTH == -1 && MAZE_HEIGHT == -1) {
 					MAZE_WIDTH = Integer.parseInt(tokens[0]);
 					MAZE_HEIGHT = Integer.parseInt(tokens[1]);
					baseTile = new Tile[MAZE_HEIGHT][MAZE_WIDTH];
					loadBaseTile();

					// tiles = new Tile[MAZE_HEIGHT][MAZE_WIDTH];
					elements = new Element[MAZE_HEIGHT][MAZE_WIDTH];
				}

				else {
					for (int i = 0; i < MAZE_WIDTH; i++) {
						// tiles[currentRow][i] = tilesFactory.getTile(Integer.parseInt(tokens[i]));
						// tiles[currentRow][i] = tilesFactory.getTile(0);
						elements[currentRow][i] = ElementFactory.getElement(Integer.parseInt(tokens[i]));


 					}
 					currentRow++;
 				}
 			}
			//tiles[20][20] = tilesFactory.getTile(2);
 		 
 		}catch (IOException e) {
 			e.printStackTrace();
 		}
 		
 		}
 		
 public void tick() {
 
 	}
 
//working if there was no entity
 	public Tile getTile(int x,int y) {
 		if(x<0 || y<0 || x>=MAZE_WIDTH || y>= MAZE_HEIGHT) {
 			return Tile.pathTile; 
 		}
 		Tile t = (Tile) elements[x][y];
 		if(t == null)
 			return Tile.pathTile;
 		return t;
 		
 	}

	/*
	 * public void render(Graphics g) {
	 * 
	 * for(int i=0; i<MAZE_HEIGHT; i) { for(int j=0; j<MAZE_WIDTH; j) {
	 * 
	 * tiles[i][j].render(g, i*Tile.TILEWIDTH, j*Tile.TILEHEIGHT);
	 * 
	 * }
	 * 
	 * 
	 * } }
	 */
 
				
	public void render(Graphics g) {


		for(int i=0; i<MAZE_HEIGHT; i++) { 
			for(int j=0; j<MAZE_WIDTH; j++) {
				elements[i][j].setPoint(new Point(i*Tile.TILEWIDTH,j*Tile.TILEHEIGHT ));
				
				elements[i][j].render(g); 
				elements[i][j].tick();
			}
		}
		
	/*	
		for (int x = 0; x < MAZE_WIDTH; x++) {
			for (int y = 0; y < MAZE_HEIGHT; y++) {
				int i = (x - y) * Tile.TILEWIDTH / 2;
				int j = (x + y) * Tile.TILEHEIGHT / 4;


	
				i += 925;
				j += 50;
				int fx = i;
				int fy = j;

				baseTile[x][y].setPoint(new Point(fx, fy));
				baseTile[x][y].render(g);

			}
		}
 */
	/*	for (int x = 0; x < MAZE_WIDTH; x++) {
			for (int y = 0; y < MAZE_HEIGHT; y++) {
 
				// for (int y = MAZE_HEIGHT - 1; y >= 0; y--) {
				int i = (x - y) * Tile.TILEWIDTH / 2;
				int j = (x + y) * Tile.TILEHEIGHT / 4;

				// 800 and 100 are temporary offsets I apply to center the map.

				i += 925;
				j += 50;

				int fx = i;//
				int fy = j;//
				if (!(elements[x][y] instanceof PathTile)) {
					fy -= Tile.TILEHEIGHT / 2;
					elements[x][y].setPoint(new Point(fx, fy));
					elements[x][y].tick();
					elements[x][y].render(g);
					// tiles[x][y].render(g, fx, fy);

				}

			}
		}*/
 	}
}