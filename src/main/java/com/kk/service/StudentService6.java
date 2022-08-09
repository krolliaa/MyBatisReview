package com.kk.service;

import com.kk.mapper.EmployeeMapperBak;
import com.kk.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentService6 {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmployeeMapperBak employeeMapperBak = sqlSession.getMapper(EmployeeMapperBak.class);
        List list1 = employeeMapperBak.selectEmployeeIncludeDeptResultMap();
        System.out.println(list1);
        List list2 = employeeMapperBak.selectEmployeeByAssociation();
        System.out.println(list2);
    }
}