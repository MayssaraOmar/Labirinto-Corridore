package model.element.entity;

import java.awt.List;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import controller.Game;
import model.Assets;
import model.Maze;
import model.element.tile.Tile;

public class Runner extends Entity{
	private static Runner uniqueRunner = null;	
	//n7ot-ha tb3 state l health
	//private Game game; 
	//private Maze maze;
	private int velocity ;
	private int health ;
	private int score;
	private int xMove,yMove;
	private ArrayList<Integer> bullets;
	
	// singleton DP
	public static Runner getRunner() {
		if(uniqueRunner == null)
			uniqueRunner = new Runner(Assets.runner);
		return uniqueRunner;
		
	}
	
	private Runner(BufferedImage bufferedImage) {
		super(Assets.runner);
		//this.game = game;
		//maze = Maze.getMaze("maze.txt");
		bullets = new ArrayList<Integer>(6);
		health = 3;
		velocity = 10;
		score = 0;
		width = 50;
		height = 50;
		xMove = 0;
		yMove = 0;
	//	RunnerImg = l mfrood n-get l image mn l spritesheet ely hn7mlha mn l game
		
	}	
	
	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		
		if(xMove > 0) {
			//int tx =  (point.x + xMove + bounds.x+bounds.width)/Tile.TILEWIDTH;
			/*if(!collisionWithTile(tx,( point.y+bounds.y)/Tile.TILEHEIGHT) && !collisionWithTile(tx,( point.y+bounds.y+bounds.height)/Tile.TILEHEIGHT)) {
					point.x += xMove;
				}*/
			//point.x += xMove;
			
		}else if(xMove < 0){System.out.println("shaml");
			
		}
		
		
		point.x += xMove;
	}
	
	public void moveY() {
		point.y += yMove;
	}
	
	/*private boolean collisionWithTile(int x,int y) {
		return maze.getTile(x, y).isSolid();
	}*/
	
	public void tick() {
		System.out.println("TICK Runner\n");

		getMove();
		move();
			
	}
	//getInput Move
	public void getMove() {
		System.out.println("GET MOOVE\n");
		xMove = 0;
		yMove = 0;
	
		if(Game.getKeyManager().up) {			
			yMove -= velocity;
			xMove += velocity;
		}
			
		else if(Game.getKeyManager().down) {
			yMove += velocity;
			xMove -= velocity;
		}
			
		else if(Game.getKeyManager().left) {
			xMove -= velocity;
			yMove -= velocity;
		}
			
		else if(Game.getKeyManager().right) {
			xMove += velocity;
			yMove += velocity;
			
		}
	}
	
	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ArrayList<Integer> getBullets() {
		return bullets;
	}

	public void setBullets(ArrayList<Integer> bullets) {
		this.bullets = bullets;
	}

	
	
	
}

