package com.kina.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory --> sqlSession
public class MybatisUtils {

    // 提升sqlSessionFactory的作用域
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try{
            // 使用mybatis获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 既然有了sqlSessionFactory, 顾名思义，我们就可以从中获取sqlSession的实例了。
    // sqlSession 完全包含了面向数据库执行SQL命令所需的所有方法

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
