package com.matias.Topic6;

import java.util.ArrayList;

public class Meeting {
	private int id;
	private Room room;
	private TimeSlot timeSlot;
	private ArrayList<Attendee> attendees;
	
	public Meeting(Room room, TimeSlot timeSlot) {
		this.room = room;
		this.timeSlot = timeSlot;
	}
	
	public Meeting(){
		attendees = new ArrayList<Attendee>();
	}
	
	public void addAttendee(Attendee attendee){
		this.attendees.add(attendee);
	}
	
	public Room getRoom(){
		return room;
	}
	
	public void setRoom(Room room){
		this.room = room;
	}
	
	public TimeSlot getTimeSlot(){
		return timeSlot;
	}

	public ArrayList<Attendee> getAttendee() {
		return attendees;
	}

	public void setAttendee(ArrayList<Attendee> attendee) {
		this.attendees = attendee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString(){
		String str = "";
		
		str += "Meeting room: " + room.getFloor() + "" + room.getNumber() + "\n";
		str += "Attendees: \n";
		
		for(Attendee attendee: attendees){
			str += attendee.getName() + "\n";
		}
		
		str += "\n\n\n";
		
		return str;
	}
}
