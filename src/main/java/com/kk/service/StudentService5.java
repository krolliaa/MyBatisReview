package com.kk.service;

import com.kk.mapper.EmployeeMapperBak;
import com.kk.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentService5 {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmployeeMapperBak employeeMapperBak = sqlSession.getMapper(EmployeeMapperBak.class);
        List list1 = employeeMapperBak.selectEmployeeByListTypeAliases();
        System.out.println(list1);
        List list2 = employeeMapperBak.selectEmployeeByListMapUnderscoreToCamelCase();
        System.out.println(list2);
        List list3 = employeeMapperBak.selectEmployeeByResultMap();
        System.out.println(list3);
    }
}