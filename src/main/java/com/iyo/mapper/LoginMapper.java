package com.iyo.mapper;

import com.iyo.pojo.Admin;
import com.iyo.pojo.User;

public interface LoginMapper {
    User queryUserNameAndPassWord(User user);
    Admin queryAdminNameAndPassWord(Admin admin);
}
