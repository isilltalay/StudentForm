package com.student.service;

import com.student.entity.Grade;
import com.student.entity.Lesson;
import com.student.entity.Student;
import com.student.repository.GradeRepository;
import com.student.request.GradeCreateRequest;
import com.student.request.GradeUpdateRequest;
import com.student.response.GradeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GradeService {
    private  GradeRepository gradeRepository;
    private StudentService studentService;
    private LessonService LessonService;


    public GradeService(GradeRepository gradeRepository,StudentService studentService) {
        this.gradeRepository = gradeRepository;
        this.studentService=studentService;
    }

    public List<GradeResponse> getAllGrades(Optional<Long> studentId, Optional<Long> lessonId) {
        List<Grade> list;
        if(studentId.isPresent() && lessonId.isPresent())
            list= gradeRepository.findByStudentIdAndLessonId(studentId,lessonId);
            list=gradeRepository.findAll();
            return list.stream().map(p->new GradeResponse(p)).collect(Collectors.toList());
    }

    public Grade getOneGradeById(Long gradeId) {
        return gradeRepository.findById(gradeId).orElse(null);
    }

    public Grade createOneGrade(GradeCreateRequest newGrade) {
      Student student = studentService.getOneStudent(newGrade.getStudentId());
      Lesson lesson = LessonService.getOneLesson(newGrade.getLessonId());
      if(student ==null || lesson==null)
          return null;
      Grade toSave = new Grade();
      toSave.setId(newGrade.getId());
      toSave.setStudent(student);
      toSave.setLesson(lesson);
      toSave.setMidtermExam(newGrade.getMidterm_exam());
      toSave.setFinalExam(newGrade.getFinal_exam());
      float average= averageGrade(newGrade.getMidterm_exam(), newGrade.getFinal_exam());
      toSave.setAverage(average);
      Status status=status(newGrade.getMidterm_exam(), newGrade.getFinal_exam());
      toSave.setStatus(status);
      return gradeRepository.save(toSave);
    }

    public float averageGrade(float midTermExam,float finalExam){
        return (midTermExam+finalExam)/2;
    }
    public Status status(float midTermExam, float finalExam){
        if(averageGrade(midTermExam,finalExam)<=49){
           return Status.PASSIVE;
        }
        return Status.ACTIVE;
    }

    public Grade gradeOneGrade(Long gradeId, GradeUpdateRequest updateGradeRequest) {
        Optional<Grade> grade = gradeRepository.findById(gradeId);
        if(grade.isPresent()){
            Grade toUpdate = grade.get();
            toUpdate.setMidtermExam(updateGradeRequest.getMidterm_exam());
            toUpdate.setFinalExam(updateGradeRequest.getFinal_exam());
            float average = averageGrade(updateGradeRequest.getMidterm_exam(),updateGradeRequest.getFinal_exam());
            toUpdate.setAverage(average);
            Status status = status(updateGradeRequest.getMidterm_exam(), updateGradeRequest.getFinal_exam());
            toUpdate.setStatus(status);
            gradeRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deleteOnePost(Long gradeId) {
        gradeRepository.deleteById(gradeId);
    }
}
