package com.kk.service;

import com.kk.mapper.EmployeeMapper;
import com.kk.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentService5 {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List list1 = employeeMapper.selectEmployeeByListTypeAliases();
        System.out.println(list1);
        List list2 = employeeMapper.selectEmployeeByListMapUnderscoreToCamelCase();
        System.out.println(list2);
        List list3 = employeeMapper.selectEmployeeByResultMap();
        System.out.println(list3);
    }
}