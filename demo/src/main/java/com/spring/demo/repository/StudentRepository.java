package com.spring.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.Entity.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByFirstNameContainingOrPhoneNumberContaining(String searchTerm1,String searchTerm2);

	List<Student> findByFirstNameContaining(String name);

	List<Student> findByPhoneNumberContaining(String phoneNumber);

	

	
	

}
