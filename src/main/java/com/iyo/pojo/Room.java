package com.iyo.pojo;

public class Room {
    private int RoomID;

    private String RoomName;

    private int Capacity;
    private int RoomSeatID;
    private int CurrentOccupancy;
    private int RoomRow;

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public int getCurrentOccupancy() {
        return CurrentOccupancy;
    }

    public void setCurrentOccupancy(int currentOccupancy) {
        CurrentOccupancy = currentOccupancy;
    }

    public int getRoomSeatID() {
        return RoomSeatID;
    }

    public void setRoomSeatID(int roomSeatID) {
        RoomSeatID = roomSeatID;
    }

    public int getRoomRow() {
        return RoomRow;
    }

    public void setRoomRow(int roomRow) {
        RoomRow = roomRow;
    }

    @Override
    public String toString() {
        return getRoomName();
    }
}
