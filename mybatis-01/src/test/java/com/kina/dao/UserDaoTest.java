package com.kina.dao;

import com.kina.pojo.User;
import com.kina.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void test() {

        // 第一步 ：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            // 方式一：执行SQL
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userDao.getUserList();
            for (User user :
                    userList) {
                System.out.println(user);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("value", "刘_");
        List<User> userList = mapper.getUserLike(map);
        for (User user : userList) {
            System.out.println(user.toString());
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testGetUserById2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("id", 5);
        User user = mapper.getUserById2(map);
        System.out.println(user.toString());
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    // 增删改必需要提交事务
    @Test
    public void addUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.addUser(new User(4, "帅哥", "23445"));
        if (res > 0) {
            System.out.println("插入成功！");
        }

        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2Test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("userId", 5);
        map.put("userName", "hello");
        map.put("userPassword", "123455");

        int res = mapper.addUser2(map);
        if (res > 0) {
            System.out.println("插入成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updateUser(new User(4, "好好", "2343"));
        if (res > 0) {
            System.out.println("修改成功！");
        }

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }
}
