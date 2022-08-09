package com.kk.service;

import com.kk.mapper.DepartmentMapper;
import com.kk.mapper.EmployeeMapperBak;
import com.kk.pojo.Department;
import com.kk.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentService9 {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departmentList = departmentMapper.selectDepartmentByDId(1);
        System.out.println(departmentList);
    }
}