package controller;

import view.InfoPanel;

public class ScoreObserver implements Observer{

	@Override
	public void update(Object arg1) {
		InfoPanel.getPanel().setScore((Integer) arg1);
	}

}
