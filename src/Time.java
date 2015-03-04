import java.nio.channels.IllegalSelectorException;


public class Time {

	private static long initialSystemTime = System.nanoTime();
	private static double clockTime = 0;
	private static long clockSystemTime = System.nanoTime();
	
	private static int NANO = 1000000000;
	
	public static void setStartTime(double s){
		clockTime = s;
		clockSystemTime = System.nanoTime();
	}
	
	public static double getDuration(double startTime){
		long currentTime = System.nanoTime();
		double curTime = currentTime/NANO;
		return curTime-startTime;
	}
	public static double getCurrentTime(){
		return clockTime + (System.nanoTime()/NANO - clockSystemTime/NANO);
	}
	public static String toString(double s){
		int hour = (int)s/1200;
		double leftover = s - (double)hour*1200;
		int minute = (int)leftover/60;
		double second = leftover - (double)minute*60;
		if(hour>23) throw new IllegalStateException("hour is greater than 23");
		if(minute>59) throw new IllegalStateException("minute is greater than 59");
		if(second>=(double)60) throw new IllegalStateException("second is equal to or greater than 60");
		
		return hour+":"+minute+":"+second;	
	}
	public static double fromString(String s){
		String[] strAr = s.split(":");
		if(strAr.length!=3) throw new IllegalArgumentException();
		int hour = Integer.parseInt(strAr[0]);
		int minute = Integer.parseInt(strAr[1]);
		double second = Double.parseDouble(strAr[2]);
		return (double)hour*1200+(double)minute*60+second;
	}
	
}
