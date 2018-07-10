package model;

import java.awt.Graphics;

import controller.GameState;

public class DefaultBomb extends Bomb{

	public DefaultBomb() {
		super(Assets.bomb_0);
		ID = 8;
	}

	@Override
	public void tick() {
		
		
	}
	
public void doAction() {
	
	player.getPlayerState().hitBomb(this);
	System.out.println("hit");
	//GameState.elements.remove(this);
	//	player.setHealth(player.getHealth()-1);
	}
public boolean isDestroyable() {
	return true;
}
}
