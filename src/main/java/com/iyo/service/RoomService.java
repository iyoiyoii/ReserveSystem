package com.iyo.service;

import com.iyo.mapper.RoomMapper;
import com.iyo.pojo.Room;
import com.iyo.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoomService {
    SqlSession sqlSession;
    RoomMapper roomMapper;
    public RoomService(){
        sqlSession = SqlSessionUtil.getSqlSession();
        roomMapper = sqlSession.getMapper(RoomMapper.class);
    }

    public List<Room> getRoomAll(){
        return roomMapper.getRoomAll();
    }

    public Room getRoomByID(int RoomID){
        return roomMapper.getRoomByID(RoomID);
    }


    public boolean updateRoom(Room room){
        return roomMapper.updateRoom(room) > 0;
    }

    public boolean updateRoomOccupancy(Room room,int num){
        return roomMapper.updateRoomOccupancy(room,num) > 0;
    }

    public boolean addRoom(Room room){
        return roomMapper.addRoom(room) > 0;
    }

    public boolean deleteRoom(int roomId){
        return roomMapper.deleteRoom(roomId) > 0;
    }
}
