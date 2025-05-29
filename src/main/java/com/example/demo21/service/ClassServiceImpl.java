package com.example.demo21.service;

import com.example.demo21.mapper.ClassMapper;
import com.example.demo21.pojo.StuClass;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    private ClassMapper classMapper;

    public ClassServiceImpl(ClassMapper classMapper) {
        this.classMapper = classMapper;
    }

    @Override
    public List<StuClass> getAllClasses() {
        return classMapper.selectAllClasses();
    }
}
