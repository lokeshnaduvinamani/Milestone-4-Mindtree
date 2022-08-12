package com.mindtree.mystudent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mindtree.mystudent.VO.College;
import com.mindtree.mystudent.VO.ResponseTemplate;
import com.mindtree.mystudent.entity.Student;
import com.mindtree.mystudent.repository.StudentRepository;

@Service
public class StudentService 
{
	@Autowired
	private StudentRepository stdRepo;
	
	
	private RestTemplate restTemplate;


	public Student add(Student std) {
		// TODO Auto-generated method stub
		
		return stdRepo.save(std);
	}

	
	public List<Student> list() {
		// TODO Auto-generated method stub
		return stdRepo.findAll();
	}

	
	public Student searchById(long id) {
		// TODO Auto-generated method stub
		return stdRepo.findById(id);
	}

	
	public ResponseTemplate stdWithColl(long stdId) {
		// TODO Auto-generated method stub
		ResponseTemplate Res=new ResponseTemplate();
		Student std=stdRepo.findById(stdId);
		
		long coll_id=std.getColl_id();
		College coll = restTemplate.getForObject("http://MY-COLLEGE-SERVICE/college/"+coll_id,College.class);
		Res.setCollege(coll);
		Res.setStudent(std);
		return Res;
	}

	
	public Student assignCollege(long stdId, long collId) {
		// TODO Auto-generated method stub
        Student std=stdRepo.findById(stdId);
		
		College coll = restTemplate.getForObject("http://MYCOLLEGE-SERVICE/college/"+collId,College.class);
		if(std==null || coll==null)
		{
			return null;
		}
		std.setColl_id(collId);
		stdRepo.save(std);
		return std;
	}


	public List<Student> getByCollegeId(long coll_id) {
		// TODO Auto-generated method stub
		return stdRepo.getByCollId(coll_id);
	}

	
	public List<Student> getStudentByCollegeWithDescAge(long coll_id) {
		// TODO Auto-generated method stub
		return stdRepo.getStudentByCollegeWithDescAge(coll_id);
	}

}
