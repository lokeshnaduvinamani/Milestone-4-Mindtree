package com.mindtree.mycollege.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.mycollege.entity.College;

public interface CollegeRepository extends JpaRepository<College,Integer>
{
	College findById(long id);
}
