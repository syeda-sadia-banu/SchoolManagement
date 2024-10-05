package com.SchoolManagementSystem.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Courses {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseId;
	  @Column(name = "course_name")
	private String courseName;
	  
	 @ManyToMany(mappedBy = "courses")
	private List<Teacher> teacher;
	
	
	@ManyToMany(mappedBy = "courses")
	private Set<Student> students=new HashSet<>();
	
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Courses(int courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	public List<Teacher> getTeacher() {
		return teacher;
	}
	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + "]";
	}
	
	
	

}
