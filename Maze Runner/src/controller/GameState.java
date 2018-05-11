package controller;

import java.awt.Graphics;
import java.awt.Point;

import model.Maze;
import model.element.entity.Player;
import model.element.tile.Tile;

public class GameState extends State{

	
	private Maze maze;
	private Player player;
	
	public GameState(Game game) {
		super(game);
		Point p = new Point(2,28);		
		maze = Maze.getMaze("maze.txt");
		player = Player.getPlayer(game,p);
		
	}

	@Override
	public void tick() {
		//runner  tick
		maze.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		
		maze.render(g);
		player.render(g);
	}

	
}
