package com.example.dsmolyak.mapapp;

import java.util.HashMap;


public class Room {
	private String roomNumber;
	private HashMap<String, String> teachers;
	private String[] roominfo;
	public Room( String roomNumber, HashMap<String, String> teachers , String[] roominfo){
		this.roomNumber= roomNumber;
		this.teachers = teachers;
		this.roominfo = roominfo;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getTeacherAtPeriod(int period){
		
		return teachers.get(""+period);
	}
	public boolean contains(String str){
		for(String string : roominfo){
			if(string.toLowerCase().contains(str.toLowerCase())){
				return true;
			}
		}
		return false;
	}
}
