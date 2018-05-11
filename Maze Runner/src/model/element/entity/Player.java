package model.element.entity;

import java.awt.List;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import controller.Game;
import model.Assets;
import model.Maze;
import model.element.tile.Tile;

public class Player extends Entity{
	private static Player uniquePlayer = null;	
	//n7ot-ha tb3 state l health
	private Game game; 
	private Maze maze;
	private int velocity ;
	private int health ;
	private int score;
	private int xMove,yMove;
	private ArrayList<Integer> bullets;
	
	public static Player getPlayer(Game game,Point point) {
		if(uniquePlayer == null)
			uniquePlayer = new Player(game,point,Assets.runner);
		return uniquePlayer;
		
	}
	
	private Player(Game game,Point point,BufferedImage bufferedImage) {
		super(point, Assets.runner);
		this.game = game;
		maze = Maze.getMaze("maze.txt");
		bullets = new ArrayList<Integer>(6);
		health = 3;
		velocity = 10;
		score = 0;
		width = 50;
		height = 50;
		xMove = 0;
		yMove = 0;
	//	playerImg = l mfrood n-get l image mn l spritesheet ely hn7mlha mn l game
		
	}	
	
	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		
		if(xMove > 0) {
			int tx =  (point.x + xMove + bounds.x+bounds.width)/Tile.TILEWIDTH;
			if(!collisionWithTile(tx,( point.y+bounds.y)/Tile.TILEHEIGHT) && !collisionWithTile(tx,( point.y+bounds.y+bounds.height)/Tile.TILEHEIGHT)) {
					point.x += xMove;
				}
			
			
		}else if(xMove < 0){System.out.println("shaml");
			
		}
		
		
		point.x += xMove;
	}
	
	public void moveY() {
		point.y += yMove;
	}
	
	private boolean collisionWithTile(int x,int y) {
		return maze.getTile(x, y).isSolid();
	}
	
	public void tick() {
		getMove();
		move();
			
	}
	//getInput Move
	public void getMove() {
		xMove = 0;
		yMove = 0;
	
		if(game.getKeyManager().up) {			
			yMove -= velocity;
			xMove += velocity;
		}
			
		else if(game.getKeyManager().down) {
			yMove += velocity;
			xMove -= velocity;
		}
			
		else if(game.getKeyManager().left) {
			xMove -= velocity;
			yMove -= velocity;
		}
			
		else if(game.getKeyManager().right) {
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

