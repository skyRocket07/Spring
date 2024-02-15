package com.spring.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.dto.StudentDto;
import com.spring.demo.service.StudentService;

@RestController
@RequestMapping("/api/")
public class StudentApi {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/search")
	private ResponseEntity<List<StudentDto>>search(@RequestParam(required = false) String name,
			                                       @RequestParam(required = false) String phoneNumber,
			                                       @RequestParam(required = false) String searchTerm){
		if(searchTerm!=null) {
			List<StudentDto>studentDtos = studentService.searchByNameOrPhoneNumber(searchTerm);
			return ResponseEntity.ok(studentDtos);
		}
		else if(name!=null) {
			System.out.println("Hello");
			List<StudentDto>studentDtos = studentService.searchByName(name);
			return ResponseEntity.ok(studentDtos);
		}
		else if(phoneNumber!=null) {
			List<StudentDto>studentDtos = studentService.searchByPhoneNumber(phoneNumber);
			return ResponseEntity.ok(studentDtos);
		}
		else {
			throw new IllegalArgumentException("Atleast one search parameter is required!!");
		}
	}
	
	@GetMapping("/students")
	private ResponseEntity<List<StudentDto>>getAllStudents(){
		List<StudentDto>studentDtos = studentService.getAllStudents();
		return ResponseEntity.ok(studentDtos);
	}
	
	@GetMapping("/ascending/students")
	private ResponseEntity<List<StudentDto>>getAllSortedStudents(@RequestParam String criteria){
		List<StudentDto>studentDtos = studentService.getAllSortedStudents(criteria);
		return ResponseEntity.ok(studentDtos);
	}
	
	@GetMapping("/pagination/students")
	private ResponseEntity<Page<StudentDto>>getStudentPage(@RequestParam Integer offset,@RequestParam Integer pagesize ){
		Page<StudentDto> studentDtos = studentService.getStudentPage(offset,pagesize);
		return ResponseEntity.ok(studentDtos);
	}
	
	@GetMapping("/pagination-and-sorting/students")
	private ResponseEntity<Page<StudentDto>>getSortedStudentPage(@RequestParam Integer offset,@RequestParam Integer pagesize ,@RequestParam String criteria){
		Page<StudentDto> studentDtos = studentService.getSortedStudentPage(offset,pagesize,criteria);
		return ResponseEntity.ok(studentDtos);
	}
	
	
}
