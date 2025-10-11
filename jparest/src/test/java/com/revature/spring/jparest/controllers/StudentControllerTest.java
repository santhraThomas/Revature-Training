package com.revature.spring.jparest.controllers;

import com.revature.spring.jparest.model.Student;
import com.revature.spring.jparest.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student();
        student.setId(1L);
        student.setName("John Doe");
    }

    @Test
    void testCreateStudent() throws Exception {
        Mockito.when(studentService.createStudent(any(Student.class))).thenReturn(student);

        mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"John Doe\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    void testGetAllStudents() throws Exception {
        List<Student> students = Arrays.asList(student);
        Mockito.when(studentService.getAllStudents()).thenReturn(students);

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("John Doe"));
    }

    @Test
    void testGetStudentById() throws Exception {
        Mockito.when(studentService.getStudent(1L)).thenReturn(student);

        mockMvc.perform(get("/students/{studentId}", 1L).param("studentId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    void testDeleteStudentById() throws Exception {
        Mockito.doNothing().when(studentService).deleteStudent(1L);

        mockMvc.perform(delete("/students/{studentId}", 1L))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateStudentById() throws Exception {
        Student updatedStudent = new Student();
        updatedStudent.setId(1L);
        updatedStudent.setName("Jane Doe");

        Mockito.when(studentService.updateStudent(eq(1L), any(Student.class))).thenReturn(updatedStudent);

        mockMvc.perform(put("/students/{studentId}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Jane Doe\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Jane Doe"));
    }
}