package model.element.entity;

import java.awt.List;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import controller.Game;
import controller.GameState;
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
	private int bullets;
	
	

	// singleton DP
	public static Runner getRunner(Point p) {
		if(uniqueRunner == null)
			uniqueRunner = new Runner(Assets.runner,p);
		return uniqueRunner;
		
	}
	
	private Runner(BufferedImage bufferedImage,Point p) {
		super(Assets.runner,15,15,p);
		//this.game = game;
		//maze = Maze.getMaze("maze.txt");
		bullets = 6;
		health = 3;
		velocity = 3;
		score = 0;
		width = 15;
		height = 15;
		xMove = 0;
		yMove = 0;
	//	RunnerImg = l mfrood n-get l image mn l spritesheet ely hn7mlha mn l game
		
	}	
	
	public void move() {
		moveX();
		moveY();
	/*
		point.x += xMove;
		point.y+=yMove;
				
	*/
	}

public void moveX() {
	if(xMove > 0) {System.out.println("to left");
		int tx =  (int)(point.x +  xMove+bounds.width )/Tile.TILEWIDTH;
		if(!collisionWithTile(tx,(int)( point.y)/Tile.TILEHEIGHT) && !collisionWithTile(tx,(int)( point.y+bounds.height)/Tile.TILEHEIGHT)) {
				point.x += xMove;
			}	else {
				System.out.println("hna right");	
			}
		
	}else if(xMove < 0){		
		int tx = (int) (point.x + xMove )/Tile.TILEWIDTH;
		if(!collisionWithTile(tx,(int)( point.y+bounds.y)/Tile.TILEHEIGHT) && !collisionWithTile(tx,(int)( point.y+bounds.y+bounds.height)/Tile.TILEHEIGHT)) {
				point.x += xMove;
			}else {
				System.out.println("hna left");	
			}
	}
}

public void moveY() {
	if(yMove > 0) {System.out.println("move up");
		int ty =  (int)(point.y + yMove)/Tile.TILEHEIGHT;
		if(!collisionWithTile((int)( point.x+bounds.x)/Tile.TILEHEIGHT,ty) && !collisionWithTile((int)( point.x+bounds.x+bounds.width)/Tile.TILEWIDTH,ty)) {
			point.y += yMove;
		}	else {
				//System.out.println("hna right");	
			}
		
	}else if(yMove < 0){		
		int ty = (int) (point.y + yMove+bounds.height)/Tile.TILEHEIGHT;
		if(!collisionWithTile((int)( point.x+bounds.x)/Tile.TILEHEIGHT,ty) && !collisionWithTile((int)( point.x+bounds.x+bounds.width)/Tile.TILEWIDTH,ty)) {
				point.y += yMove;
			}else {
				//System.out.println("hna left");	
			}
	}
}

	
	private boolean collisionWithTile(int x,int y) {
		return GameState.getTile(x, y).isSolid();
	}
	
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
			
			/*yMove += velocity;
			System.out.println("ymove up"+yMove);*/
		}
			
		else if(Game.getKeyManager().down) {
			yMove += velocity;
			xMove -= velocity;}
			
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

	public int getBullets() {
		return bullets;
	}

	public void setBullets(int bullets) {
		this.bullets = bullets;
	}

	
	
	
}

