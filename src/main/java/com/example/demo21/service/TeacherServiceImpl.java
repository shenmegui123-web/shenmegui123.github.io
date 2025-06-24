package com.example.demo21.service;

import com.example.demo21.mapper.StuMapper;
import com.example.demo21.mapper.TeacherMapper;
import com.example.demo21.pojo.Student;
import com.example.demo21.pojo.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final StuMapper stuMapper;
    private TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherMapper teacherMapper, StuMapper stuMapper) {
        this.teacherMapper = teacherMapper;
        this.stuMapper = stuMapper;
    }

    public List<Teacher> getAllTeacher() {
        return teacherMapper.getAllTeacher();
    }

    public Teacher login(Map<String, Object> queryConditions) {
        return teacherMapper.login(queryConditions);
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    @Override
    public void deleteTeacher(String username) {
        teacherMapper.delete(username);
    }
}
