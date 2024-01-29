package com.iyo.pojo;

import java.util.Date;

public class Reservation {
    private int ReservationID;
    private int UserID;
    private int SeatID;

    private Date StartTime;

    private Date EndTime;

    private int IsConfirmed;
    private int RoomID;

    public int getReservationID() {
        return ReservationID;
    }

    public void setReservationID(int reservationID) {
        ReservationID = reservationID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getSeatID() {
        return SeatID;
    }

    public void setSeatID(int seatID) {
        SeatID = seatID;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    public int getIsConfirmed() {
        return IsConfirmed;
    }

    public void setIsConfirmed(int isConfirmed) {
        IsConfirmed = isConfirmed;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "ReservationID=" + ReservationID +
                ", UserID=" + UserID +
                ", SeatID=" + SeatID +
                ", StartTime=" + StartTime +
                ", EndTime=" + EndTime +
                ", IsConfirmed=" + IsConfirmed +
                ", RoomID=" + RoomID +
                '}';
    }
}
