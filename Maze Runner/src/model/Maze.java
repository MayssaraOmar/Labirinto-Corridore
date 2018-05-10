package model;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.tiles.GiftsFactory;
import model.tiles.Tile;
import model.tiles.TilesFactory;

public class Maze {

	
	private int MAZE_WIDTH, MAZE_HEIGHT ;
	
	private Tile[][] tiles;
	private List<Entity> entities;
	
	public Maze(String path) {// gets initialized and called in gamestate
		MAZE_HEIGHT = -1;
		MAZE_WIDTH = -1;
		entities = new ArrayList<>();
		loadMaze(path);		
	}

	public void loadMaze(String path) {
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			String line;
			int currentRow = 0;
			TilesFactory tilesFactory = new TilesFactory();
			GiftsFactory giftsFactory = new GiftsFactory(); 
			while ((line = bufferedReader.readLine()) != null) {
				String[] tokens = line.split("\\s+");

				if (MAZE_WIDTH == -1 && MAZE_HEIGHT == -1) {
					MAZE_WIDTH = Integer.parseInt(tokens[0]);
					MAZE_HEIGHT = Integer.parseInt(tokens[1]);
					tiles = new Tile[MAZE_HEIGHT][MAZE_WIDTH];

				}
			
				else {
					for(int i=0; i<MAZE_WIDTH; i++) {
						tiles[currentRow][i] = tilesFactory.getTile(Integer.parseInt(tokens[i]));
						if(Integer.parseInt(tokens[i])>=3 && Integer.parseInt(tokens[i])<=6) {
						//	entities.add(giftsFactory.getGift(Integer.parseInt(tokens[i]), ));
						}
						
					}
					currentRow++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void tick() {

	}


	public void render(Graphics g) { 				

		for(int i=0; i<MAZE_HEIGHT; i++) { 
			for(int j=0; j<MAZE_WIDTH; j++) {
				tiles[i][j].render(g, i*Tile.TILEWIDTH, j*Tile.TILEHEIGHT); 
	
	}


}
	}
	}
