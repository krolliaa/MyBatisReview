package com.kk.service;

import com.kk.mapper.EmployeeMapperBak;
import com.kk.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentService7 {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmployeeMapperBak employeeMapperBak = sqlSession.getMapper(EmployeeMapperBak.class);
        List list1 = employeeMapperBak.selectEmployeeByAssociationAndLazyLoad();
        System.out.println(list1);
    }
}