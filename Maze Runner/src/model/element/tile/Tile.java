package model.element.tile;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import model.element.Element;

public  class Tile implements Element{
	
	public static Tile[] tiles = new Tile[20];
	public static Tile pathTile = new PathTile();
	public static Tile treeTile = new TreeTile();
	public static Tile stoneTile = new StoneTile();
	
	public static final int TILEWIDTH = 25, TILEHEIGHT = 25;
	private BufferedImage texture;
	protected Point point;
	protected int id;
	
	public Tile(BufferedImage texture,int ID) {
		this.texture = texture;
		id = ID;
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	@Override
	public void render(Graphics g) {
		g.drawImage(texture, point.x, point.y, TILEWIDTH , TILEHEIGHT,  null);
		
	}
	/*public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH , TILEHEIGHT,  null);
	}*/
	

	public  boolean isSolid() {
		return true;
	}

	@Override
	public Point getPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPoint(Point point) {
		this.point	= point;	
	}

	

}
