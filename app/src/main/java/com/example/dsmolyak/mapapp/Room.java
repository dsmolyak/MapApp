package com.example.dsmolyak.mapapp;

import java.util.HashMap;


public class Room {
	private String roomNumber;
	private HashMap<String, String> teachers;
	public Room( String roomNumber, HashMap<String, String> teachers){
		this.roomNumber= roomNumber;
		this.teachers = teachers;
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
	public String toString(){
		return getRoomNumber();
	}
}
