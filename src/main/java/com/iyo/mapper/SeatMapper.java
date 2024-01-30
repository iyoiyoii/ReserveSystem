package com.iyo.mapper;

import com.iyo.pojo.Room;
import com.iyo.pojo.Seat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SeatMapper {
    Seat getSeatByRoomId(@Param("Room") Room room,@Param("SeatId")  int SeatId);
    Seat getSeatById(int SeatId);
    List<Seat> getRoomSeat(int RoomID);
    List<Seat> getRoomFreeSeat(int RoomID);
    List<Seat> getRoomSeatRowByIDAndRow(@Param("RoomID") int RoomID,@Param("Row") int Row);
    List<Seat> getSeatStatusAll();
    List<Seat> getSeatAll();
    List<Seat> getFreeSeat();
    List<Seat> getRoomSeatRowByRoom(Room room);
    Seat getSeatByID(int seatId);
    int addSeat(Seat seat);
    int deleteSeat(int seatID);
    int updateSeatStatus(@Param("Seat") Seat seat,@Param("Status") int Status);
}
