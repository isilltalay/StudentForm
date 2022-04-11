package com.student.repository;

import com.student.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.List;
import java.util.Optional;


public interface GradeRepository extends JpaRepository<Grade,Long>{
    List<Grade> findByStudentId(Optional<Long> studentId);

    List<Grade> findByStudentIdAndLessonId(Optional<Long> studentId, Optional<Long> lessonId);
    //  List<Grade> findByStudentIdAndLessonById(Long lessonId, Long studentId);
}
