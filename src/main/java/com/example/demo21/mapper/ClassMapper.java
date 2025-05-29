package com.example.demo21.mapper;

import com.example.demo21.pojo.StuClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {
    public List<StuClass> selectAllClasses();
}
