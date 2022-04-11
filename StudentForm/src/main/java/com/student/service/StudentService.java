package com.student.service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveOneStudent(Student newStudent) {
        Student student = new Student();
        Status status = status(newStudent.getYear());
        student.setStatus(status);
        return studentRepository.save(newStudent);

    }

    public Student getOneStudent(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public Student updateOneStudent(Long studentId, Student newStudent) {
        Optional<Student> student =studentRepository.findById(studentId);
        if(student.isPresent()){
            Student foundStudent = student.get();
            foundStudent.setName(newStudent.getName());
            foundStudent.setLastName(newStudent.getLastName());
            studentRepository.save(foundStudent);
            return foundStudent;
        }
        else
            return null;
    }

    public void deleteById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
    public Status status(Long year){
        if(year==2021 || year==2020){
          return Status.ACTIVE;
        }
        return Status.PASSIVE;
    }
}
