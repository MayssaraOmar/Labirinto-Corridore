package controller;

import view.InfoPanel;

public class BulletObserver implements Observer{

	@Override
	public void update(Object arg1) {
		InfoPanel.getPanel().setBullets((Integer) arg1);
	}

}
