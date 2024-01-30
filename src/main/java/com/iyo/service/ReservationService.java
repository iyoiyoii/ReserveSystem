package com.iyo.service;

import com.iyo.mapper.ReservationMapper;
import com.iyo.pojo.Reservation;
import com.iyo.pojo.Seat;
import com.iyo.pojo.User;
import com.iyo.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ReservationService {
    SqlSession sqlSession;
    ReservationMapper reservationMapper;
    public ReservationService(){
        sqlSession = SqlSessionUtil.getSqlSession();
        reservationMapper = sqlSession.getMapper(ReservationMapper.class);
    }

    public boolean reserve(User user, Seat seat){
        return reservationMapper.addReservations(user, seat) > 0;
    }

    public Reservation getReservationById(int ReserveId){
        return reservationMapper.getReservationById(ReserveId);
    }
    public Reservation getReservationByUserIdAndConfirmed(int UserID){
        return reservationMapper.getReservationByUserIdAndConfirmed(UserID);
    }

    public List<Reservation> getReservationByUserId(int UserID){
        return reservationMapper.getReservationByUserId(UserID);
    }

    public List<Reservation> getReservationByRoomId(int RoomID){
        return reservationMapper.getReservationByRoomId(RoomID);
    }

    public List<Reservation> getReservationBySeatId(int SeatID){
        return reservationMapper.getReservationBySeatId(SeatID);
    }

    public boolean unReserve(Reservation reservation){
        return reservationMapper.deleteReservations(reservation) > 0;
    }
}
