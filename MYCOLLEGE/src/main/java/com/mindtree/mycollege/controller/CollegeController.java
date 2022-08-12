package com.mindtree.mycollege.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.mycollege.VO.RequestTemplate;
import com.mindtree.mycollege.entity.College;
import com.mindtree.mycollege.service.CollegeService;

@RestController
@RequestMapping("/mycollege")
public class CollegeController 
{
	@Autowired
	CollegeService collService;
	
	@PostMapping
	public College add(@RequestBody College coll)
	{
		return collService.add(coll);
	}
	
	@GetMapping
	public List<College> list()
	{
		return collService.list();
	}
	
	@GetMapping("/{id}")
	public College searchById(@PathVariable long id)
	{
		return collService.searchById(id);
	}
	
	@GetMapping("/all-mycollege-student")
	public List<RequestTemplate> listwithEmp()
	{
		return collService.listwithEmp();
	}
	
	@GetMapping("/mycollege-with-student/{coll_id}")
	public RequestTemplate specificationDeptEmp(@PathVariable int coll_id)
	{
		return collService.specificCollStudent(coll_id);
	}

}
