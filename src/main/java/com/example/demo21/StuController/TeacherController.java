package com.example.demo21.StuController;

import com.example.demo21.pojo.Student;
import com.example.demo21.pojo.Teacher;
import com.example.demo21.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/api/getAllTeacher")
    public List<Teacher> getAllTeacher() {
        return teacherService.getAllTeacher();
    }

    @GetMapping("/api/teacherlogin")
    public ResponseEntity<Teacher> teacherlogin(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password) {

        Map<String, Object> conditions = new HashMap<>();
        if(username != null) conditions.put("username", username);
        if(password != null) conditions.put("password", password);

        Teacher teachers = teacherService.login(conditions);
        return ResponseEntity.ok(teachers);
    }

    @PostMapping("/api/addTeacher")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        Teacher teachers = teacherService.addTeacher(teacher);
        return ResponseEntity.ok(teachers);
    }

    @DeleteMapping("/api/deleteTeacher/{username}")
    public List<Teacher> deleteTeacher(@PathVariable("username") String username) {
       teacherService.deleteTeacher(username);
       return teacherService.getAllTeacher();
    }
}
