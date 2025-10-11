package com.revature.spring.jparest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.spring.jparest.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
