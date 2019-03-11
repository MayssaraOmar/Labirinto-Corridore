package model.element.entity;

import java.util.ArrayList;
import java.util.HashMap;

import controller.Observable;
import controller.Observer;

public class Info implements Observable{
	
	private static Info data = null;
	private int health,score,bullets;
	private  ArrayList<Observer> observers;
	public final static int SCORE_KEY = 1;
	public final static int HEALTH_KEY = 2;
	public final static int BULLETS_KEY = 3;
	
	
	private Info() {
		health = 3;
		score = 0;
		bullets = 6;
				
		observers = new ArrayList<>();
	}
	
	public void initializePanel() {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(HEALTH_KEY, health);
		map.put(SCORE_KEY, score);
		map.put(BULLETS_KEY, bullets);
		notifyObservers(map);
	}
	
	public static Info getInfo() {
		if(data == null) {
			data = new Info();
		}
		return data;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(HEALTH_KEY, health);
		notifyObservers(map);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(SCORE_KEY, score);
		notifyObservers(map);
		
	}

	public int getBullets() {
		return bullets;
	}

	public void setBullets(int bullets) {
		this.bullets = bullets;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(BULLETS_KEY, bullets);
		
		notifyObservers(map);
	}

	@Override
	public void addObserver(Observer o) {
		if(!observers.contains(o)) {
			observers.add(o);
		}			
		
	}

	@Override
	public void deleteObserver(Observer o) {
		if(observers.contains(o)) {
			observers.remove(o);
		}		
	}

	@Override
	public void notifyObservers(Object arg) {
		for (Observer observer : observers) {
			observer.update(arg);
			
		}
		
	}
	
	

}
