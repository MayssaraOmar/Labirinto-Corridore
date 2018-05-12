package model;

import java.awt.image.BufferedImage;

public class DeathBomb extends Bomb{

	public DeathBomb() {
		super(Assets.deathBbomb);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
public void doAction() {
		player.setHealth(0);
	}

}
