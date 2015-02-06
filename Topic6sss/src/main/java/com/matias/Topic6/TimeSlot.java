package com.matias.Topic6;

public class TimeSlot {
	private String fromHour;
	private String toHour;
	
	public TimeSlot(String fromHour, String toHour) {
		this.fromHour = fromHour;
		this.toHour = toHour;;
	}
	
	public String getFromHour(){
		return fromHour;
	}
	
	public String getToHour(){
		return toHour;
	}
}
