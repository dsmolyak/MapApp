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

		String[] strs= new String[7];
		for(int x =0; x<strs.length; x++){
			strs[x]=rm.getTeacherAtPeriod(x+1);
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
