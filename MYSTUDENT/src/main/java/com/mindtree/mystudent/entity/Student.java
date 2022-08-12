package com.mindtree.mystudent.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table
public class Student 
{
	@Id
	@Autowired
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String gender;
	private int age;
	private long coll_id;
	private String stream;
	public Student() {
		super();
	}
	public Student(String name, String gender, int age, long coll_id, String stream) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.coll_id = coll_id;
		this.stream = stream;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getColl_id() {
		return coll_id;
	}
	public void setColl_id(long coll_id) {
		this.coll_id = coll_id;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	
	

}
