package com.kk.mapper;

import com.kk.pojo.Student;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    public abstract int insertStudent();
    public abstract int deleteStudent();
    public abstract int updateStudent();
    public abstract Student selectStudent();
    public abstract Student selectStudentByName(String name);
    public abstract Student selectStudentByNameAndAge(Map map);
    public abstract Student selectStudentByNameAndAge(Student student);
    public abstract Student selectStudentByParam(@Param(value = "idCool") Integer id);
    public abstract List<Student> selectStudentForList();
    @MapKey(value = "id")
    public abstract Map<String, Student> selectStudentForMap();
    public abstract List<Student> selectStudentByFind1(String name);
    public abstract List<Student> selectStudentByFind2(String name);
    public abstract List<Student> selectStudentByFind3(String name);
}
