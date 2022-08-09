package com.kk.service;

import com.kk.mapper.EmployeeMapperBak;
import com.kk.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class StudentService8 {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmployeeMapperBak employeeMapperBak = sqlSession.getMapper(EmployeeMapperBak.class);
        //使用 LazyLoad 懒加载的好处
        String employeeName = employeeMapperBak.selectEmployeeByAssociationAndLazyLoadGreat(1).getEmpName();
        System.out.println(employeeName);
        //Department department = employeeMapper.selectEmployeeByAssociationAndLazyLoadGreat(1).getDepartment();
        //System.out.println(department);
    }
}