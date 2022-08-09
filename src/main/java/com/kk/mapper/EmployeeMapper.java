package com.kk.mapper;

import com.kk.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    public abstract List<Employee> selectEmployeeByListTypeAliases();
    public abstract List<Employee> selectEmployeeByListMapUnderscorpeToCamelCase();
}
