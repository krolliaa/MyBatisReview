package com.kk.service;

import com.kk.mapper.StudentMapper;
import com.kk.pojo.Student;
import com.kk.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class StudentService4 {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List list1 = studentMapper.selectStudentByFind1("o");
        System.out.println(list1);
        List list2 = studentMapper.selectStudentByFind2("o");
        System.out.println(list2);
        List list3 = studentMapper.selectStudentByFind3("o");
        System.out.println(list3);
        Student student = new Student();
        student.setName("pat");
        student.setAge(21);
        int result = studentMapper.insertStudentUseGeneratedKeys(student);
        System.out.println(result);
    }
}