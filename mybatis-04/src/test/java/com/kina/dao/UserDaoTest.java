package com.kina.dao;

import com.kina.pojo.User;
import com.kina.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);
    @Test
    public void test() {

        // 第一步 ：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        logger.debug("进入test类成功！");

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
    public void testGetUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        List<User> userList = mapper.getUserByLimit(map);
        for (User user :
                userList) {
            System.out.println(user.toString());
        }
        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        logger.info("info:进入了log4j");
        logger.debug("debug:进入了log4j");
        logger.error("error：进入了log4j");
    }

}
