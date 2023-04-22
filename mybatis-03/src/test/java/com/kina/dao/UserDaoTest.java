package com.kina.dao;

import com.kina.pojo.User;
import com.kina.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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

}
