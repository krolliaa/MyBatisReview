package com.kk.service;

import com.kk.mapper.StudentMapper;
import com.kk.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class StudentService {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        int resultInsert = studentMapper.insertStudent();
        System.out.println("resultInsert = " + resultInsert);
        Student resultSelect1 = studentMapper.selectStudent();
        System.out.println("resultSelect1 = " + resultSelect1);
        int resultUpdate = studentMapper.updateStudent();
        System.out.println("resultUpdate = " + resultUpdate);
        Student resultSelect2 = studentMapper.selectStudent();
        System.out.println("resultSelect2 = " + resultSelect2);
        int resultDelete = studentMapper.deleteStudent();
        System.out.println("resultDelete = " + resultDelete);
    }
}
