package controller;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import model.Maze;
import model.element.Element;
import model.element.tile.PathTile;
import model.element.tile.Tile;

public class GameState extends State{

	
	private Maze maze;
	public static ArrayList<Element> elements = new ArrayList<>();
	
	public GameState(Game game) {

		super(game);
		maze = Maze.getMaze("maze.txt");
		
	}

	@Override
	public void tick() {
		maze.tick();
	}

	@Override
	public void render(Graphics g) {
		maze.render(g);
	}
//TODO Mazewidth
	 public static Tile getTile(int x, int y) { if (x < 0 || y < 0 || x >= 30 ||
			  y >= 30) { return new PathTile(new Point(0,0)); } 
			  Tile t = null;
			  for(int i=0;i<GameState.elements.size();i++) {
				  if(GameState.elements.get(i).getPoint().x == x && GameState.elements.get(i).getPoint().y == y ) {
					    t = (Tile) GameState.elements.get(i);
				  }
			  }	  
			
			  if (t == null) return new PathTile(new Point(0,0));
			  return t;
			  
			  }
	
}
