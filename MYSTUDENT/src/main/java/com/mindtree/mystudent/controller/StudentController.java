package com.mindtree.mystudent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.mystudent.VO.ResponseTemplate;
import com.mindtree.mystudent.entity.Student;
import com.mindtree.mystudent.service.StudentService;


@RestController
@RequestMapping("/mystudent")
public class StudentController 
{
	@Autowired
	StudentService stdService;
	
	@PostMapping
	public Student add(@RequestBody Student std)
	{
		return stdService.add(std);
	}
	
	@GetMapping
	public List<Student> listEmpp()
	{
		return stdService.list();
	}
	
	@GetMapping("/{stdId}")
	public ResponseTemplate empWithDept(@PathVariable long stdId)
	{
		return stdService.stdWithColl(stdId);
	}
	
	@GetMapping("/{stdId}/{collId}")
	public String updateDepartment(@PathVariable long empId,@PathVariable long deptId)
	{
		Student emp=stdService.assignCollege(empId, deptId);
		if(emp!=null)
		{
			return emp.toString();		
		}
		return "sorry not found";
	}
	
	@GetMapping("/student-with-ascingingname/{coll_id}")
	public List<Student> getByDeptId(@PathVariable long coll_id)
	{
		return stdService.getByCollegeId(coll_id);
	}
	
	@GetMapping("/student-with-descinding-age/{coll_id}")
	public List<Student> getEmployeeByDepartmentWithDescAge(@PathVariable long coll_id)
	{
		return stdService.getStudentByCollegeWithDescAge(coll_id);
	}

}
