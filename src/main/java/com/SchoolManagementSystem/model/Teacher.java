package com.SchoolManagementSystem.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;
	private String teacherName;
	private String email;
	
	@ManyToMany
	@JoinTable(name="TeacherCourses",
	           joinColumns = @JoinColumn(name="teacher_id"),
	           inverseJoinColumns = @JoinColumn(name="course_id"))
	private List<Courses> courses=new ArrayList<>();
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int teacherId, String teacherName, String email) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.email = email;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTeacherId() {
		return teacherId;
	}
	
	public List<Courses> getCourses() {
		return courses;
	}
	
	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Teachers [teacherId=" + teacherId + ", teacherName=" + teacherName + ", email=" + email + "]";
	}
	
	

}
