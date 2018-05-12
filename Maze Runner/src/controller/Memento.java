package controller;

import java.awt.Point;


public class Memento {
	
	private int score;
	private int bullets;
	private Point position;
	
	public Memento(int score,int bullets,Point position )
	{
		this.score=score;
		this.bullets=bullets;
		this.position = position;
		
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
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	
	

}
