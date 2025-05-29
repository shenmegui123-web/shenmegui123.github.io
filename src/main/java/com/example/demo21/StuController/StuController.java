package com.example.demo21.StuController;


import com.example.demo21.pojo.Student;
import com.example.demo21.service.StuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class StuController {
    private final StuService stuService;

    //Autowired
    public StuController(StuService stuService) {
        this.stuService = stuService;
    }


    @GetMapping("/api/getAllStudents")
    public List<Student> getAllStudents(){
        return stuService.getAllStudents();
    }

    @GetMapping("/api/retrieveStudentsByName/{stuName}")
    public List<Student> retrieveStudentsByName(@PathVariable("stuName") String name){
        return stuService.retrieveStudentsByName(name);
    }

    @GetMapping("/api/getStudentById/{stuId}")
    public ResponseEntity getStudentById(@PathVariable("stuId") int id)  {
        Student stu = stuService.getStudentById(id);
        if (stu == null) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", "Student " + id + " not found");
            return new ResponseEntity(errorMap, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( stu, HttpStatus.OK);
    }

    @PostMapping("/api/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody Student stu) {
        try {
            Student addedStudent = stuService.addStudent(stu);
            return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
            //参数不合法
        } catch (IllegalArgumentException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/api/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") int stuId, @RequestBody Student stu) {
        try {
            boolean isUpdated = stuService.updateStudent(stuId, stu);
            if (isUpdated) {
                return new ResponseEntity<>(stu, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Update failed.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IllegalArgumentException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/api/deleteStudent/{studentId}")
    public List<Student> deleteStudent(@PathVariable("studentId") int stuId) {
        stuService.deleteStudent(stuId);
        return stuService.getAllStudents();
    }

    // 多条件查询学生
    @GetMapping("/api/getStudentsByConditions")
    public ResponseEntity<List<Student>> getStudentsByConditions(
            @RequestParam(value = "stu_name", required = false) String stu_name,
            @RequestParam(value = "stu_no",required = false) String stu_no,
            @RequestParam(value = "class_id",required = false) String class_id) {

        Map<String, Object> conditions = new HashMap<>();
        if(stu_name != null) conditions.put("stu_name", stu_name);
        if(stu_no != null) conditions.put("stu_no", stu_no);
        if(class_id != null) conditions.put("class_id", class_id);

        List<Student> students = stuService.selectStudentsByConditions(conditions);
        return ResponseEntity.ok(students);
    }
}
