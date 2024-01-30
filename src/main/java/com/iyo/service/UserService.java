package com.iyo.service;

import com.iyo.dao.UserDao;
import com.iyo.mapper.UserMapper;
import com.iyo.pojo.User;
import com.iyo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserService {
    SqlSession sqlSession;
    UserMapper userMapper;
    public UserService(){
        sqlSession = MybatisUtil.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }
    public List<User> getUserAll(){
        return userMapper.getUserAll();
    }

    public List<User> queryUserByWord(String param){
        return userMapper.queryUserByWord("%" + param + "%");
    }

    public User queryUserById(int userId){
        return userMapper.queryUserById(userId);
    }

    public User queryUserByName(String UserName){
        return userMapper.queryUserByName(UserName);
    }

    public boolean updateUser(User user){
        return userMapper.updateUser(user) > 0;
    }

    public boolean updateUserReservation(User user, int ReservationID){
        return userMapper.updateUserReservation(user,ReservationID) > 0;
    }

    public boolean addUser(User user){
        return userMapper.addUser(user) > 0;
    }



    public boolean deleteUser(int userId){
        return userMapper.deleteUser(userId) > 0;
    }
}
