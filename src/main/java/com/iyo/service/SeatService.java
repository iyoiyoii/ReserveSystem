package com.iyo.service;

import com.iyo.dao.SeatDao;
import com.iyo.pojo.Room;
import com.iyo.pojo.Seat;

import java.util.List;

public class SeatService {
    SeatDao seatDao = new SeatDao();

    public Seat getSeatByRoomId(Room room,int SeatId){
        String sql = "select * from seat where RoomID = ? and RoomSeatID=?";
        Object[] params = {
                room.getRoomID(),
                SeatId
        };
        return seatDao.get(sql,Seat.class,params);
    }

    public Seat getSeatById(int SeatId){
        String sql = "select * from seat where SeatID=?";
        Object[] params = {
                SeatId
        };
        return seatDao.get(sql,Seat.class,params);
    }


    public List<Seat> getRoomSeat(int RoomID){
        String sql = "select * from seat where RoomID = ?";
        Object[] params = {
                RoomID
        };
        return seatDao.query(sql,Seat.class,params);
    }

    public List<Seat> getRoomFreeSeat(int RoomID){
        String sql = "select * from seat where RoomID = ? and Status=0";
        Object[] params = {
                RoomID
        };
        return seatDao.query(sql,Seat.class,params);
    }


    public List<Seat> getRoomSeatRow(int RoomID,int Row){
        String sql = "select * from seat where RoomID=? and SeatRow=?";
        Object[] params = {
                RoomID,
                Row
        };
        return seatDao.query(sql,Seat.class,params);
    }

    public List<Seat> getSeatStatusAll(){
        String sql = "select * from seat left join reservations on (reservations.SeatID = seat.SeatID)";
        return seatDao.query(sql,Seat.class,null);
    }


    public List<Seat> getSeatAll(){
        String sql = "select * from seat";
        return seatDao.query(sql,Seat.class,null);
    }

    public List<Seat> getFreeSeat(){
        String sql = "select * from seat where Status=0";
        return seatDao.query(sql,Seat.class,null);
    }

    public boolean addSeat(Seat seat){
        String sql = "insert into seat(RoomID,RoomSeatID,SeatRow,Status) values (?,?,?,?)";
        Object[] params = {
                seat.getRoomID(),
                seat.getRoomSeatID(),
                seat.getSeatRow(),
                seat.getStatus()
        };
        return seatDao.update(sql,params);

    }

    public boolean deleteSeat(int seatID){
        String sql = "delete from seat where SeatID = ?";
        Object[] params = {
                seatID
        };
        return seatDao.update(sql,params);
    }

    public boolean updateSeatStatus(Seat seat,int Status){
        String sql = "update seat set Status=? where SeatID=?";
        Object[] params = {
                Status,
                seat.getSeatID()
        };
        return seatDao.update(sql,params);
    }

    public List<Seat> getRoomSeatRow(Room room){
        String sql = "select * from seat where RoomID=?";
        Object[] params = {
                room.getRoomID()
        };
        return seatDao.query(sql,Seat.class,params);
    }

    public Seat getSeatByID(int seatId) {
        String sql = "select * from seat where SeatID=?";
        Object[] params = {
                seatId
        };
        return seatDao.get(sql,Seat.class,params);
    }
}
