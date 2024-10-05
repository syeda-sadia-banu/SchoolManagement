package com.SchoolManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SchoolManagementSystem.model.Courses;

public interface CourseRepository extends JpaRepository<Courses, Integer> {
	
	//List<Courses> getByTeacherId(int teacherId);

}
