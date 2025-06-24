package com.example.demo21.service;

import com.example.demo21.mapper.ScoreMapper;
import com.example.demo21.pojo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private TeacherService teacherService;

    public void addOrUpdateScore(int studentId, int subjectId, double score) {
        scoreMapper.insertScore(studentId, subjectId, score);
    }

    public List<Score> getScoresBySubject(int subjectId) {
        return scoreMapper.getScoresBySubjectId(subjectId);
    }

    public List<Map<String, Object>> getMyScores(int studentId) {
        return scoreMapper.getScoresByStudentId(studentId);
    }

    public void addScoreForTeacher(int studentId, String teacherUsername, double score) {
        // 插入或更新成绩
        scoreMapper.insertScoreByTeacherUsername(studentId, teacherUsername, score);
    }

    public Optional<Double> getStudentScoreByTeacher(int studentId, String teacherUsername) {
        return scoreMapper.getStudentScoreByTeacher(studentId, teacherUsername);
    }
}
