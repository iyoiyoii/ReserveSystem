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
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(format(10,"编号"));
        stringBuffer.append(format(16,"用户名"));
        stringBuffer.append(format(16,"姓名"));
        stringBuffer.append(format(20,"邮箱"));
        stringBuffer.append(format(15,"手机号码"));
        stringBuffer.append(format(10,"预约状态"));
        System.out.println(stringBuffer);
        for (User user : users) {
            System.out.println(user);
        }
    }

    public static void printUserFormat(User user){
        printLine();
        if (null == user)
            return;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(format(10,"编号"));
        stringBuffer.append(format(10,"用户名"));
        stringBuffer.append(format(10,"姓名"));
        stringBuffer.append(format(25,"邮箱"));
        stringBuffer.append(format(15,"手机号码"));
        stringBuffer.append(format(10,"预约状态"));
        System.out.println(stringBuffer);
        System.out.println(user);
    }

    public static void printRoomFormat(List<Room> rooms){
        printLine();
        if (null == rooms)
            return;
        System.out.println("自习室编号" + "自习室名称" + "自习室行数" + "自习室占用情况");
        for (Room room : rooms) {
            System.out.println(room.getRoomID() + ("\t") + room.getRoomName() + ("\t")
                    + room.getRoomRow()+ ("\t")
                    + room.getCurrentOccupancy() + "/" + room.getCapacity());
        }
    }

    public static void printRoomFormat(Room room){
        printLine();
        if (null == room)
            return;
        System.out.println("自习室编号" + "自习室名称" + "自习室行数" + "自习室占用情况");
        System.out.println(room.getRoomID() + ("\t") + room.getRoomName() + ("\t")
                + room.getRoomRow()+ ("\t")
                + room.getCurrentOccupancy() + "/" + room.getCapacity());
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
        for (Seat seat : seats) {
            System.out.println(seat);
        }
    }
    public static void printSeatStatusFormat(List<Seat> seats) {
        if (null == seats)
            return;
        StringBuffer stringBuffer;
        for (Seat seat : seats) {
            stringBuffer = new StringBuffer();
            stringBuffer.append(seat.getSeatID() + ("\t"));
            stringBuffer.append(seat.getRoomID() + ("\t"));
            stringBuffer.append(seat.getRoomSeatID() + ("\t"));
            stringBuffer.append(seat.getSeatRow() + ("\t"));
            stringBuffer.append(seat.getStatus() + ("\t"));
            stringBuffer.append(seat.getUserID() + ("\t"));
            stringBuffer.append(seat.getStartTime() + ("\t"));
            stringBuffer.append(seat.getEndTime() + ("\t"));
            stringBuffer.append(seat.getIsConfirmed() + ("\t"));
            System.out.println(stringBuffer);
        }
    }
    public static void printReservationsFormat(List<Reservation> reservations){
        if (null == reservations)
            return;
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public static void printReservationsFormat(Reservation reservation){
        if (null == reservation)
            return;
        System.out.println(reservation);
    }

    //格式化字符串 对齐
    public static String format(int length,String string) {
        int numCount = 0;
        int zmCount = 0;
        for (int i = 0; i < string.length(); i++) {
            char charAt = string.charAt(i);
            if ((charAt >= '0' && charAt <= '9') || (charAt >= 32 && charAt <= 47) || (charAt >= 58 && charAt <= 64)
                    || (charAt >= 91 && charAt <= 96) || (charAt >= 123 && charAt <= 127))
                numCount++;
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z'))
                zmCount++;
        }
        int formatnum = length - string.length() + numCount + zmCount;
        String f = "%-" + formatnum + "s";
        return String.format(f,string);
    }

    public static int formatnum(int length,String string) {
        int numCount = 0;
        int zmCount = 0;
        for (int i = 0; i < string.length(); i++) {
            char charAt = string.charAt(i);
            if ((charAt >= '0' && charAt <= '9') || (charAt >= 32 && charAt <= 47) || (charAt >= 58 && charAt <= 64)
                    || (charAt >= 91 && charAt <= 96) || (charAt >= 123 && charAt <= 127))
                numCount++;
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z'))
                zmCount++;
        }
        return length - string.length() + numCount + zmCount;
    }


}