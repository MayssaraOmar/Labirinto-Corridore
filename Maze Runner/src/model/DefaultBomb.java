package model;

import java.awt.image.BufferedImage;

public class DefaultBomb extends Bomb{

	public DefaultBomb() {
		super(Assets.defaultBomb);
		
	}

	@Override
	public void tick() {
		
		
	}
	
public void doAction() {
		player.setHealth(player.getHealth()-1);
	}

}
