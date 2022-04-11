package com.student.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="lesson")
@Data
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    String lessonName;

    public Lesson() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(id, lesson.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", lessonName='" + lessonName + '\'' +
                '}';
    }
}
