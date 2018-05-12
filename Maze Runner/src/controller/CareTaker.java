package controller;

import java.awt.Point;
import java.util.ArrayList;

import model.element.Element;
import model.element.entity.Runner;

public class CareTaker {
	Memento currentState;
	ArrayList<Memento>history;
	
	private Runner player;
	
	public CareTaker() {
		//not sure about position
		currentState = new Memento(0,6,new Point(1, 0));
		history=new ArrayList<>();
		player = Runner.getRunner();		
	}
	
	public void saveCheckpoint () {
		history.add(new Memento(player.getScore(),player.getBullets(),player.getPoint()));
	}
	
	
	public void restoreCheckpoint() {
		if(history.size()>0) {
			Memento checkpoint = history.remove(history.size()-1);
			currentState = new Memento(checkpoint.getScore(), checkpoint.getBullets(), checkpoint.getPosition());
		}
		
	}
	

}
