package com.kina.dao;

import com.kina.pojo.Student;
import com.kina.pojo.Teacher;
import com.kina.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class test {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher.toString());
        sqlSession.close();
    }

    @Test
    public void getStudentTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentList = mapper.getStudent();
        for (Student student : studentList) {
            System.out.println(student.toString());
        }

        sqlSession.close();
    }

    @Test
    public void getStudent2Test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentList = mapper.getStudent2();
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
        sqlSession.close();
    }



}
