package com.example.school;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentService  studentService;

	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student s) {
		return studentService.addStudent(s);
	}
	
	@GetMapping("/view")
	public List<Student> viewAll(){
		return studentService.viewStudents();
	}
	
	@GetMapping("/view/{sid}")
	public Optional<Student> viewById(@PathVariable int sid){
		return studentService.viewStudentById(sid);
	}
	
	@PutMapping("/edit/{sid}")
	public Student updateById(@RequestBody Student s,@PathVariable int sid) {
		return studentService.update(s, sid);
	}
	
	@DeleteMapping("/delete/{sid}")
	public String deleteById(@PathVariable int sid) {
		return studentService.deleteById(sid);
	}
	

}
 