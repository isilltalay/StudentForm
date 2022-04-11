package com.student.entity;

import com.student.service.Status;
import lombok.Data;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String lastName;
    Long year;
    Status status;

    public Student() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", year=" + year +
                ", status=" + status +
                '}';
    }


}
