package com.kina.dao;

import com.kina.pojo.User;
import com.kina.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUsers();
        for (User user :
                userList) {
            System.out.println(user.toString());
        }
        sqlSession.close();
    }

    @Test
    public void getUserByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(2);
        System.out.println(user.toString());

        sqlSession.close();
    }

    @Test
    public void addUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.addUser(new User(7,"helo", "2004270"));

        if (res > 0) {
            System.out.println("插入成功！！");
        }

        sqlSession.close();
    }

    @Test
    public void UpdateUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.UpdateUser(new User(5, "keate", "3434"));
        if (res > 0) {
            System.out.println("修改成功！！！");
        }

        sqlSession.close();
    }

    @Test
    public void deleteUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(6);
        if (res > 0) {
            System.out.println("删除成功！！");
        }
        sqlSession.close();
    }
}
