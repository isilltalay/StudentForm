package com.student.controller;

import com.student.entity.Lesson;
import com.student.service.LessonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/lesson")
public class LessonController {
    private LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    public List<Lesson> getAllLesson() {
        return lessonService.getAllLesson();
    }

    @GetMapping("/{lessonId}")
    public Lesson getOneLessonById(@PathVariable Long lessonId) {
        return lessonService.getOneLesson(lessonId);
    }

    @PostMapping
    public Lesson createLesson(@RequestBody Lesson newLesson) {
        return lessonService.saveOneLesson(newLesson);
    }

    @PutMapping("/{lessonId}")
    public Lesson updateOneLesson(@PathVariable Long lessonId, @RequestBody Lesson newLesson) {
        return lessonService.updateOneLesson(lessonId, newLesson);
    }
    @DeleteMapping("/{lessonId}")
    public void deleteOneLesson(@PathVariable Long lessonId){
        lessonService.deleteOneLesson(lessonId);
    }
}