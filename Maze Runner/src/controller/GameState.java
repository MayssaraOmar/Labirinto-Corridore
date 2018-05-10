package controller;

import java.awt.Graphics;

import model.Maze;

public class GameState extends State{

	
	private Maze maze;
	public GameState(Game game) {
		super(game);
		maze = new Maze("maze.txt");
		// new runner
		
	}

	@Override
	public void tick() {
		//runner  tick
		maze.tick();
	}

	@Override
	public void render(Graphics g) {
		
		maze.render(g);
	}

	
}
