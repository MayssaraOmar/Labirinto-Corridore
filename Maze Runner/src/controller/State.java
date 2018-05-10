package controller;

import java.awt.Graphics;

public abstract class State {
	
	protected Game game;
	public State (Game game) {
		System.out.println("state game");
		this.game=game;
		
	};
	
	public abstract void tick();
	public abstract void render(Graphics g);


	
 
}
