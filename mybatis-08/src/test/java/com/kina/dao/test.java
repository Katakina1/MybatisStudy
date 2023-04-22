package com.kina.dao;


import com.kina.pojo.Blog;
import com.kina.utils.IDutils;
import com.kina.utils.MybatisUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class test {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务");
        mapper.addBlog(blog);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogIF() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, String> map = new HashMap<>();
//        map.put("title", "Mybatis");
        map.put("author", "狂神说");
        List<Blog> blogsList = mapper.queryBlogIF(map);
        for (Blog blog :
                blogsList) {
            System.out.println(blog.toString());
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogChooseTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, String> map = new HashMap<>();
//        map.put("title", "Mybatis");
//        map.put("author", "狂神说");
        map.put("views", "9999");
        List<Blog> blogList = mapper.queryBlogChoose(map);
        for (Blog blog :
                blogList) {
            System.out.println(blog.toString());
        }
        sqlSession.close();
    }

    @Test
    public void updateBlogTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
       // map.put("title", "java如此简单2");
        map.put("author", "战士");
        map.put("id", "b26eeea6c1904e92bc44f610e548be49");
        int res = mapper.updateBlog(map);
        if (res > 0) {
            System.out.println("更新成功！");
        }
        sqlSession.close();
    }


    @Test
    public void queryBlogForeachTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        List<String> idList = new ArrayList<>();
        idList.add("1");
        idList.add("2");
        idList.add("3");
        map.put("idList", idList);
        List<Blog> blogList = mapper.queryBlogForeach(map);
        for (Blog blog :
                blogList) {
            System.out.println(blog.toString());
        }
        sqlSession.close();
    }
}
