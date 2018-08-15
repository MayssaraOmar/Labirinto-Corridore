package controller;

public class Timer{
	private TimeObserver obs;
	private long sec; 
	
	public Timer() {
		obs = new TimeObserver();
		sec = 0;
	}
	
	public void updateTime() {
		sec++;
		//notifyObservers(getTime());		
		obs.update(getTime());
	}
	
	
	public String getTime()
	{
	    //if we have hours minutes and seconds
	    long hours = 0;
	    long remainderOfHours = 0;
	    long minutes = 0;
	    long seconds = 0;

	    if (sec >= 3600) // if we have an hour or more     
	    {
	        hours = sec / 3600;               
	        remainderOfHours = sec % 3600;        // could be more or less than a min

	        if (remainderOfHours >= 60)   //check if remainder is more or equal to a min
	        {
	            minutes = remainderOfHours / 60;
	            seconds = remainderOfHours % 60;
	        }
	        else
	        {                       // if it's less than a min
	            seconds = remainderOfHours;
	        }
	    }
	    // if we have a min or more
	    else if (sec >= 60)                
	    {
	        hours = 0;               //62
	        minutes = sec / 60;
	        seconds = sec % 60;
	    }
	    //if we have just seconds
	    else if (sec < 60)
	    {
	        hours = 0;
	        minutes = 0;
	        seconds = sec;
	    }
	//i get integer hour minuite second. i want to transform them to strings:
	    
	    String strHours;
	    String strMins; 
	    String strSecs; 

	    if(seconds < 10)
	    	strSecs = "0" + Long.toString(seconds);
	    else
	    	strSecs = Long.toString(seconds);
	   
	    if(minutes < 10)
	   	 strMins = "0" + Long.toString(minutes);
	   else
		   strMins = Long.toString(minutes);
	    
	    if(hours < 10)
	    	strHours = "0" + Long.toString(hours);
	      else
	    	  strHours = Long.toString(hours);
	    	
	        
	    String time = strHours + ":" + strMins + ":" + strSecs;
	    return time;
	}

	public long getSec() {
		return sec;
	}

	public void setSec(long sec) {
		this.sec = sec;
	}

	


	
}
