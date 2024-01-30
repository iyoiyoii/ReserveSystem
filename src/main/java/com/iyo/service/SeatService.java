package com.iyo.service;

import com.iyo.mapper.SeatMapper;
import com.iyo.pojo.Room;
import com.iyo.pojo.Seat;
import com.iyo.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SeatService {
    SqlSession sqlSession;
    SeatMapper seatMapper;
    public SeatService(){
        sqlSession = SqlSessionUtil.getSqlSession();
        seatMapper = sqlSession.getMapper(SeatMapper.class);
    }

    public Seat getSeatByRoomId(Room room,int SeatId){
        return seatMapper.getSeatByRoomId(room,SeatId);

    }

    public Seat getSeatById(int SeatId){
        return seatMapper.getSeatById(SeatId);
    }


    public List<Seat> getRoomSeat(int RoomID){
        return seatMapper.getRoomSeat(RoomID);
    }

    public List<Seat> getRoomFreeSeat(int RoomID){
        return seatMapper.getRoomFreeSeat(RoomID);
    }


    public List<Seat> getRoomSeatRowByIDAndRow(int RoomID,int Row){
        return seatMapper.getRoomSeatRowByIDAndRow(RoomID,Row);
    }

    public List<Seat> getSeatStatusAll(){
        return seatMapper.getSeatStatusAll();
    }


    public List<Seat> getSeatAll(){
        return seatMapper.getSeatAll();
    }

    public List<Seat> getFreeSeat(){
        return seatMapper.getFreeSeat();
    }
    public List<Seat> getRoomSeatRowByRoom(Room room){
        return seatMapper.getRoomSeatRowByRoom(room);
    }

    public Seat getSeatByID(int seatId) {
        return getSeatById(seatId);
    }
    public boolean addSeat(Seat seat){
        return seatMapper.addSeat(seat) > 0;
    }

    public boolean deleteSeat(int seatID){
        return seatMapper.deleteSeat(seatID) > 0;
    }

    public boolean updateSeatStatus(Seat seat,int Status){
        return seatMapper.updateSeatStatus(seat,Status) > 0;
    }
}
