package com.example.demo21.service;
import com.example.demo21.pojo.Student;
import java.util.List;
import java.util.Map;

public interface StuService {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    Student addStudent(Student stu);
    boolean updateStudent(int stuId, Student stu);  //can return void/int/bool/Student
    void deleteStudent(int id);  //can return void/int/bool/Student
    List<Student> retrieveStudentsByName(String stuName);
    List<Student> selectStudentsByConditions(Map<String, Object> queryConditions);

}
