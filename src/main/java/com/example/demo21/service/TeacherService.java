package com.example.demo21.service;

import com.example.demo21.pojo.StuClass;
import com.example.demo21.pojo.Student;
import com.example.demo21.pojo.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    List<Teacher> getAllTeacher();
    Teacher login(Map<String, Object> queryConditions);
    Teacher addTeacher(Teacher teacher);
    void deleteTeacher(String username);
}

