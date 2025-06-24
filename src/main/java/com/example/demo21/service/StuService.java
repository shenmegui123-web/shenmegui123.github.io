package com.example.demo21.service;
import com.example.demo21.pojo.Student;
import java.util.List;
import java.util.Map;

public interface StuService {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    Student selectStudentByNo(String no);
    Student addStudent(Student stu);
    boolean updateStudent(int stuId, Student stu);
    void deleteStudent(int id);
    List<Student> retrieveStudentsByName(String stuName);
    List<Student> selectStudentsByConditions(Map<String, Object> queryConditions);
    Student login(Map<String, Object> queryConditions);
    List<Student> getStudentsByTeacherUsername(String username);
}
