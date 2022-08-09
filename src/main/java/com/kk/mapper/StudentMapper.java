package com.kk.mapper;

import com.kk.pojo.Student;

import java.util.Map;

public interface StudentMapper {
    public abstract int insertStudent();
    public abstract int deleteStudent();
    public abstract int updateStudent();
    public abstract Student selectStudent();
    public abstract Student selectStudentByName(String name);
    public abstract Student selectStudentByNameAndAge(Map map);
}
