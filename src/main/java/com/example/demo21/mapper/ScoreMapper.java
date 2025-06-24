package com.example.demo21.mapper;

import com.example.demo21.pojo.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface ScoreMapper {
    void insertScore(@Param("studentId") int studentId,
                     @Param("subjectId") int subjectId,
                     @Param("score") double score);

    List<Score> getScoresBySubjectId(int subjectId);

    void updateScore(@Param("studentId") int studentId,
                     @Param("subjectId") int subjectId,
                     @Param("score") double score);

    List<Map<String, Object>> getScoresByStudentId(int studentId);

    void insertScoreByTeacherUsername(
            @Param("studentId") int studentId,
            @Param("teacherUsername") String teacherUsername,
            @Param("score") double score);

    Optional<Double> getStudentScoreByTeacher(@Param("studentId") int studentId,
                                              @Param("teacherUsername") String teacherUsername);
}