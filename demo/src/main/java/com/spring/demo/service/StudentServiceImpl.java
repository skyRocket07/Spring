package com.spring.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.Entity.Student;
import com.spring.demo.dto.StudentDto;
import com.spring.demo.mapper.StudentMapper;
import com.spring.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<StudentDto> searchByNameOrPhoneNumber(String searchTerm) {
		List<Student> students = studentRepository.findByFirstNameContainingOrPhoneNumberContaining(searchTerm,searchTerm);
		return students.stream().map(StudentMapper.INSTANCE::toDto).collect(Collectors.toList());
	}

	@Override
	public List<StudentDto> searchByName(String name) {
		List<Student>students = studentRepository.findByFirstNameContaining(name);
		return students.stream().map(StudentMapper.INSTANCE::toDto).collect(Collectors.toList());
	}

	@Override
	public List<StudentDto> searchByPhoneNumber(String phoneNumber) {
		List<Student>students = studentRepository.findByPhoneNumberContaining(phoneNumber);
		return students.stream().map(StudentMapper.INSTANCE::toDto).collect(Collectors.toList());
	}

}
