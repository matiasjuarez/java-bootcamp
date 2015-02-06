package com.matias.Topic6;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration



public class WebApp {
	static ApplicationContext ctx;
	static Map<String, Meeting> meetings = new HashMap<String, Meeting>();
	
	@RequestMapping(value="/meeting", method=RequestMethod.POST)
	public String newMeeting(){
		
		Meeting meeting = (Meeting)ctx.getBean("meeting");
		meeting.setId(meetings.size() + 1);
		
		meetings.put(Integer.toString(meeting.getId()), meeting);
		
		return "New meeting created. Total: " + meetings.size();
	}
	
	// http://localhost:8080/meeting?meetingId=0
	// http://localhost:8080/meeting?meetingId=all
	@RequestMapping(value="/meeting", method=RequestMethod.GET)
	public String showMeeting(@RequestParam String meetingId){
		if(meetingId.equalsIgnoreCase("all"))
		{
			String str = "";
			for(int i = 0; i < meetings.size(); i++)
			{
				str += meetings.get(Integer.toString(i)) + "\n";
			}
			return str;
		}
		return (meetings.get(meetingId).toString());
		
	}
	
	// http://localhost:8080/meeting?meetingId=0&room=room1
	@RequestMapping(value="/meeting", method=RequestMethod.PUT)
	public String modifyMeeting(@RequestParam String meetingId, @RequestParam String room){
		Meeting meeting = meetings.get(meetingId);
		
		meeting.setRoom((Room)ctx.getBean(room));
		
		return "The room " + meeting.getRoom().getFloor() + ""+ meeting.getRoom().getNumber() + " has been assigned to the meeting with id: " + meeting.getId();
	}
	
	// http://localhost:8080/meeting/1?attendee=matias
	@RequestMapping(value="/meeting/{meetingId}", method=RequestMethod.PUT)
	public String addAttendee(@PathVariable String meetingId, @RequestParam String attendee)
	{
		Meeting meeting = meetings.get(meetingId);
		
		Attendee newAttendee = (Attendee)ctx.getBean(attendee);
		
		meeting.addAttendee(newAttendee);
		
		return newAttendee.getName() + " will assist to the meeting with id " + meeting.getId();
	}
	
	public static void main(String args[]) {
		ctx = new ClassPathXmlApplicationContext("meeting.xml");
		
		SpringApplication.run(WebApp.class, args);
	}
}
