
public class Competitor {

private int bib;
private double startTime;
private double finishTime;

	
public Competitor(int n){
	bib = n;
	startTime = Double.NaN;
	finishTime = Double.NaN;
}

public int getNumber(){
	return bib;
}

public boolean isdnf(){
	return Double.isNaN(finishTime);
}

public void setStartTime(){
	startTime = Time.getCurrentTime();
}
public double getStartTime(){
	if(Double.isNaN(startTime)) throw new IllegalStateException();
	return startTime;
}
public void setFinishTime(){
	if(Double.isNaN(startTime)) throw new IllegalStateException();
	finishTime = Time.getCurrentTime();
}
public double getFinishTime(){
	if(Double.isNaN(finishTime)) throw new IllegalStateException();
	return finishTime;
}
public double calculateTotalTime(){
	if(Double.isNaN(startTime)||Double.isNaN(finishTime)) throw new IllegalStateException();
	
}

}
