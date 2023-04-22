package com.kina.dao;

import com.kina.pojo.User;

import java.util.List;
import java.util.Map;

//操纵数据库对象实体
public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();

    // 根据ID查询用户
    User getUserById(int id);

    // insert一个用户
    int addUser(User user);

    // 修改用户
    int updateUser(User user);

    // 删除一个用户
    int deleteUser(int id);
}
