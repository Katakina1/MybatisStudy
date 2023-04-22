package com.kina.dao;

import com.kina.pojo.User;

import java.util.List;
import java.util.Map;

//操纵数据库对象实体
public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();

    // 分页
    List<User> getUserByLimit(Map<String, Integer> map);

    // 根据ID查询用户
    User getUserById(int id);

}
