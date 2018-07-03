package controller;

import java.awt.Graphics;
import java.util.ArrayList;

import model.Maze;
import model.SaveAndLoad;
import model.element.Element;

public class GameState extends State{

	
	private Maze maze;
	public static GameState uniqueGameState = null;
	public static ArrayList<Element> elements = new ArrayList<>();
	
	private GameState(Game game) {
		super(game);		
		//int [][] elementsFile = SaveAndLoad.loadFile("maze.txt");
		//maze = Maze.getMaze(elementsFile);

	}
	public static GameState getGameState(Game game) {
		if(uniqueGameState == null) {
			uniqueGameState = new GameState(game);
						
		}return uniqueGameState;

		
	}
	
/*	public GameState(Game game) {
		super(game);		
		//int [][] elementsFile = SaveAndLoad.loadFile("maze.txt");
		//maze = Maze.getMaze(elementsFile);

	}
*/
	@Override
	public void tick() {
		maze.tick();
	}

	@Override
	public void render(Graphics g) {
		maze.render(g);
	}

	public void load(String path) {	
		System.out.println("DDDDDDDDDDDDDd");
		int [][] elementsFile = SaveAndLoad.loadFile(path);
		maze = Maze.getMaze();
	//	maze = new Maze(elementsFile);
	}
	
	
}
