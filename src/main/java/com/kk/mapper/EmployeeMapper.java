package com.kk.mapper;

import com.kk.pojo.Employee;
import org.omg.CORBA.portable.ValueBase;

import java.util.List;

public interface EmployeeMapper {
    public abstract List<Employee> selectEmployeeByListTypeAliases();
    public abstract List<Employee> selectEmployeeByListMapUnderscoreToCamelCase();
    public abstract List<Employee> selectEmployeeByResultMap();
    public abstract List<Employee> selectEmployeeIncludeDeptResultMap();
    public abstract List<Employee> selectEmployeeByAssociation();
    public abstract List<Employee> selectEmployeeByAssociationAndLazyLoad();
}
