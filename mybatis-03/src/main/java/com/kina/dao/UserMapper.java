package com.kina.dao;

import com.kina.pojo.User;

import java.util.List;

//操纵数据库对象实体
public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();

    // 根据ID查询用户
    User getUserById(int id);

}
