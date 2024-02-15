package com.spring.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.spring.demo.dto.StudentDto;

public interface StudentService {

	List<StudentDto> searchByNameOrPhoneNumber(String searchTerm);

	List<StudentDto> searchByName(String name);

	List<StudentDto> searchByPhoneNumber(String phoneNumber);

	List<StudentDto> getAllStudents();

	List<StudentDto> getAllSortedStudents(String criteria);

	Page<StudentDto> getStudentPage(Integer offset, Integer pagesize);

	Page<StudentDto> getSortedStudentPage(Integer offset, Integer pagesize, String criteria);



	
}
