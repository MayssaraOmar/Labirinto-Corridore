package model.element.entity;

import java.awt.List;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import model.Assets;

public class Player extends Entity{
	private static Player uniquePlayer = null;	
	//n7ot-ha tb3 state l health
	private int velocity ;
	private int health ;
	private int score;
	private ArrayList<Integer> bullets;
	
	public static Player getPlayer() {
		if(uniquePlayer == null)
			uniquePlayer = Player.getPlayer();
		return uniquePlayer;
		
	}
	
	private Player(Point point,BufferedImage bufferedImage) {
		super(point, Assets.runner);
		bullets = new ArrayList<Integer>(6);
		health = 3;
		velocity = 10;
		score = 0;
	//	playerImg = l mfrood n-get l image mn l spritesheet ely hn7mlha mn l game
		
	}	

	
	public void tick() {
		point.x = velocity;
		point.y = velocity;
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

