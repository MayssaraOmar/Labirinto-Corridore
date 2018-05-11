package controller;

import java.awt.Graphics;
import java.util.ArrayList;

import model.Maze;
import model.element.Element;

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

	
}
