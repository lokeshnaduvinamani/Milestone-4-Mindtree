package com.mindtree.mycollege.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mindtree.mycollege.VO.RequestTemplate;
import com.mindtree.mycollege.VO.Student;
import com.mindtree.mycollege.entity.College;
import com.mindtree.mycollege.repository.CollegeRepository;


@Service
public class CollegeService 
{
	@Autowired
	CollegeRepository collRepo;
	
	RestTemplate restTemplate;

	public College add(College dept) {
		// TODO Auto-generated method stub
		return collRepo.save(dept);
	}

	public List<College> list() {
		// TODO Auto-generated method stub
		
		return collRepo.findAll();
	}

	
	public College update(long id, String name) {
		// TODO Auto-generated method stub
		College dept=collRepo.findById(id);
		dept.setName(name);
		return collRepo.save(dept);
	}

	public College searchById(long id) {
		// TODO Auto-generated method stub
		if(collRepo.findById(id)==null)
		{
			return null;
		}
		return collRepo.findById(id);
	}

	public List<RequestTemplate> listwithEmp() {
		// TODO Auto-generated method stub
		List<RequestTemplate> fullList=new ArrayList<RequestTemplate>();
		List<College> allDept=this.list();
		Iterator<College> Ir=allDept.iterator();
		while(Ir.hasNext())
		{
			College col=Ir.next();
			ResponseEntity<Student[]> response=restTemplate.getForEntity("http://MY-SUDENT-SERVICE/student/student-with-ascname/"+col.getId(),Student[].class);
		    Student[] students=response.getBody();
		    List<Student> stud=Arrays.asList(students);
		    RequestTemplate Rt=new RequestTemplate();
		    Rt.setCollege(col);
		    Rt.setStudentList(stud);
		    fullList.add(Rt);
		}
		
		return fullList;
	}

	public RequestTemplate specificCollStudent(int coll_id) {
		// TODO Auto-generated method stub
		College college = this.searchById(coll_id);
		ResponseEntity<Student[]> response=restTemplate.getForEntity("http://MY-STUDENT-SERVICE/student-with-desc-age/"+college.getId(), Student[].class);
		Student[] employee=response.getBody();
		List<Student> students=Arrays.asList(employee);
		RequestTemplate requestTemplate= new RequestTemplate();
		
		requestTemplate.setCollege(college);
		requestTemplate.setStudentList(students);
		return requestTemplate;
	}

}
