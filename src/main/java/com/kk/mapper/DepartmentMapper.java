package com.kk.mapper;

import com.kk.pojo.Department;

import java.util.List;

public interface DepartmentMapper {
    public abstract List<Department> selectDepartmentByDId(Integer did);
}
