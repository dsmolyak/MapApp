package com.example.dsmolyak.mapapp;

import java.util.HashMap;


public class RoomHandler {
	private HashMap<String, Room> roomsToNumberMap;
	private HashMap<String, String[]> superHash;
	
	public RoomHandler(){
		roomsToNumberMap = new HashMap<String,Room>();
	}
	public void addRoom(Room room) {

		roomsToNumberMap.put(room.getRoomNumber(), room);
	}
	public String[] getTeachersInRoom(String roomNumber){

		Room rm = roomsToNumberMap.get(roomNumber);
		if (rm == null) {
			return null;
		}

		String[] strs= new String[7];
		for (int i = 0; i < strs.length; i++) {
			strs[i] = rm.getTeacherAtPeriod(i + 1);
		}
		return strs;
	}
	public void setSuperHash(HashMap<String, String[]> superHash) {
		this.superHash= superHash;
		
	}
	public String[] getRoomsOfTeacher(String teacher){
		return superHash.get(teacher);
	}
}
