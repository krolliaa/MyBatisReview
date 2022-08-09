package com.kk.service;

import com.kk.mapper.EmployeeMapper;
import com.kk.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentService7 {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List list1 = employeeMapper.selectEmployeeByAssociationAndLazyLoad();
        System.out.println(list1);
    }
}