package point1.point1_9;

public class MyTime {
	private int hour;
	private int minute;
	private int second;
	
	public MyTime(int hour, int minute, int second) throws InvalidHour{
		
		if(hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59)
			throw new InvalidHour("The values doesn't correspond to a valid time format");
		
		this.setHour(hour);
		this.setMinute(minute);
		this.setSecond(second);
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
	
	public void nextSecond(){
		if(second < 59)
			second++;
		else {
			second = 0;
			nextMinute();
		}
	}
	
	public void previousSecond(){
		if(second > 0)
			second--;
		else {
			second = 59;
			previousMinute();
		}
	}
	
	public void nextMinute(){
		if(minute < 59)
			minute++;
		else {
			minute = 0;
			nextHour();
		}
	}
	
	public void previousMinute(){
		if(minute > 0)
			minute--;
		else {
			minute = 59;
			previousHour();
		}
	}
	
	public void nextHour(){
		if(hour < 23)
			hour++;
		else hour = 0;
	}
	
	public void previousHour(){
		if(hour > 0)
			hour--;
		else hour = 23;
	}
	
	public String toString(){
		String str = "";
		if(hour < 10)
			str += "0"+hour;
		else str += hour;
		
		str += ":";
		
		if(minute < 10)
			str += "0"+minute;
		else str += minute;
		
		str += ":";
		
		if(second < 10)
			str += "0"+second;
		else str += second;
		
		return str;
	}
}
