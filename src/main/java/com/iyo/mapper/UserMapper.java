package com.iyo.mapper;


import com.iyo.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> getUserAll();
    List<User> queryUserByWord(String param);
    User queryUserById(int userId);
    User queryUserByName(String UserName);
    int updateUser(User user);
    int updateUserReservation(@Param("User") User user,@Param("ReservationID") int Reservation);
    int addUser(User user);
    int deleteUser(int userId);
}
