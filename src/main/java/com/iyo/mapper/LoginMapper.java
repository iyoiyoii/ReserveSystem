package com.iyo.mapper;

import com.iyo.pojo.Admin;
import com.iyo.pojo.User;

public interface LoginMapper {
    User loginUser(User user);
    Admin loginAdmin(Admin admin);
}
