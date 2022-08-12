package com.mindtree.mystudent.VO;

public class College 
{
	private long id;
	private String name;
	private int noOfStu;
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
	public int getNoOfStu() {
		return noOfStu;
	}
	public void setNoOfStu(int noOfStu) {
		this.noOfStu = noOfStu;
	}
	public College(long id, String name, int noOfStu) {
		super();
		this.id = id;
		this.name = name;
		this.noOfStu = noOfStu;
	}
	public College() {
		super();
	}
	
	

}
