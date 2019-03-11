package controller;

import model.Bomb;
import model.DefaultBomb;
import model.element.entity.Info;
import model.element.entity.Runner;

public class DefaultPlayerState extends PlayerState{
		
	public DefaultPlayerState() {
		super();
		//player.changeState(this);
		}

	public void hitBomb(Bomb bomb) {
		
		if(Info.getInfo().getHealth() == 1)
			Runner.getRunner().dead();
			else {
			if(bomb instanceof DefaultBomb) {			
				Info.getInfo().setHealth(Info.getInfo().getHealth()-1);
			}else
			Info.getInfo().setHealth(0);
			}
		}
		
		
	
}
