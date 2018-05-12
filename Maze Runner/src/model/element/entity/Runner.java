package model.element.entity;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import controller.ArmorOnPlayerState;
import controller.DefaultPlayerState;
import controller.Game;
import controller.PlayerState;
import model.Armor;
import model.Assets;
import model.Bomb;
import model.Gift;
import model.HealthGift;
import model.Maze;
import model.element.Element;

public class Runner extends Entity{
	private static Runner uniqueRunner = null;	
	private int velocity ;
	private int health ;
	private int score;
	private int xMove,yMove;
	private int bullets;
	private PlayerState playerState,defaultState;
	
	
	// singleton DP
	public static Runner getRunner() {
		if(uniqueRunner == null)
			uniqueRunner = new Runner();
		return uniqueRunner;
		
	}
	
	protected Runner() {
		super(Assets.runner);	
	
		defaultState = new DefaultPlayerState(this);
		playerState = defaultState;		
		bullets = 6;
		health = 3;
		velocity = 1;
		score = 0;
		width = 50;
		height = 50;
		xMove = 0;
		yMove = 0;
		
	//	RunnerImg = l mfrood n-get l image mn l spritesheet ely hn7mlha mn l game
		
	}		
	public void changeState(PlayerState state) {
		playerState = state;
	}
	
	
	
	public void move() {
		Element collided ;
		
		if( (collided = checkEntityCollisions(xMove, 0)) == null) {
				moveX();
		}
			
		else {
			if(collided instanceof Gift || collided instanceof Bomb) {
				
				((Entity) collided).doAction();
				System.out.println("Score"+score);
				System.out.println("Health"+health);
				System.out.println("Bullets"+bullets);				
					removeElement(collided);
			}else if(collided instanceof Armor) {
				System.out.println(collided.getClass().toString());
			}
			
		}
		if((collided = checkEntityCollisions(0, yMove)) == null)
			moveY();
		
		else {
			if(collided instanceof Gift || collided instanceof Bomb) {
				((Entity) collided).doAction();
				System.out.println("Score"+score);
				System.out.println("Health"+health);
				System.out.println("Bullets"+bullets);				
					removeElement(collided);
			}else if(collided instanceof Armor) {
				System.out.println(collided.getClass().toString());
			}
			
		}
	}
	
	public void moveX() {
		Point p = Maze.toGrid(point.x, point.y);
		/*if(xMove > 0) {
			int tx =  (p.x + xMove + getBounds().x+getBounds().width)/Tile.TILEWIDTH;
			if(!collisionWithTile(tx,( point.y+bounds.y)/Tile.TILEHEIGHT) && !collisionWithTile(tx,( point.y+bounds.y+bounds.height)/Tile.TILEHEIGHT)) {
					point.x += xMove;
				}
			p.x += xMove;
			
		}else if(xMove < 0){System.out.println("shaml");
			
		}*/
		
		p.x += xMove;
		setPoint(Maze.toIso(p.x,p.y));
	}
	
	public void moveY() {
		//point.y += yMove;
		Point p = Maze.toGrid(point.x, point.y);
		p.y += yMove;
		setPoint(Maze.toIso(p.x,p.y));
	}
	
	/*private boolean collisionWithTile(int x,int y) {
		
		//return maze.getTile(x, y).isSolid();
	}*/
	
	public void tick() {
		//System.out.println("TICK Runner\n");

		getMove();
		move();
			
	}
	//getInput Move
	public void getMove() {
		//System.out.println("GET MOOVE\n");
		xMove = 0;
		yMove = 0;
	
		if(Game.getKeyManager().up) {			
			yMove -= velocity;
			//xMove += velocity;
		}
			
		else if(Game.getKeyManager().down) {
			yMove += velocity;
			//xMove -= velocity;
		}
			
		else if(Game.getKeyManager().left) {
			xMove -= velocity;
			//yMove -= velocity;
		}
			
		else if(Game.getKeyManager().right) {
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

	public PlayerState getPlayerState() {
		return playerState;
	}

	public void setPlayerState(PlayerState playerState) {
		this.playerState = playerState;
	}
	
	
}

