package com.example.demo21.StuController;
import com.example.demo21.mapper.ScoreMapper;
import com.example.demo21.pojo.Score;
import com.example.demo21.service.ScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins ="*")
public class ScoreController {
    private final ScoreService scoreService;
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addScore(@RequestParam int studentId, @RequestParam int subjectId, @RequestParam double score) {
        scoreService.addOrUpdateScore(studentId, subjectId, score);
        return ResponseEntity.ok("成绩录入成功");
    }

    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<List<Score>> getScoresBySubject(@PathVariable int subjectId) {
        List<Score> scores = scoreService.getScoresBySubject(subjectId);
        return ResponseEntity.ok(scores);
    }

    @GetMapping("/my-scores")
    public ResponseEntity<List<Map<String, Object>>> getMyScores(
            @RequestParam int studentId) {
        return ResponseEntity.ok(scoreService.getMyScores(studentId));
    }

    @PostMapping("/add1")
    public ResponseEntity<String> addScore(
            @RequestParam int studentId,
            @RequestParam String teacherUsername,
            @RequestParam double score) {

        // 调用 Service 层方法，而不是直接调用 Mapper
        scoreService.addScoreForTeacher(studentId, teacherUsername, score);

        return ResponseEntity.ok("成绩录入成功");
    }

    @GetMapping("/student-course-score")
    public ResponseEntity<Map<String, Object>> getStudentCourseScore(
            @RequestParam int studentId,
            @RequestParam String teacherUsername) {

        Map<String, Object> result = new HashMap<>();

        try {
            Optional<Double> scoreOpt = scoreService.getStudentScoreByTeacher(studentId, teacherUsername);

            if (scoreOpt.isPresent()) {
                result.put("success", true);
                result.put("score", scoreOpt.get());
            } else {
                result.put("success", true);
                result.put("score", "暂无成绩");
            }

        } catch (Exception e) {
            result.put("success", false);
            result.put("message", e.getMessage());
        }

        return ResponseEntity.ok(result);
    }

}
