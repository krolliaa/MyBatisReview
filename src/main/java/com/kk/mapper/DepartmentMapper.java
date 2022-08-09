package com.kk.mapper;

import com.kk.pojo.Department;

public interface DepartmentMapper {
    public abstract Department selectDepartmentByDId(Integer did);
}
