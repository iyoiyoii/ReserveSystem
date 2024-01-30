package com.iyo.mapper;

import com.iyo.pojo.Reservation;
import com.iyo.pojo.Seat;
import com.iyo.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReservationMapper {
    Reservation getReservationById(int ReserveId);
    Reservation getReservationByUserIdAndConfirmed(int UserID);
    List<Reservation> getReservationByUserId(int UserID);
    List<Reservation> getReservationByRoomId(int RoomID);
    List<Reservation> getReservationBySeatId(int SeatID);
    int addReservations(@Param("User") User user, @Param("Seat") Seat seat);
    int deleteReservations(Reservation reservation);

}
