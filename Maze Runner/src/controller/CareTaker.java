package controller;

import java.awt.Point;
import java.util.ArrayList;

import model.element.Element;
import model.element.entity.Runner;

public class CareTaker {
	
	private ArrayList<Memento>history;
	
	//private Runner player;
	
	public CareTaker() {
		
		history=new ArrayList<>();
				
	}
	
	public void saveCheckpoint () {
		history.add(new Memento(Runner.getRunner().getScore(),Runner.getRunner().getBullets(),Runner.getRunner().getPoint(),Runner.getRunner().getHealth()));
	}
	
	
	public Memento restoreCheckpoint() {
		if(history.size()>0) {
			Memento checkpoint = history.remove(history.size()-1);
			return checkpoint;
		//currentState = new Memento(checkpoint.getScore(), checkpoint.getBullets(), checkpoint.getPosition());
		}
		else return null;
		
	}

	public ArrayList<Memento> getHistory() {
		return history;
	}

	
	

}
