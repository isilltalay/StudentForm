package com.student.request;

import lombok.Data;

@Data
public class GradeUpdateRequest {
    Long id;
    int midterm_exam;
    int final_exam;
    Long studentId;
    Long lessonId;
}
