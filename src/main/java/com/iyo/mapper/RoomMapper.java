package com.iyo.mapper;

import com.iyo.pojo.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomMapper {
    List<Room> getRoomAll();
    Room getRoomByID(int RoomID);
    int updateRoom(Room room);
    int updateRoomOccupancy(@Param("Room") Room room,@Param("Num") int num);
    int addRoom(Room room);
    int deleteRoom(int roomId);
}
