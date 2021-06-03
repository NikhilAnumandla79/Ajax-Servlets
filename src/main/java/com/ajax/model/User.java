package com.ajax.model;

public class User {
	private String fullname;
	private int age;
	private boolean married;
	private String gender;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String fullname, int age, boolean married, String gender) {
		super();
		this.fullname = fullname;
		this.age = age;
		this.married = married;
		this.gender = gender;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
}
