package com.kk.mapper;

import com.kk.pojo.Student;

public interface StudentMapper {
    public abstract int insertStudent();
    public abstract int deleteStudent();
    public abstract int updateStudent();
    public abstract Student selectStudent();
}
