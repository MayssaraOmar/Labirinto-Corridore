package model.tiles;

public class TilesFactory {
	
	
	public Tile getTile(int type) {
		
		if(type == 0)
			return new PathTile();
		if(type == 1)
			return new StoneTile();
		if(type == 2)
			return new TreeTile();
		
		return new PathTile(); // default tile
	}
}
