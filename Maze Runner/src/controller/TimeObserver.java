package controller;

import view.InfoPanel;

public class TimeObserver implements Observer{
	
	@Override
	public void update( Object arg1) {
		InfoPanel.getPanel().setTime((String) arg1);
		
	}
	

}
