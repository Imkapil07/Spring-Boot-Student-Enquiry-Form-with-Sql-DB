package in.kp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.kp.Student;
import in.kp.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/")
	public String loadIndexPage(Model model) { 
		formInitBinding(model);
		return "index";
	}
	
	private void formInitBinding(Model model) {
		model.addAttribute("student",new Student());
		model.addAttribute("courses", service.getCourse());
		model.addAttribute("timing", service.getTimings());
	}
	
	@PostMapping("/save")
	public String saveStudent(Student s,Model model) { 
	    boolean isSaved = service.saveStudent(s);
	    if(isSaved) {
	    model.addAttribute("msg","Data Saved...."); 
	    }
	    formInitBinding(model);
		return "index";
	}
	
}
