package com.revature.spring.jparest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.spring.jparest.model.Student;
import com.revature.spring.jparest.repo.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;


    //Injected the repository using constructor injection (right click source action -> generate constructor using fields)
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    // Must have argument of type Student so that we can write jdbc code to add student to db
    public Student createStudent(Student student) { 
        // This will in the background take care of generating sql queries and inserting data into db
        return studentRepository.save(student); 
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //We do property exception or derived query if needed to find student by name or email etc
    public Student getStudent(Long studentId){  
        return studentRepository.findById(studentId).orElse(null); //returns null if student not found
    }

    //Delete student by id if needed

    public void deleteStudent(Long studentId){
        studentRepository.deleteById(studentId);
    }

    //Update student details if needed
    public Student updateStudent(Long studentId, Student updatedStudent){
        return studentRepository.findById(studentId).map(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setCourse(updatedStudent.getCourse());
            return studentRepository.save(student);
        }).orElse(null); //returns null if student not found
    }
}
