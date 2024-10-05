package com.SchoolManagementSystem.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Classes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classId;
	private String className;
	private int teacherId;
	@OneToMany()
	private List<Student> stud;
	
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Classes(int classId, String className, int teacherId) {
		super();
		this.classId = classId;
		this.className = className;
		this.teacherId = teacherId;
	}
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	
	public List<Student> getStudents() {
		return stud;
	}

	public void setStudents(List<Student> students) {
		this.stud = students;
	}

	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", className=" + className + ", teacherId=" + teacherId + "]";
	}
	
	

}
