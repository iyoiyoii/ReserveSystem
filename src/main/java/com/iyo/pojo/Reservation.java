package com.iyo.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Start = null;
        String End;
        if (null != StartTime) {
            Start = dateFormat.format(StartTime);
        }
        if (null != EndTime) {
            End = dateFormat.format(EndTime);
        }else {
            End = "yyyy-MM-dd HH:mm:ss";
        }

        return  ReservationID + ("\t\t") + UserID + ("\t\t")
                + SeatID + ("\t\t") + RoomID+ ("\t\t")
                + Start + ("\t") + End + ("\t\t")
                + IsConfirmed;
    }
}
