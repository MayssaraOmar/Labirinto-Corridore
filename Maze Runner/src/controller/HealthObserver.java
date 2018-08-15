package controller;

import view.InfoPanel;

public class HealthObserver implements Observer{

	@Override
	public void update(Object arg1) {
		InfoPanel.getPanel().setHealth((Integer) arg1);
	}

}
