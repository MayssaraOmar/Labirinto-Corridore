package model.element.entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import controller.Game;
import model.Animation;
import model.Assets;
import model.Maze;
import model.element.tile.Tile;

public class Runner extends Entity {
	private Animation animRunLeft, animRunRight, animIdleRight, animIdleLeft;
	private static Runner uniqueRunner = null;
	// n7ot-ha tb3 state l health
	private int velocity;
	private int health;
	private int score;
	private int xMove, yMove;
	private ArrayList<Integer> bullets;

	// singleton DP
	public static Runner getRunner() {
		if (uniqueRunner == null)
			uniqueRunner = new Runner();
		return uniqueRunner;

	}

	private Runner() {
		super();
		animRunLeft = new Animation(500, Assets.runner_left_run);
		animRunRight = new Animation(500, Assets.runner_right_run);
		animIdleLeft = new Animation(500, Assets.runner_left_idle);
		animIdleRight = new Animation(500, Assets.runner_right_idle);
		
		// this.game = game;
		// maze = Maze.getMaze("maze.txt");
		bullets = new ArrayList<Integer>(6);
		health = 3;
		velocity = 1;
		score = 0;
		width = 50;
		height = 50;
		xMove = 0;
		yMove = 0;
		// RunnerImg = l mfrood n-get l image mn l spritesheet ely hn7mlha mn l game

	}

	public void move() {
		if (!checkEntityCollisions(xMove, 0))
			moveX();
		if (!checkEntityCollisions(0, yMove))
			moveY();
	}

	public void moveX() {
		Point p = Maze.toGrid(point.x, point.y);
		/*
		 * if(xMove > 0) { int tx = (p.x + xMove +
		 * getBounds().x+getBounds().width)/Tile.TILEWIDTH; if(!collisionWithTile(tx,(
		 * point.y+bounds.y)/Tile.TILEHEIGHT) && !collisionWithTile(tx,(
		 * point.y+bounds.y+bounds.height)/Tile.TILEHEIGHT)) { point.x += xMove; } p.x
		 * += xMove;
		 * 
		 * }else if(xMove < 0){System.out.println("shaml");
		 * 
		 * }
		 */

		p.x += xMove;
		setPoint(Maze.toIso(p.x, p.y));
	}

	public void moveY() {
		// point.y += yMove;
		Point p = Maze.toGrid(point.x, point.y);
		p.y += yMove;
		setPoint(Maze.toIso(p.x, p.y));
	}

	/*
	 * private boolean collisionWithTile(int x,int y) {
	 * 
	 * //return maze.getTile(x, y).isSolid(); }
	 */

	public void tick() {
		// System.out.println("TICK Runner\n");
		animRunLeft.tick();
		animRunRight.tick();
		animIdleRight.tick();
		animIdleLeft.tick();
		getMove();
		move();

	}

	@Override
	public void render(Graphics g) {

		g.drawImage(getCurrentAnimationFrame(), point.x, point.y, Tile.TILEWIDTH, Tile.TILEHEIGHT, null);

	}

	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0)
			return animRunLeft.getCurrentFrame();
		if (xMove > 0)
			return animRunRight.getCurrentFrame();
		if (yMove < 0)
			return animRunRight.getCurrentFrame();
		if (yMove > 0)
			return animRunLeft.getCurrentFrame();

		return animIdleRight.getCurrentFrame();
	}

	// getInput Move
	public void getMove() {
		// System.out.println("GET MOOVE\n");
		xMove = 0;
		yMove = 0;
		
		if (Game.getKeyManager().up) {
			xMove -= velocity;
		}

		else if (Game.getKeyManager().down) {
			xMove += velocity;
		}

		else if (Game.getKeyManager().left) {

			yMove += velocity;
		}

		else if (Game.getKeyManager().right) {
			yMove -= velocity;
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
