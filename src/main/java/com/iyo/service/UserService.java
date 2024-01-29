package com.iyo.service;

import com.iyo.dao.UserDao;
import com.iyo.pojo.User;
import com.iyo.view.ViewBase;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();
    public List<User> getUserAll(){
        String sql = "select * from user";
        return userDao.query(sql,User.class,null);
    }

    public List<User> queryUserByWord(String param){
        String sql = "select * from user where " +
                "concat(ifnull(UserName,''),ifnull(Name,''),ifnull(Email,''),ifnull(PhoneNumber,''))" +
                " like ?";
        Object[] params = {
                "%" + param + "%"
        };
        return userDao.query(sql,User.class,params);
    }

    public User queryUserById(int userId){
        String sql = "select * from user where UserId = ?";
        Object[] params = {
                userId
        };
        return userDao.get(sql,User.class,params);
    }

    public User queryUserByName(String UserName){
        String sql = "select * from user where UserName = ?";
        Object[] params = {
           UserName
        };
        return userDao.get(sql,User.class,params);
    }

    public boolean updateUser(User user){
        String sql = "update user set UserPassWord=?,Name=?,Email=?,PhoneNumber=? where UserId=?";
        Object[] params = {
                user.getUserPassWord(),
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getUserID()
        };
        return userDao.update(sql,params);
    }

    public boolean updateUserSeat(User user, int SeatID){
        String sql = "update user set CurrentReservationID=? where UserId=?";
        Object[] params = {
                SeatID,
                user.getUserID()
        };
        return userDao.update(sql,params);
    }

    public boolean addUser(User user){
        String sql = "insert into user(UserName,UserPassWord,Name,Email,PhoneNumber)" +
                "values (?,?,?,?,?)";
        Object[] params = {
                user.getUserName(),
                user.getUserPassWord(),
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber()
        };
        return userDao.update(sql,params);
    }



    public boolean deleteUser(int userId){
        String sql = "delete from user where UserID=?";
        Object[] params = {
                userId
        };
        return userDao.update(sql,params);
    }
}
