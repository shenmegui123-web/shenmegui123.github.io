package com.example.demo21.service;

import com.example.demo21.mapper.StuMapper;
import com.example.demo21.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StuServiceImpl implements StuService {
    private StuMapper stuMapper;
    //autowired!! 构造函数 依赖注入 stuMapper的实例

    public StuServiceImpl(StuMapper stuMapper) {
        this.stuMapper = stuMapper;
    }

    @Override
    public List<Student> getAllStudents() {
        return stuMapper.selectAll();
    }

    @Override
    public Student getStudentById(int id) {
        return stuMapper.selectStudentById(id);
    }

    public Student selectStudentByNo(String no) {
        return stuMapper.selectStudentByNo(no);
    }

    @Override
    public Student addStudent(Student stu) {
        // 先查询是否存在该ID
        Student existing = stuMapper.selectStudentById(stu.getId());
        if (existing != null) {
            throw new IllegalArgumentException("学生ID已存在: " + stu.getId());
        }
        stuMapper.insert(stu);
        return stu;
    }

    @Override
    public boolean updateStudent(int stuId, Student stu)
    {
        Student existing = stuMapper.selectStudentById(stu.getId());
        if (existing != null&&existing.getId() != stuId) {
            throw new IllegalArgumentException("学生ID已存在: " + stu.getId());
        }
        stuMapper.update(stuId, stu);
        return true;
    }

    @Override
    public void deleteStudent(int id) {
        stuMapper.delete(id);
    }

    @Override
    public List<Student> retrieveStudentsByName(String stuName) {
        return stuMapper.selectStudentsByName(stuName);
    }

    @Override
    public List<Student> selectStudentsByConditions(Map<String, Object> queryConditions) {
        return stuMapper.selectstudentByConditions(queryConditions);
    }

    public Student login(Map<String, Object> queryConditions) {
        return stuMapper.login(queryConditions);
    }

    @Override
    public List<Student> getStudentsByTeacherUsername(String username) {
        return stuMapper.getStudentsByTeacherUsername(username);
    }
}
