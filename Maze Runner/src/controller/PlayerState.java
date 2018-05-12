package controller;

import model.Bomb;
import model.element.entity.Runner;

public abstract class PlayerState {
	
	protected Runner player;
	
	
	public PlayerState(Runner player) {
		this.player = player;
	}


	public void hitBomb(Bomb bomb) {
		// TODO Auto-generated method stub
		
	}


	//public void hitBomb(Bomb bomb);
	
	
	
}

