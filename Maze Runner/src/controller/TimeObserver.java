package controller;

import view.InfoPanel;

public class TimeObserver implements Observer{
	/*
	public TimeObserver(Observable obs) {
		obs.addObserver(this);
	}
	*/
	@Override
	public void update( Object arg1) {
		InfoPanel.getPanel().setTime((String) arg1);
		
	}
	

}
