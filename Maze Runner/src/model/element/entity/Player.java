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
	private int bullets;
	
	public static Player getPlayer(Game game,Point point) {
		if(uniquePlayer == null)
			uniquePlayer = new Player(game,point,Assets.runner);
		return uniquePlayer;		
	}
	
	private Player(Game game,Point point,BufferedImage bufferedImage) {
		super(point, Assets.runner);
		this.game = game;
		maze = Maze.getMaze("maze.txt");
		bullets = 6;
		health = 3;
		velocity = 5;
		score = 0;
		width = 15;
		height = 15;
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
			int tx =  (int)(point.x + xMove +bounds.width)/Tile.TILEWIDTH;
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
			/*yMove -= velocity;
			xMove += velocity;*/
			
			yMove += velocity;
			System.out.println("ymove up"+yMove);
		}
			
		else if(game.getKeyManager().down) {
			yMove -= velocity;
			
		}
			
		else if(game.getKeyManager().left) {
			xMove -= velocity;
			//yMove -= velocity;
		}
			
		else if(game.getKeyManager().right) {
			xMove += velocity;
			//yMove += velocity;
			
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

