package com.revature.spring.jparest.service;

import com.revature.spring.jparest.model.Student;
import com.revature.spring.jparest.repo.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private Student student;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        student = new Student();
        student.setId(1L);
        student.setName("Alice");
        student.setEmail("alice@example.com");
        student.setCourse("Computer Science");
    }

    @Test
    void testCreateStudent() {
        when(studentRepository.save(student)).thenReturn(student);

        Student saved = studentService.createStudent(student);

        assertThat(saved).isNotNull();
        assertThat(saved.getName()).isEqualTo("Alice");

        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void testGetAllStudents() {
        when(studentRepository.findAll()).thenReturn(List.of(student));

        List<Student> students = studentService.getAllStudents();

        assertThat(students).hasSize(1);
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void testGetStudentById() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student found = studentService.getStudent(1L);

        assertThat(found).isNotNull();
        assertThat(found.getEmail()).isEqualTo("alice@example.com");
    }

    @Test
    void testUpdateStudent() {
        Student updated = new Student();
        updated.setName("Alice Updated");
        updated.setEmail("alice.updated@example.com");
        updated.setCourse("Math");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(studentRepository.save(any(Student.class))).thenReturn(updated);

        Student result = studentService.updateStudent(1L, updated);

        assertThat(result.getName()).isEqualTo("Alice Updated");
    }

    @Test
    void testDeleteStudent() {
        doNothing().when(studentRepository).deleteById(1L);

        studentService.deleteStudent(1L);

        verify(studentRepository, times(1)).deleteById(1L);
    }
}
