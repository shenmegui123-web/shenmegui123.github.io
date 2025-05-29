package com.example.demo21.StuController;

import com.example.demo21.pojo.StuClass;
import com.example.demo21.service.ClassService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ClassController {
    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/api/getAllClasses")
    public List<StuClass> getAllClasses() {
        return classService.getAllClasses();
    }

}
