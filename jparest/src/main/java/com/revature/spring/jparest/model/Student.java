package com.revature.spring.jparest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "students")   // Optional: Specify table name if different from class name 
public class Student {
    @Id //specifies the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-generates the value of the primary key
    private Long studentId;

    private String name;

    private String email;

    private String course;

}
