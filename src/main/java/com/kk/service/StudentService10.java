package com.kk.service;

import com.kk.mapper.DepartmentMapper;
import com.kk.pojo.Department;
import com.kk.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentService10 {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        /*
            一级缓存：使用相同的 SqlSession + 相同的 Sql 语句就会触发一级缓存
            一级缓存失效原因：
            1.SqlSession 不同
            2.SqlSession 虽然相同但是 SQL 语句不同
            3.SqlSession 和 SQL 语句虽然都相同但是两个执行中间有增删改操作
            4.SqlSession 和 SQL 语句虽然都相同但是手动清除了缓存造成一级缓存失效
         */
        List<Department> departmentList1 = departmentMapper.selectDepartmentByDId(1);
        System.out.println(departmentList1);
        List<Department> departmentList2 = departmentMapper.selectDepartmentByDId(1);
        System.out.println(departmentList2);
    }
}