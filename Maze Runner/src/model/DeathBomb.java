package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import controller.GameState;

public class DeathBomb extends Bomb{

	public DeathBomb() {
		super(Assets.bomb_1);	
		ID = 9;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
public void doAction() {		
		player.getPlayerState().hitBomb(this);
		
		//GameState.elements.remove(this);
	}

@Override
public void render(Graphics g) {
	// TODO Auto-generated method stub
	
}

public boolean isDestroyable() {
	return false;
}

}
