package com.spring.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student>students = studentRepository.findAll();
		return students.stream().map(StudentMapper.INSTANCE::toDto).collect(Collectors.toList());
	}

	@Override
	public List<StudentDto> getAllSortedStudents(String criteria) {
		List<Student>students = studentRepository.findAll(Sort.by(Sort.Direction.ASC,criteria));
		return students.stream().map(StudentMapper.INSTANCE::toDto).collect(Collectors.toList());
	}

	@Override
	public Page<StudentDto> getStudentPage(Integer offset, Integer pagesize) {
		Page<Student> studentPage = studentRepository.findAll(PageRequest.of(offset, pagesize));
		return studentPage.map(StudentMapper.INSTANCE::toDto);
	}

	@Override
	public Page<StudentDto> getSortedStudentPage(Integer offset, Integer pagesize, String criteria) {
		Page<Student> studentPage = studentRepository.findAll(PageRequest.of(offset, pagesize).withSort(Sort.by(Sort.Direction.ASC,criteria)));
		return studentPage.map(StudentMapper.INSTANCE::toDto);
	}

	
    
	
	

}
