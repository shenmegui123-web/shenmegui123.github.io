package com.example.demo21.mapper;

import com.example.demo21.pojo.Student;
import com.example.demo21.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherMapper {
    List<Teacher> getAllTeacher();
    Teacher login(Map<String, Object> params);
    Teacher insert(Teacher teacher);
    boolean delete(String username);
}


