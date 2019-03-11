package controller;

import java.util.HashMap;

import model.element.entity.Info;
import view.InfoPanel;

public class ScoreObserver implements Observer{

	public ScoreObserver(Observable obs) {
		obs.addObserver(this);
	}
	
	
	@Override
	public void update(Object arg1) {		
		if(((HashMap<Integer, Integer>) arg1).containsKey(Info.SCORE_KEY))
		InfoPanel.getPanel().setScore( ((HashMap<Integer, Integer>) arg1).get(Info.SCORE_KEY));
	}

}
