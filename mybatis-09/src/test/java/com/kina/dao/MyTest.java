package com.kina.dao;

import com.kina.pojo.User;
import com.kina.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void test() {
        // 一级缓存是默认开启的，只在一次sqlSession中有效。
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user.toString());

        // 增删改都会清理一级缓存
//        mapper.updateUser(new User(2, "aaaa", "bbbbb"));
        // 手动清理一级缓存
        sqlSession.clearCache();
        System.out.println("===============");
        User user2 = mapper.queryUserById(1);
        System.out.println(user2.toString());
        System.out.println(user == user2);
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.queryUserById(1);
        System.out.println(user1.toString());
        sqlSession1.close();


        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2.toString());
        System.out.println(user1 == user2);

        sqlSession2.close();
    }
}
