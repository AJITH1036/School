package com.example.school;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	public Student addStudent(Student s) {
		Student student = new Student();
		student.setName(s.getName());
		student.setMarks(s.getMarks());
		student.setSub(s.getSub());
		return studentRepo.save(s);
	}
	
	
	public List<Student> viewStudents(){
		return studentRepo.findAll();
	}

    public Optional<Student> viewStudentById(int sid) {
    	return studentRepo.findById(sid);
    }
	
	public Student update(Student s,int sid) {
		Student student = studentRepo.findById(sid).get();
		student.setName(s.getName());
		student.setMarks(s.getMarks());
		student.setSub(s.getSub());
		return studentRepo.save(student);
	}
	
	public String deleteById(int sid) {
		if(studentRepo.findById(sid).isPresent()) {
			studentRepo.deleteById(sid);
			return "deleted " + sid;
		}
		return "Incorrect id " +sid;
		
          
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
