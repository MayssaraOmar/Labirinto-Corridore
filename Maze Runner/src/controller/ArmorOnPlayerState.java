package controller;

import model.Armor;
import model.Bomb;
import model.DeathBomb;
import model.DefaultBomb;
import model.element.entity.Runner;

public class ArmorOnPlayerState extends PlayerState {

	public ArmorOnPlayerState() {
		super();
		// Runner.getRunner().changeState(this);
		// player = new Armor(player);
	}

	public void hitBomb(Bomb bomb) {
		if(Runner.getRunner().getHealth() == 1)
			Runner.getRunner().dead();
		 else {
			if (bomb instanceof DefaultBomb) {
				Runner.getRunner().changeState(new DefaultPlayerState());

			} else if (bomb instanceof DeathBomb) {
				Runner.getRunner().setHealth(0);
			}
		}
	}
}