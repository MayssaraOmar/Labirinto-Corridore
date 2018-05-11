package model;

import java.awt.Point;
import java.awt.image.BufferedImage;

import model.element.entity.Entity;
import model.element.entity.Runner;

public abstract class Decorator extends Entity{

	public Decorator(BufferedImage bufferedImage, int width, int height, Point point) {
		super(bufferedImage, width, height, point);
		
	}

	

	
	
}
