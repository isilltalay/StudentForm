package com.student.controller;

import com.student.entity.Student;
import com.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student newStudent){
        return studentService.saveOneStudent(newStudent);
    }


    @GetMapping("/{studentId}")
    public Student getOneStudent(@PathVariable Long studentId){
        return studentService.getOneStudent(studentId);
    }
    @PutMapping("/{studentId}")
    public Student updateOneStudent(@PathVariable Long studentId,@RequestBody Student newStudent){
        return studentService.updateOneStudent(studentId,newStudent);

    }
    @DeleteMapping("/{studentId}")
    public void deleteOneStudent(@PathVariable Long studentId)
    {
        studentService.deleteById(studentId);
    }
}