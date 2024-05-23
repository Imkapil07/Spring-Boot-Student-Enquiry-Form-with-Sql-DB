package in.kp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.kp.Student;
import in.kp.entity.StudentEntity;
import in.kp.repository.StudentRepository;

@Service
public class StudentService {
 
	@Autowired
	private StudentRepository repo;
	
	public boolean saveStudent(Student student) { 
		System.out.println(student);
		StudentEntity entity = new StudentEntity(); 
		BeanUtils.copyProperties(student, entity);
		System.out.println(entity);
		entity.setTimings(Arrays.toString(student.getTimings()));
		repo.save(entity);
		return true;
	}
	
	
	
	public List<String> getCourse(){
		return Arrays.asList("Java","Python","AWS","DevOps");
	}
	
	public List<String> getTimings(){
		return Arrays.asList("Morning","Afternoon","Evening");
	}
}
