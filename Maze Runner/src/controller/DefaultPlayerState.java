package controller;

import model.Bomb;
import model.DefaultBomb;
import model.element.entity.Runner;

public class DefaultPlayerState extends PlayerState{
		
	public DefaultPlayerState() {
		super();
		//player.changeState(this);
		}

	public void hitBomb(Bomb bomb) {
		
		if(Runner.getRunner().getHealth() == 1)
			Runner.getRunner().dead();
			else {
			if(bomb instanceof DefaultBomb) {			
			Runner.getRunner().setHealth(Runner.getRunner().getHealth()-1);
			}else
			Runner.getRunner().setHealth(0);
			}
		}
		
		
	
}
