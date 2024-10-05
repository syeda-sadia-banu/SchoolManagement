package com.SchoolManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SchoolManagementSystem.model.Courses;
import com.SchoolManagementSystem.repository.CourseRepository;

@Service
public class Courseservice {
	@Autowired
	private CourseRepository courseRepository;
	
	public Courses createCourse(Courses course) {
		return courseRepository.save(course);
	}

}
