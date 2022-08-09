package com.kk.service;

import com.kk.mapper.StudentMapper;
import com.kk.pojo.Student;
import com.kk.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService3 {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List list = studentMapper.selectStudentForList();
        System.out.println(list);
        Map map = studentMapper.selectStudentForMap();
        System.out.println(map);
    }
}