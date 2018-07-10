package model;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import controller.BulletObserver;
import controller.GameState;
import controller.HealthObserver;
import controller.Observer;
import controller.ScoreObserver;
import controller.Utils;
import model.element.Element;
import model.element.ElementFactory;
import model.element.entity.Runner;
import model.element.tile.Tile;

public class SaveAndLoad {

	public static int[][] loadFile(String path) {

		int elementsTypes[][] = null;
		try {
			Observer bulletObs = new BulletObserver();
			Observer scoreObs = new ScoreObserver();
			Observer healthObs = new HealthObserver();
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			String line;
			int currentRow = 0;
			line = bufferedReader.readLine();
			if(line!=null) {
			String[] tokens = line.split("\\s");
			Maze.MAZE_WIDTH = Integer.parseInt(tokens[0]);
			Maze.MAZE_HEIGHT = Integer.parseInt(tokens[1]);
			elementsTypes = new int[Maze.MAZE_WIDTH][Maze.MAZE_HEIGHT];

			}
			while ((line = bufferedReader.readLine()) != null) {
				String[] tokens = line.split("\\s");
				/*if (Maze.MAZE_WIDTH == -1 && Maze.MAZE_HEIGHT == -1) {
					Maze.MAZE_WIDTH = Integer.parseInt(tokens[0]);
					Maze.MAZE_HEIGHT = Integer.parseInt(tokens[1]);
					elementsTypes = new int[Maze.MAZE_WIDTH][Maze.MAZE_HEIGHT];
				}else*/ if ( currentRow < Maze.MAZE_HEIGHT) {
					
					for (int i = 0; i < Maze.MAZE_WIDTH; i++) {
						int type = Integer.parseInt(tokens[i]);
					//System.out.println(currentRow+" "+type+ " "+i);
						elementsTypes[currentRow][i] = type;

					}
					currentRow++;
				} else {

					Runner.getRunner().setScore(Integer.parseInt(tokens[0]));
					Runner.getRunner().setBullets(Integer.parseInt(tokens[1]));
					Runner.getRunner().setHealth(Integer.parseInt(tokens[2]));
					Runner.getRunner()
							.setPointFile(new Point(Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
					//System.out.println(Long.parseLong(tokens[5]));
					//Runner.getRunner().getGame().setMyTimer(Long.parseLong(tokens[5]));
					
				}
			}

			scoreObs.update(Runner.getRunner().getScore());
			healthObs.update(Runner.getRunner().getHealth());
			bulletObs.update(Runner.getRunner().getBullets());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println("health"+Runner.getRunner().getHealth());
		
		Maze.getMaze().loadMaze(elementsTypes);
		return elementsTypes;
	}

	public static void saveFile(String path) {
		if (Maze.MAZE_WIDTH == -1 || Maze.MAZE_HEIGHT == -1)
			return;
		int elementsTypes[][] = new int[Maze.MAZE_WIDTH][Maze.MAZE_HEIGHT];
		for (int i = 0; i < Maze.MAZE_WIDTH; i++) {
			for (int j = 0; j < Maze.MAZE_HEIGHT; j++)
				elementsTypes[i][j] = 0;
		}
		for (int i = 0; i < GameState.elements.size(); i++) {
			Element e = GameState.elements.get(i);
			if (e instanceof Runner) {
				Point p;
				p = Utils.toGrid(e.getPoint().x, e.getPoint().y);
				elementsTypes[p.x + 1][p.y + 1] = e.getID();
				//System.out.println(p.x, p.y);
				//System.out.println("position after loading "+Utils.toGrid(Runner.getRunner().getPoint().x,Runner.getRunner().getPoint().y).x);

			} else {
				Point p = e.getPointFile();
				elementsTypes[p.x][p.y] = e.getID();
			}

		}
		try {
			String line;
			File file = new File(path);
			// file.getParentFile().mkdirs();

			PrintWriter printWriter = new PrintWriter(file);
			line = Integer.toString(Maze.MAZE_WIDTH) + " " + Integer.toString(Maze.MAZE_HEIGHT);
			printWriter.println(line);
			for (int i = 0; i < Maze.MAZE_WIDTH; i++) {
				for (int j = 0; j < Maze.MAZE_HEIGHT; j++) {
					printWriter.print(elementsTypes[i][j]);
					if(j!=Maze.MAZE_HEIGHT-1)printWriter.print(" ");
				}
				printWriter.println();
			}
			
			line = Runner.getRunner().getScore() + " " + Runner.getRunner().getBullets() + " " + Runner.getRunner().getHealth()
					+ " " + Runner.getRunner().getPointFile().x + " " + Runner.getRunner().getPointFile().y;
					;
			printWriter.print(line);
			//printWriter.print(Runner.getRunner().getGame().getMyTimer().getSec());

			printWriter.close();
			
			/*
			 * 
			 * int currentRow = 0; while ((line = bufferedReader.readLine()) != null) {
			 * String[] tokens = line.split("\\s"); if (Maze.MAZE_WIDTH == -1 &&
			 * Maze.MAZE_HEIGHT == -1) { Maze.MAZE_WIDTH = Integer.parseInt(tokens[0]);
			 * Maze.MAZE_HEIGHT = Integer.parseInt(tokens[1]);
			 * 
			 * elementsTypes = new int[Maze.MAZE_WIDTH][Maze.MAZE_HEIGHT]; }
			 * 
			 * else if(currentRow<Maze.MAZE_HEIGHT) {
			 * 
			 * for (int i = 0; i < Maze.MAZE_WIDTH; i++) { int type =
			 * Integer.parseInt(tokens[i]); elementsTypes[currentRow][i] = type;
			 * 
			 * } currentRow++; } else {
			 * 
			 * Runner.getRunner().setScore(Integer.parseInt(tokens[0]));
			 * Runner.getRunner().setBullets(Integer.parseInt(tokens[1]));
			 * Runner.getRunner().setHealth(Integer.parseInt(tokens[2]));
			 * Runner.getRunner().setPointFile(new Point(Integer.parseInt(tokens[3]),
			 * Integer.parseInt(tokens[4]))); } }
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
