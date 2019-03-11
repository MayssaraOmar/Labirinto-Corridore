package controller;

import java.util.HashMap;

import model.element.entity.Info;
import view.InfoPanel;

public class HealthObserver implements Observer{

	public HealthObserver(Observable obs) {
		obs.addObserver(this);
	}
	
	@Override
	public void update(Object arg1) {
		
		if(((HashMap<Integer, Integer>) arg1).containsKey(Info.HEALTH_KEY))
		InfoPanel.getPanel().setHealth( ((HashMap<Integer, Integer>) arg1).get(Info.HEALTH_KEY));
	}
}
