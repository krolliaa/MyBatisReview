package com.kk.service;

import com.kk.mapper.StudentMapper;
import com.kk.pojo.Student;
import com.kk.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class StudentService2 {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.selectStudentByName("tom");
        System.out.println(student);
    }
}