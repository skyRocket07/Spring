package com.spring.demo.service;

import java.util.List;

import com.spring.demo.dto.StudentDto;

public interface StudentService {

	List<StudentDto> searchByNameOrPhoneNumber(String searchTerm);

	List<StudentDto> searchByName(String name);

	List<StudentDto> searchByPhoneNumber(String phoneNumber);

}
