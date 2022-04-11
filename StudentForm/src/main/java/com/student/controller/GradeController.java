package com.student.controller;

import com.student.entity.Grade;
import com.student.request.GradeCreateRequest;
import com.student.request.GradeUpdateRequest;
import com.student.service.GradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grades")
public class GradeController {
    GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public List<Grade> getAllGradesWithParam(@RequestParam Optional<Long> studentId,@RequestParam Optional lessonId) {
        return gradeService.getAllGrades(studentId,lessonId);
    }
    @GetMapping("/{gradeId}")
    public Grade getOneGrade(@PathVariable Long gradeId){
        return gradeService.getOneGradeById(gradeId);
    }
    @PostMapping
    public Grade createOneGrade(@RequestBody GradeCreateRequest newGradeRequest){
        return gradeService.createOneGrade(newGradeRequest);
    }

    @PutMapping("/{gradeId}")
    public Grade updateOneGrade(@PathVariable Long gradeId, @RequestBody GradeUpdateRequest updateGradeRequest){
        return gradeService.gradeOneGrade(gradeId,updateGradeRequest);
    }
    @DeleteMapping("/{gradeId}")
    public void deleteOnePost(@PathVariable Long gradeId){
        gradeService.deleteOnePost(gradeId);
    }
}