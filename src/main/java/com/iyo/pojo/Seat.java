package com.iyo.pojo;

import java.util.Date;

public class Seat {
    private int SeatID;

    private int RoomID;

    private int Status;

    private int RoomSeatID;
    private int SeatRow;

    private int ReservationID;

    private int UserID;
    private Date StartTime;

    private Date EndTime;

    private int IsConfirmed;


    public int getSeatID() {
        return SeatID;
    }

    public void setSeatID(int seatID) {
        SeatID = seatID;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getRoomSeatID() {
        return RoomSeatID;
    }

    public void setRoomSeatID(int roomSeatID) {
        RoomSeatID = roomSeatID;
    }

    public int getSeatRow() {
        return SeatRow;
    }

    public void setSeatRow(int seatRow) {
        SeatRow = seatRow;
    }

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

    @Override
    public String toString() {
        return  SeatID + ("\t")
                + RoomID + ("\t")
                + RoomSeatID + ("\t")
                + SeatRow + ("\t")
                + Status + ("\t");
    }
}
