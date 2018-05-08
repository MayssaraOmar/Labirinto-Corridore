package model;

import model.tiles.Tile;

public class Maze {
	
	private int MAZE_WIDTH, MAZE_HEIGHT;
	
	private Tile[][] tiles;
	
	public Maze() {
		tiles = new Tile[MAZE_WIDTH][MAZE_HEIGHT];
		loadMaze();
	}
	
	public void loadMaze() {
		// read maze and its size from file
	}
	
	public void tick() {
		
	}
	public void render() {
		
	}

}
