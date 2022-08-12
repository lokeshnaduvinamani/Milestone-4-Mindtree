package com.mindtree.mystudent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mindtree.mystudent.entity.Student;


public interface StudentRepository extends JpaRepository<Student,Long> 
{
Student findById(long id);
	
	@Query(value="SELECT * FROM student WHERE coll_id=:coll_id ORDER BY name ASC", nativeQuery=true)
	List<Student> getByCollId(@Param("coll_id") long coll_id);
	
	@Query(value="SELECT * FROM student WHERE coll_id=:coll_id ORDER BY name DESC", nativeQuery=true)
	List<Student> getStudentByCollegeWithDescAge(@Param("coll_id") long coll_id);

}
