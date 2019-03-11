package controller;

import java.util.HashMap;

import model.element.entity.Info;
import view.InfoPanel;

public class BulletObserver implements Observer{

	public BulletObserver(Observable obs) {		
		obs.addObserver(this);
	}
	
	@Override
	public void update(Object arg1) {
		if(((HashMap<Integer, Integer>) arg1).containsKey(Info.BULLETS_KEY)) {			
			InfoPanel.getPanel().setBullets( ((HashMap<Integer, Integer>) arg1).get(Info.BULLETS_KEY));
		}
		
	}

}
