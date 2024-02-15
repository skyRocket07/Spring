package com.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.Entity.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
