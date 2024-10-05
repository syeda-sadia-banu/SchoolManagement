package com.SchoolManagementSystem.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String name;
	private String email;
	
	
	@ManyToOne()
	@JoinColumn(name="class_Id")
	private Classes classes;
	
	@ManyToMany()
	@JoinTable(name="student_courses",joinColumns =
	                   @JoinColumn(name="student_id"),
	                         inverseJoinColumns =@JoinColumn(name="course_id") )
	private List<Courses> courses;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String email) {
		super();
		this.studentId = id;
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return studentId;
	}

	@Override
	public String toString() {
		return "Students [id=" + studentId + ", name=" + name + ", email=" + email + "]";
	}


}
