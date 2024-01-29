package com.iyo.service;

import com.iyo.dao.ReservationsDao;
import com.iyo.pojo.Reservation;
import com.iyo.pojo.Seat;
import com.iyo.pojo.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReservationService {

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    ReservationsDao reservationsDao = new ReservationsDao();


    public boolean reserve(User user, Seat seat){
        String sql = "insert into reservations(UserID,SeatID,RoomID,StartTime,IsConfirmed) values (?,?,?,?,?)";
        Date date = new Date();//获得当前时间
        Object[] params = {
                user.getUserID(),
                seat.getSeatID(),
                seat.getRoomID(),
                dateFormat.format(date),
                0
        };
       return reservationsDao.update(sql,params);
    }

    public Reservation getReservationById(int ReserveId){
        String sql = "select * from reservations where ReservationID=?";
        Object[] params = {
                ReserveId
        };
        return reservationsDao.get(sql,Reservation.class,params);
    }
    public Reservation getReservationByUserIdAndConfirmed(int UserID){
        String sql = "select * from reservations where UserID=? and IsConfirmed=0";
        Object[] params = {
               UserID
        };
        return reservationsDao.get(sql,Reservation.class,params);
    }

    public List<Reservation> getReservationByUserId(int UserID){
        String sql = "select * from reservations where UserID=?";
        Object[] params = {
                UserID
        };
        return reservationsDao.query(sql,Reservation.class,params);
    }

    public List<Reservation> getReservationByRoomId(int RoomID){
        String sql = "select * from reservations where RoomID=?";
        Object[] params = {
                RoomID
        };
        return reservationsDao.query(sql,Reservation.class,params);
    }

    public List<Reservation> getReservationBySeatId(int SeatID){
        String sql = "select * from reservations where SeatID=?";
        Object[] params = {
                SeatID
        };
        return reservationsDao.query(sql,Reservation.class,params);
    }

    public boolean unReserve(Reservation reservation){
        String sql = "update reservations set EndTime=?,IsConfirmed=? where ReservationID=?";
        Date date = new Date();//获得当前时间
        Object[] params = {
                dateFormat.format(date),
                1,
                reservation.getReservationID()
        };
        return reservationsDao.update(sql,params);
    }
}
