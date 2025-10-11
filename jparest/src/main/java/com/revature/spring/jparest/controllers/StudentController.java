package com.revature.spring.jparest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.spring.jparest.model.Student;
import com.revature.spring.jparest.service.StudentService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    
    // Get all students
    @GetMapping("/students")
        public List<Student> getAllStudents(){
            return studentService.getAllStudents();
        }
    
    // You can add a path variable to get one single student by id if needed example below
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable Long studentId){
        return studentService.getStudent(studentId);
    }

    //Delete student by id if needed
    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
    }

    //Update student details if needed
    @PutMapping("students/{studentId}")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody Student student){
        return studentService.updateStudent(studentId, student);
    }
}

