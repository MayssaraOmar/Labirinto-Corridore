package model;

import java.awt.image.BufferedImage;

import model.element.entity.Entity;
import model.element.entity.Runner;

public abstract class Bomb extends Entity{

	protected Runner player;
	
	public Bomb(BufferedImage bufferedImage) {
		super(bufferedImage);
		player = Runner.getRunner();
	}
	
	public void doAction() {
		
	}

}
