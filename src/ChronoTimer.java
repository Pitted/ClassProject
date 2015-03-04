
import java.util.*;
public class ChronoTimer {
	
	private static boolean power;   //true = on, false = off
	private static ArrayList<Channel> channels;   //2 channels for first sprint, initialized to 8 disarmed channels	
	private static ArrayList<Competitor> toStart;  //the racers who have not yet started
	private static Queue<Competitor> toFinish;   //the racers who have started but not finished yet
	private static ArrayList<Competitor> completedRacers;   //racers who have finished   
	private static Time time;  //used for recording the system time at any given moment in time
  
    
    public static void powerOn()
    {
    	power = true;
    }
    
    public static void powerOff()
    {
    	power = false;
    }
    
    public static void exit()
    {
    	if(power == true)
    		System.exit(0);   //might need to be redone, not sure what exit is supposed to do
    }
    
    public static void reset()
    {
    	//default values
    	if(power == true)
    	{
    		toStart.clear();
    		toFinish.clear();
    		completedRacers.clear();
    		this.disarmAll();
    	}
    }
    
    public static void connectChannel(int index)   // we don't need this, all 8 channels are connected by default
    {
    	if(power == true && channels.size() < 8)
    	{
    		Channel c = new Channel(index);  
    		channels.add(c);
    	}
    }
    
    public static void armChannel(int index)
    {
    	if(power == true && channels.get(index) != null)
    	{
    		Channel c = channels.get(index);
    		c.arm();
    		channels.set(index, c);
    	}
    }
    
    public static void disarmChannel(int index)
    {
    	if(power == true && channels.get(index) != null)
    	{
    		Channel c = channels.get(index);
    		c.disarm();
    		channels.set(index, c);
    	}
    }
    
    public static void disarmAll()
    {
    	if(power == true && !channels.isEmpty()) 
    	{
    		for (Channel ch : channels)
    			ch.disarm();
    	}
    }
    
    public static void addCompetitor(Competitor c)
    {
    	if(power == true && !toStart.contains(c))
    		toStart.add(c);    	   	
    }
    
    public static void start()  //start, finish, dnf, and cancel are either called manually (in driver/test class)
    {														        // or called in trigger() (in Channel)
    	if(power == true && !toStart.isEmpty()) 
    	{
    		Competitor c = toStart.remove(0); 
    		c.setStartTime(Time.getCurrentTime());
    		toFinish.add(c);
    	}
    }
    
    public static void finish()
    {
    	if(power == true && !toFinish.isEmpty())
    	{
    		Competitor c = toFinish.remove();
    		c.setFinishTime(Time.getCurrentTime());
    		completedRacers.add(c);
    	}
    }
    
    public static void dnf()
    {
    	if(power == true && !toFinish.isEmpty())
    	{
    		Competitor c = toFinish.remove();
    		c.setFinishTime(null); //maybe add "did not finish" variable in competitor? TODO TODO TODO
    		completedRacers.add(c);
    	}
    }
    
    public static void cancel()
    {
    	if(power == true && !toFinish.isEmpty())
    	{
    		Competitor c = toFinish.remove();   
    		c.setStartTime(0.0);  //clear the start time
    		toStart.set(0, c);   //adds the canceled racer back to the head of toStart so they can redo the start.
    	}
    }
    
    public void print()
    {
    	System.out.println("Run /t BIB /t TIME")
    	for (Competitior c : completedRacers) {
    		if(!c.isDNF())
    			System.out.println("1 /t" + c.getNumber + "/t" + c.getTime());
    		else
    			System.out.println("1 /t" + c.getNumber + "/t" + "DNF");
		}
    	
    }*/
}
