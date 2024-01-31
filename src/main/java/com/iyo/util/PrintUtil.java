package com.iyo.util;


import com.iyo.pojo.Reservation;
import com.iyo.pojo.Room;
import com.iyo.pojo.Seat;
import com.iyo.pojo.User;

import java.util.List;

public class PrintUtil {
    public PrintUtil(){}
    public static void printLine(){
        System.out.println("-".repeat(80));
    }

    public static void printUserFormat(List<User> users){
        printLine();
        if (null == users)
            return;
        String str = "用户编号" + ("\t") + "用户名" + ("\t\t\t")
                + "姓名"  + ("\t\t\t\t") + "邮箱"  + ("\t\t\t\t")
                + "手机号码"  + ("\t\t") + "预约状态";
        System.out.println(str);
        for (User user : users) {
            System.out.println(user);
        }
    }

    public static void printUserFormat(User user){
        printLine();
        if (null == user)
            return;
        String str = "用户编号" + ("\t") + "用户名" + ("\t\t\t")
                + "姓名"  + ("\t\t\t\t") + "邮箱"  + ("\t\t\t\t")
                + "手机号码"  + ("\t\t") + "预约状态";
        System.out.println(str);
        System.out.println(user);
    }

    public static void printRoomFormat(List<Room> rooms){
        printLine();
        if (null == rooms)
            return;
        String str = "自习室编号" + ("\t") + "自习室名称" + ("\t\t\t")
                + "自习室行数" + ("\t") + "自习室占用情况";
        System.out.println(str);
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public static void printRoomFormat(Room room){
        printLine();
        if (null == room)
            return;
        String str = "自习室编号" + ("\t") + "自习室名称" + ("\t\t\t")
                + "自习室行数" + ("\t") + "自习室占用情况";
        System.out.println(str);
        System.out.println(room);
    }

    public static void printSeatsIDFormat(List<Seat> seats){
        if (null == seats)
            return;
        for (Seat seat : seats) {
            System.out.print(seat.getRoomSeatID() + ("\t"));
        }
    }

    public static void printSeatsRealIDFormat(List<Seat> seats){
        if (null == seats)
            return;
        for (Seat seat : seats) {
            System.out.print(seat.getSeatID() + ("\t"));
        }
    }
    public static void printSeatsFormat(List<Seat> seats){
        if (null == seats)
            return;
        String str = "座位号" + ("\t") + "房间号" + ("\t")
                + "房间内座位号" + ("\t") + "座位行"+ ("\t") + "预约状态";
        System.out.println(str);
        for (Seat seat : seats) {
            System.out.println(seat);
        }
    }
    public static void printSeatStatusFormat(List<Seat> seats) {
        if (null == seats)
            return;
        String str = "座位号" + ("\t") + "房间号" + ("\t")
                + "房间内座位号" + ("\t") + "座位行"+ ("\t")
                + "预约状态"+ ("\t") + "座位行"+ ("\t")
                + "预约状态"+ ("\t") + "座位行"+ ("\t");
        System.out.println(str);
        StringBuffer stringBuffer;
        for (Seat seat : seats) {
            stringBuffer = new StringBuffer();
            stringBuffer
                    .append(seat.getSeatID()).append("\t")
                    .append(seat.getRoomID()).append("\t")
                    .append(seat.getRoomSeatID()).append("\t")
                    .append(seat.getSeatRow()).append("\t")
                    .append(seat.getStatus()).append("\t")
                    .append(seat.getUserID()).append("\t")
                    .append(seat.getStartTime()).append("\t")
                    .append(seat.getEndTime()).append("\t")
                    .append(seat.getIsConfirmed()).append("\t");
            System.out.println(stringBuffer);
        }
    }
    public static void printReservationsFormat(List<Reservation> reservations){
        if (null == reservations)
            return;
        String str = "预约号" + ("\t") + "用户编号" + ("\t")
                + "座位号" + ("\t") + "房间号"+ ("\t")
                + "开始时间"+ ("\t\t\t\t") + "结束时间"+ ("\t\t\t\t\t")
                + "签离";
        System.out.println(str);
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}