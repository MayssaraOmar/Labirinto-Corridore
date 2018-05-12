package controller;

import model.element.entity.Runner;

public abstract class PlayerState {
	
	protected Runner player;
	
	public PlayerState(Runner player) {
		this.player = player;
	}

	public abstract void hitBomb ();
	
}

