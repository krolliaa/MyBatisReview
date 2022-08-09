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

        /*
            SqlSessionFactory
            二级缓存：一级缓存默认开启，二级缓存默认不开启
            使用二级缓存需要满足四个条件：
            1.MyBatis 配置文件中 <settings> 标签中需要使用 <setting name="cacheEnabled" value="true"/>
            2.在 mapper.xml 相关 SQL 语句中使用 <cache/> 标签
            3.二级缓存必须在 SqlSession 关闭或提交之后有效，否则数据将保存在一级缓存中，只有在关闭/提交了之后才会保存到二级缓存中
            4.实体类需要使用学历恶化 implements Serializable
         */

        /*
            - 先查询二级缓存，因为二级缓存中可能有其它程序已经查出来的数据，可以直接拿来使用
            - 如果二级缓存没有命中，再查询一级缓存
            - 如果一级缓存也没有名字，则查询数据库
            - SqlSession 关闭后，一级缓存中的数据会写入到二级缓存中
         */
        List<Department> departmentList1 = departmentMapper.selectDepartmentByDId(1);
        System.out.println(departmentList1);
        List<Department> departmentList2 = departmentMapper.selectDepartmentByDId(1);
        System.out.println(departmentList2);
    }
}