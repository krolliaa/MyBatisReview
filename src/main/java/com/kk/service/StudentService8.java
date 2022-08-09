package com.kk.service;

import com.kk.mapper.EmployeeMapper;
import com.kk.pojo.Department;
import com.kk.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class StudentService8 {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        //使用 LazyLoad 懒加载的好处
        String employeeName = employeeMapper.selectEmployeeByAssociationAndLazyLoadGreat(1).getEmpName();
        System.out.println(employeeName);
        //Department department = employeeMapper.selectEmployeeByAssociationAndLazyLoadGreat(1).getDepartment();
        //System.out.println(department);
    }
}