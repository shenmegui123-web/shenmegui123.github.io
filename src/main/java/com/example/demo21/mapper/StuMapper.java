package com.example.demo21.mapper;

import com.example.demo21.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StuMapper {
    List<Student> selectAll();
    Student selectStudentById(int id);
    Student selectStudentByNo(String no);
    boolean insert(Student stu);
    boolean update(int id, Student stu);
    boolean delete(int id);
    List<Student> selectStudentsByName(String stuName);
    List<Student> selectstudentByConditions(Map<String, Object> params);
    Student login(Map<String, Object> params);
    List<Student> getStudentsByTeacherUsername(String username);
}
