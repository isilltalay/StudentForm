package com.student.response;

import com.student.entity.Grade;
import com.student.service.Status;
import lombok.Data;

@Data
public class GradeResponse {
    Long id;
    int midterm_exam;
    int final_exam;
    Long studentId;
    Long lessonId;
    Status status;
    float average;
    String lessonName;
    String studentName;



    public GradeResponse(Grade grade){
    }
}
