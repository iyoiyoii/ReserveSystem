package com.iyo.service;

import com.iyo.dao.RoomDao;
import com.iyo.pojo.Room;
import com.iyo.pojo.Seat;

import java.util.List;

public class RoomService {
    RoomDao roomDao = new RoomDao();
    public List<Room> getRoomAll(){
        String sql = "select * from room";
        return roomDao.query(sql,Room.class,null);
    }

    public Room getRoomByID(int RoomID){
        String sql = "select * from room where RoomID=?";
        Object[] params = {
                RoomID
        };
        return roomDao.get(sql,Room.class,params);
    }


    public boolean updateRoom(Room room){
        String sql = "update room set RoomName=?,Capacity=?,CurrentOccupancy=?,RoomRow=? where RoomID=?";
        Object[] params = {
                room.getRoomName(),
                room.getCapacity(),
                room.getCurrentOccupancy(),
                room.getRoomRow(),
                room.getRoomID()
        };
        return roomDao.update(sql,params);
    }

    public boolean updateRoomOccupancy(Room room,int num){
        String sql = "update room set CurrentOccupancy=? where RoomID=?";
        Object[] params = {
                room.getCurrentOccupancy() + num,
                room.getRoomID()
        };
        return roomDao.update(sql,params);
    }

    public boolean addRoom(Room room){
        //language=MySQL
        String sql = "insert into room(RoomName,Capacity,CurrentOccupancy,RoomRow) values (?,?,?,?)";
        Object[] params = {
                room.getRoomName(),
                room.getCapacity(),
                room.getCurrentOccupancy(),
                room.getRoomRow(),
        };
        return roomDao.update(sql,params);
    }

    public boolean deleteRoom(int roomId){
        String sql = "delete from room where RoomID=?";
        Object[] params = {
                roomId
        };
        return roomDao.update(sql,params);
    }
}
