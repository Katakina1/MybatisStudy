package com.kina.dao;

import com.kina.pojo.User;

import java.util.List;
import java.util.Map;

//操纵数据库对象实体
public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();

    // 模糊查询
    List<User> getUserLike(Map<String, Object> map);

    // 根据ID查询用户
    User getUserById(int id);

    // 万能的map
    User getUserById2(Map<String, Object> map);

    // insert一个用户
    int addUser(User user);

    // 万能的map
    int addUser2(Map<String, Object> map);

    // 修改用户
    int updateUser(User user);

    // 删除一个用户
    int deleteUser(int id);
}
