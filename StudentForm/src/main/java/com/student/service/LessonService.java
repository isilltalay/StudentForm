package com.student.service;

import com.student.entity.Lesson;
import com.student.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    private LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }
    public List<Lesson>getAllLesson(){
        return lessonRepository.findAll();
    }
    public Lesson getOneLesson(Long lessonId){
        return lessonRepository.findById(lessonId).orElse(null);
    }
    public Lesson saveOneLesson(Lesson newLesson){
        return lessonRepository.save(newLesson);
    }
    public Lesson updateOneLesson(Long lessonId,Lesson newLesson)
    {
        Optional<Lesson> lesson =lessonRepository.findById(lessonId);
        if(lesson.isPresent()){
            Lesson foundLesson = lesson.get();
            foundLesson.setLessonName(newLesson.getLessonName());
            lessonRepository.save(foundLesson);
            return foundLesson;
        }
        else{
            return null;
        }
    }
    public void deleteOneLesson(Long lessonId){
        lessonRepository.deleteById(lessonId);
    }
}
