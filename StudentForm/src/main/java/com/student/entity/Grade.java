package com.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.student.service.Status;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="grade")
@Data
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="student_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="lesson_id", nullable =false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Lesson lesson;

    int midtermExam;
    int finalExam;
    float average;
    Status status;

    public Grade() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return Objects.equals(id, grade.id);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", student=" + student +
                ", lesson=" + lesson +
                ", midtermExam=" + midtermExam +
                ", finalExam=" + finalExam +
                ", avarage=" + average +
                '}';
    }
}
